package br.com.imd.taskapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imd.taskapp.entities.Usuario;
import br.com.imd.taskapp.repositories.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping
	public Usuario insert(@RequestBody Usuario user) {
		Usuario result = repository.save(user);
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Usuario findById( @PathVariable Long id ) {
		Usuario result = repository.findById(id).get();
		return result;
	}
	
	@GetMapping
	public List<Usuario> findAll(){
		List<Usuario> result = repository.findAll();
		return result;
	}

}
