package br.com.imd.taskapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imd.taskapp.entities.Tarefa;
import br.com.imd.taskapp.repositories.TarefaRepository;

@RestController
@RequestMapping(value="/tarefa")
public class TarefaController {
	
	@Autowired
	private TarefaRepository repository;
	
	//create
	@PostMapping
	public Tarefa createTarefa(@RequestBody Tarefa task) {
		Tarefa result = repository.save(task);
		return result;
	}
	
	//delete
	@DeleteMapping(value = "/{id}")
	public void deleteTarefa(@PathVariable long id) {
		try {
			repository.deleteById(id);
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	//findAll
	@GetMapping
	public List<Tarefa> getAllTarefas(){
		List<Tarefa> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value="/{id}")
	public Tarefa getTarefaById(@PathVariable long id) {
		Tarefa result = repository.findById(id).get();
		return result;
	}

}
