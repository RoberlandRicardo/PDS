package br.com.imd.taskapp.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.imd.taskapp.data.DetalheUsuarioData;
import br.com.imd.taskapp.entities.Usuario;
import br.com.imd.taskapp.repositories.UsuarioRepository;

@Component
public class DetalheUsuarioService implements UserDetailsService {
	
	private final UsuarioRepository repository;
	
	public DetalheUsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByEmail(username);
		if (usuario.isEmpty())
			throw new UsernameNotFoundException("Email " + username + " não encontrado");
		
		return new DetalheUsuarioData(usuario);
	}

}
