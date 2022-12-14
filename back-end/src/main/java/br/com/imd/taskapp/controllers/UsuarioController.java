package br.com.imd.taskapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imd.taskapp.entities.Usuario;
import br.com.imd.taskapp.repositories.UsuarioRepository;
import br.com.imd.taskapp.services.UsuarioService;


@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping
	public Usuario createUser(@RequestBody Usuario user) {
		return service.createUser(user);
	}
	
	@GetMapping(value = "/{id}")
	public Usuario getUserById( @PathVariable Long id ) {
		Usuario result = repository.findById(id).get();
		return result;
	}
	
	@GetMapping
	public List<Usuario> getAllUsers(){
		List<Usuario> result = repository.findAll();
		return result;
	}
	
	@DeleteMapping(value = "/{id}")
	public void removeUser( @PathVariable long id ) {
		try {
			repository.deleteById(id);
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
