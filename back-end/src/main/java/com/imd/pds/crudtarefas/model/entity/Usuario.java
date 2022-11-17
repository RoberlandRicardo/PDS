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
	private Long idusuario;
	
	@Column(name = "nomeusuario")
	private String nomeusuario;
	
	@Column(name = "emailusuario")
	private String emailusuario;
	
	@Column(name = "senhausuario")
	private String senhausuario;

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNomeusuario() {
		return nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

	public String getEmailusuario() {
		return emailusuario;
	}

	public void setEmailusuario(String emailusuario) {
		this.emailusuario = emailusuario;
	}

	public String getSenhausuario() {
		return senhausuario;
	}

	public void setSenhausuario(String senhausuario) {
		this.senhausuario = senhausuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailusuario, idusuario, nomeusuario, senhausuario);
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
		return Objects.equals(emailusuario, other.emailusuario) && Objects.equals(idusuario, other.idusuario)
				&& Objects.equals(nomeusuario, other.nomeusuario) && Objects.equals(senhausuario, other.senhausuario);
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nomeusuario=" + nomeusuario + ", emailusuario=" + emailusuario
				+ ", senhausuario=" + senhausuario + "]";
	}
}
