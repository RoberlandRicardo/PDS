package com.imd.pds.crudtarefas.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "usuario", schema = "tarefas")
public class Usuario {
	
	@Id
	@Column(name = "idusuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Column(name = "nomeusuario")
	private String nomeUsuario;
	
	@Column(name = "emailusuario")
	private String emailUsuario;
	
	@Column(name = "senhausuario")
	private String senhaUsuario;
	
}
