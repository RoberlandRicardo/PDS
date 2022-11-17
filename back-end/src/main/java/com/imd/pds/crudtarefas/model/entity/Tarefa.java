package com.imd.pds.crudtarefas.model.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@Entity
@Table(name = "tarefa", schema = "tarefas")
public class Tarefa {
	
	@Id
	@Column(name = "idtarefa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTarefa;
	
	@ManyToOne
	@JoinColumn(name = "projeto_idprojeto")
	private Projeto projeto;
	
	@Column(name = "descricaotarefa")
	private String descricaoTarefa;
	
	@Column(name = "datarefa")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataTarefa;
	
	@Column(name = "horario")
	private String horario;
	
	@Column(name = "statustarefa")
	@Enumerated(value = EnumType.STRING)
	private StatusTarefa statusTarefa;

	public Long getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(Long idTarefa) {
		this.idTarefa = idTarefa;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}

	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}

	public LocalDate getDataTarefa() {
		return dataTarefa;
	}

	public void setDataTarefa(LocalDate dataTarefa) {
		this.dataTarefa = dataTarefa;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public StatusTarefa getStatusTarefa() {
		return statusTarefa;
	}

	public void setStatusTarefa(StatusTarefa statusTarefa) {
		this.statusTarefa = statusTarefa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataTarefa, descricaoTarefa, horario, idTarefa, projeto, statusTarefa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(dataTarefa, other.dataTarefa) && Objects.equals(descricaoTarefa, other.descricaoTarefa)
				&& Objects.equals(horario, other.horario) && Objects.equals(idTarefa, other.idTarefa)
				&& Objects.equals(projeto, other.projeto) && statusTarefa == other.statusTarefa;
	}

	@Override
	public String toString() {
		return "Tarefa [idTarefa=" + idTarefa + ", projeto=" + projeto + ", descricaoTarefa=" + descricaoTarefa
				+ ", dataTarefa=" + dataTarefa + ", horario=" + horario + ", statusTarefa=" + statusTarefa + "]";
	}	
}
