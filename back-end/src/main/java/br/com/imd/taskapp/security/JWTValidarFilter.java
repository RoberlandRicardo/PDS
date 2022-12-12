package br.com.imd.taskapp.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTValidarFilter extends BasicAuthenticationFilter {
	
	private static final String HEADER_ATRIBUTO = "Authorization";
	private static final String ATRIBUTO_BEARER = "Bearer ";
	
	public JWTValidarFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		
		String atributo = request.getHeader(HEADER_ATRIBUTO);
		
		if (atributo == null) {
			filterChain.doFilter(request, response);
			return;
		}
		
		if (!atributo.startsWith(ATRIBUTO_BEARER)) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String token = atributo.replace(ATRIBUTO_BEARER, "");
		UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(token);
		
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		filterChain.doFilter(request, response);
	}
	
	private UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
		String usuario = JWT.require(Algorithm.HMAC512(JWTAutenticarFilter.TOKEN_SENHA)).build().verify(token).getSubject();
		
		if (usuario == null)
			return null;
		
		return new UsernamePasswordAuthenticationToken(usuario, null, new ArrayList<>());
	}
}
