package com.imd.pds.crudtarefas.model.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tarefa_has_tasklist", schema = "tarefas")
public class TarefaHasTasklist {
	
	@Id
	@Column(name = "id_tarefa_has_tasklist")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tarefa_has_tasklist;
	
	@ManyToOne
	@JoinColumn(name = "tasklist_idtasklist")
	private TaskList taskList;
	
	@ManyToOne
	@JoinColumn(name = "tarefa_idtarefa")
	private Tarefa tarefa;

	public Long getId_tarefa_has_tasklist() {
		return id_tarefa_has_tasklist;
	}

	public void setId_tarefa_has_tasklist(Long id_tarefa_has_tasklist) {
		this.id_tarefa_has_tasklist = id_tarefa_has_tasklist;
	}

	public TaskList getTaskList() {
		return taskList;
	}

	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_tarefa_has_tasklist, tarefa, taskList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TarefaHasTasklist other = (TarefaHasTasklist) obj;
		return Objects.equals(id_tarefa_has_tasklist, other.id_tarefa_has_tasklist)
				&& Objects.equals(tarefa, other.tarefa) && Objects.equals(taskList, other.taskList);
	}

	@Override
	public String toString() {
		return "TarefaHasTasklist [id_tarefa_has_tasklist=" + id_tarefa_has_tasklist + ", taskList=" + taskList
				+ ", tarefa=" + tarefa + "]";
	}

}
