package br.com.imd.taskapp.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.imd.taskapp.enums.StatusTarefa;

@Entity
@Table(name="tarefa")
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="idusuario")
	private long idUsuario;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="descricaotarefa")
	private String descricao;
	
	@Column(name="datatarefa")
	private LocalDate date;
	
	@Column(name="statustarefa")
	private StatusTarefa status;
	
	@ManyToMany
	@JoinTable(
			name="tarefa_tag",
			joinColumns= @JoinColumn(name="idtarefa"),
			inverseJoinColumns= @JoinColumn(name="idtag")
			)
	private List<Tag> tags;
	
	public Tarefa() {
		
	}

	public Tarefa(long id, String nome, long idUsuario, String descricao, LocalDate date, StatusTarefa status) {
		this.id = id;
		this.nome = nome;
		this.idUsuario = idUsuario;
		this.descricao = descricao;
		this.date = date;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public StatusTarefa getStatus() {
		return status;
	}

	public void setStatus(StatusTarefa status) {
		this.status = status;
	}
	
	
}
