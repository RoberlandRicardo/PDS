package br.com.imd.taskapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imd.taskapp.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
