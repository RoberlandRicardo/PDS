package com.imd.pds.crudtarefas.model.entity;

import java.time.LocalDate;

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

import com.imd.pds.crudtarefas.model.enums.StatusTarefa;

import lombok.Data;

@Data
@Entity
@Table(name = "tarefa", schema = "tarefas")
public class Tarefa {
	
	@Id
	@Column(name = "idtarefa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTarefa;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario idUsuario;
	
	@Column(name = "descricaotarefa")
	private String descricaoTarefa;
	
	@Column(name = "datarefa")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataTarefa;
	
	@Column(name = "statustarefa")
	@Enumerated(value = EnumType.STRING)
	private StatusTarefa statusTarefa;
	
}
