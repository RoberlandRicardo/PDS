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
@Table(name = "projeto", schema = "tarefas")
public class Projeto {
	
	@Id
	@Column(name = "idprojeto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProjeto;
		
	@ManyToOne
	@JoinColumn(name = "usuario_idusuario")
	private Usuario usuario;

	public Long getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(Long idProjeto) {
		this.idProjeto = idProjeto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProjeto, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		return Objects.equals(idProjeto, other.idProjeto) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Projeto [idProjeto=" + idProjeto + ", usuario=" + usuario + "]";
	}	
}
