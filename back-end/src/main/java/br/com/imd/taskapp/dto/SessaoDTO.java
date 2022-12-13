package br.com.imd.taskapp.dto;

import br.com.imd.taskapp.entities.Usuario;

public class SessaoDTO {
	
	private long id;
	private String email;
	private String nome;
	private String token;
	
	public SessaoDTO(Usuario usuario, String token) {
		this.id = usuario.getId();
		this.email = usuario.getEmail();
		this.nome = usuario.getNome();
		this.token = token;
	}
	
	public SessaoDTO(String email, String nome, String token) {
		this.email = email;
		this.nome = nome;
		this.token = token;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setUsuario(String nome) {
		this.nome = nome;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
