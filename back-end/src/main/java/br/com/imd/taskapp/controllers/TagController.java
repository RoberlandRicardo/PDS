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

import br.com.imd.taskapp.entities.Tag;
import br.com.imd.taskapp.repositories.TagRepository;

@RestController
@RequestMapping(value = "/tag")
public class TagController {
	
	@Autowired
	TagRepository repository;
	
	@GetMapping
	public List<Tag> findAllTag(){
		List<Tag> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Tag findTagById(@PathVariable long id ) {
		Tag result = repository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public Tag createTag(@RequestBody Tag tag) {
		Tag result = repository.save(tag);
		return result;
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteTag(@PathVariable long id) {
		repository.deleteById(id);
	}
}
