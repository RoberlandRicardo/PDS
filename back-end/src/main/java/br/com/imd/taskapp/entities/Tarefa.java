package br.com.imd.taskapp.entities;

import java.time.LocalDate;
import java.util.List;

import br.com.imd.taskapp.enums.StatusTarefa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tarefa")
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="idusuario")
	private long idUsuario;
	
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

	public Tarefa(long id, long idUsuario, String descricao, LocalDate date, StatusTarefa status) {
		this.id = id;
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
