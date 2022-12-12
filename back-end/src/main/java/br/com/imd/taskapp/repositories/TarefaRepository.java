package br.com.imd.taskapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.imd.taskapp.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	
	@Query("select t from Tarefa t where t.idUsuario = :id order by t.date ASC")
	Page<Tarefa> filtraTarefaPorUsuario(long id, Pageable pageable);
}
