package br.com.imd.taskapp.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import br.com.imd.taskapp.data.DetalheUsuarioData;
import br.com.imd.taskapp.dto.SessaoDTO;
import br.com.imd.taskapp.entities.Usuario;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {
	
	public static final String TOKEN_SENHA = "c6b5a43f-45df-4aad-b7e2-e4b5ee0a1d49";
	public static final int TOKEN_EXPIRACAO = 600_000;
	private final AuthenticationManager authenticationManager;
	
	public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {
			Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					usuario.getEmail(), 
					usuario.getSenha(),
					new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException("Falha ao autenticar o usuário");
		}
	}
	
	@Override
	public void successfulAuthentication(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		DetalheUsuarioData usuarioData = (DetalheUsuarioData) authResult.getPrincipal();
		
		String token = JWT.create()
				.withSubject(usuarioData.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
				.sign(Algorithm.HMAC512(TOKEN_SENHA));
		
		SessaoDTO sessao = new SessaoDTO(usuarioData.getUsuario(), token);
		String jsonSessao = new Gson().toJson(sessao);
		
		response.setContentType("application/json");
		response.getWriter().write(jsonSessao);
		response.getWriter().flush();
	}
	
	
}
