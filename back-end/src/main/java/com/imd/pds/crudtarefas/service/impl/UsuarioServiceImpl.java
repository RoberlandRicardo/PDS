package com.imd.pds.crudtarefas.service.impl;

import org.springframework.stereotype.Service;

import com.imd.pds.crudtarefas.exception.RegraNegocioException;
import com.imd.pds.crudtarefas.model.entity.Usuario;
import com.imd.pds.crudtarefas.model.repository.UsuarioRepository;
import com.imd.pds.crudtarefas.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository repository;		

	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {

		return null;
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {

		return null;
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existByEmailUsuario(email);
		if(existe) {
			throw new RegraNegocioException("Email já cadastrado!");
		}
	}
}
