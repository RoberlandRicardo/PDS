package br.com.imd.taskapp.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.imd.taskapp.entities.Tarefa;
import br.com.imd.taskapp.enums.StatusTarefa;
import br.com.imd.taskapp.repositories.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	public Tarefa createTarefa( Tarefa task, String taskDate ) {
		task.setStatus(StatusTarefa.INICIALIZADO);
		if( taskDate.equals("")) {
			task.setDate(LocalDate.now());
		}
		else {
			try {
				task.setDate(LocalDate.parse(taskDate));
			} catch( Exception e) {
				e.printStackTrace();
				return new Tarefa();
			}
		}
		
		Tarefa result = tarefaRepository.save(task);
		return result;
	}
	
	//funcao que aparece as tarefas de acordo com o usuario
	
	public Page<Tarefa> filtraTarefaPorUsuario(long id, Pageable pageable){
		
		return tarefaRepository.filtraTarefaPorUsuario(id, pageable);
	}
}
