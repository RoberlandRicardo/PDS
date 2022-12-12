package br.com.imd.taskapp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.imd.taskapp.entities.Usuario;
import br.com.imd.taskapp.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//metodo de add tarefa e adicionar a tarefa na lista de tarefas do usuário.
	public Usuario createUser(Usuario user) {
		Usuario result = usuarioRepository.save(user);
		return result;
	}
	
	
	
}
