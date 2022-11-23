package com.imd.pds.crudtarefas.model.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasklist", schema = "tarefas")
public class TaskList {
	
	@Id
	@Column(name = "idtasklist")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTaskList;
	
	@Column(name = "descricaotasklist")
	private String descricaoTaskList;

	public Long getIdTaskList() {
		return idTaskList;
	}

	public void setIdTaskList(Long idTaskList) {
		this.idTaskList = idTaskList;
	}

	public String getDescricaoTaskList() {
		return descricaoTaskList;
	}

	public void setDescricaoTaskList(String descricaoTaskList) {
		this.descricaoTaskList = descricaoTaskList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricaoTaskList, idTaskList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskList other = (TaskList) obj;
		return Objects.equals(descricaoTaskList, other.descricaoTaskList)
				&& Objects.equals(idTaskList, other.idTaskList);
	}

	@Override
	public String toString() {
		return "TaskList [idTaskList=" + idTaskList + ", descricaoTaskList=" + descricaoTaskList + "]";
	}
	
}
