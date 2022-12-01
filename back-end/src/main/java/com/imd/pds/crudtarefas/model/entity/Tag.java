package com.imd.pds.crudtarefas.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tag", schema = "tarefas")
public class Tag {
	
	@Id
	@Column(name = "idtag")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTag;
	
	@ManyToOne
	@JoinColumn(name = "idtarefa")
	private Tarefa idTarefa;
	
	@Column(name = "nometag")
	private String nomeTag;

}
