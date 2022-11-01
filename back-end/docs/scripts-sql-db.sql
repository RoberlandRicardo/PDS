
CREATE database crudtarefas;

create schema tarefas;

CREATE TABLE tarefas.usuario
(
	idusuario bigserial NOT NULL PRIMARY KEY,
    nomeusuario character varying(50) NOT NULL,
  	emailusuario character varying(50) NOT NULL,
  	senhausuario character varying(50) NOT NULL
);


