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
@Table(name = "tag", schema = "tarefas")
public class Tag {
	
	@Id
	@Column(name = "idtag")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTag;
	
	@ManyToOne
	@JoinColumn(name = "tarefa_idtarefa")
	private Tarefa tarefaIdTarefa;
	
	@Column(name = "nometag")
	private String nomeTag;

	public Long getIdTag() {
		return idTag;
	}

	public void setIdTag(Long idTag) {
		this.idTag = idTag;
	}

	public Tarefa getTarefaIdTarefa() {
		return tarefaIdTarefa;
	}

	public void setTarefaIdTarefa(Tarefa tarefaIdTarefa) {
		this.tarefaIdTarefa = tarefaIdTarefa;
	}

	public String getNomeTag() {
		return nomeTag;
	}

	public void setNomeTag(String nomeTag) {
		this.nomeTag = nomeTag;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTag, nomeTag, tarefaIdTarefa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		return Objects.equals(idTag, other.idTag) && Objects.equals(nomeTag, other.nomeTag)
				&& Objects.equals(tarefaIdTarefa, other.tarefaIdTarefa);
	}

	@Override
	public String toString() {
		return "Tag [idTag=" + idTag + ", tarefaIdTarefa=" + tarefaIdTarefa + ", nomeTag=" + nomeTag + "]";
	}	

}
