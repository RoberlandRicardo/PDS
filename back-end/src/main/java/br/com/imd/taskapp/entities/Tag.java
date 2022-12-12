package br.com.imd.taskapp.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tag")
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="idtarefa")
	private long idTarefa;
	
	@Column(name="nometag")
	private String nome;
	
	@ManyToMany(mappedBy="tags")
	private List<Tarefa> tarefas;
	
	public Tag() {
		
	}

	public Tag(long id, long idTarefa, String nome) {
		this.id = id;
		this.idTarefa = idTarefa;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(long idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
