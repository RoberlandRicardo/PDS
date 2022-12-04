package com.imd.pds.crudtarefas.model.repository;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.imd.pds.crudtarefas.model.entity.Usuario;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		//cenário
		Usuario usuario = Usuario.builder().nomeUsuario("elildes").emailUsuario("elildes@exemplo.com").build();
		repository.save(usuario);
		
		//ação/execução
		boolean result = repository.existByEmailUsuario("elildes@exemplo.com");		
		
		//verificação
		Assertions.assertThat(result).isTrue();
	}
	
}
