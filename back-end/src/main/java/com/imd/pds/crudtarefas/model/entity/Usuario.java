package com.imd.pds.crudtarefas.model.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public Long getIdusuario() {
		return idUsuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idUsuario = idusuario;
	}

	public String getNomeusuario() {
		return nomeUsuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeUsuario = nomeusuario;
	}

	public String getEmailusuario() {
		return emailUsuario;
	}

	public void setEmailusuario(String emailusuario) {
		this.emailUsuario = emailusuario;
	}

	public String getSenhausuario() {
		return senhaUsuario;
	}

	public void setSenhausuario(String senhausuario) {
		this.senhaUsuario = senhausuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailUsuario, idUsuario, nomeUsuario, senhaUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(emailUsuario, other.emailUsuario) && Objects.equals(idUsuario, other.idUsuario)
				&& Objects.equals(nomeUsuario, other.nomeUsuario) && Objects.equals(senhaUsuario, other.senhaUsuario);
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idUsuario + ", nomeusuario=" + nomeUsuario + ", emailusuario=" + emailUsuario
				+ ", senhausuario=" + senhaUsuario + "]";
	}
}
