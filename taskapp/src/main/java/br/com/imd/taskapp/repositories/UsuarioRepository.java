package br.com.imd.taskapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imd.taskapp.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}
