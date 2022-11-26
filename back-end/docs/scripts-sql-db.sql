CREATE database crudtarefas;

create schema tarefas;

CREATE TABLE tarefas.Usuario (
  idUsuario BIGSERIAL NOT NULL,
  nomeUsuario VARCHAR(50) NOT NULL,
  emailUsuario VARCHAR(50) NOT NULL,
  senhaUsuario VARCHAR(50) NOT NULL,
  PRIMARY KEY(idUsuario)
);

INSERT INTO tarefas.usuario (nomeUsuario, emailUsuario, senhaUsuario)
VALUES ('elildes', 'elildes@exemplo.com', '1234');

INSERT INTO tarefas.usuario (nomeUsuario, emailUsuario, senhaUsuario)
VALUES ('joaquim', 'joaquim@exemplo.com', '1234');

INSERT INTO tarefas.usuario (nomeUsuario, emailUsuario, senhaUsuario)
VALUES ('roberland', 'roberland@exemplo.com', '1234');

SELECT * from tarefas.Usuario;

CREATE TABLE tarefas.Tarefa (
	idTarefa BIGSERIAL NOT NULL,
	idUsuario BIGINT NOT NULL,
  	descricaoTarefa VARCHAR(100) NOT NULL,
  	dataTarefa DATE DEFAULT NOW() NOT NULL,
  	statusTarefa VARCHAR(50) CHECK (statusTarefa IN ('Não iniciado', 'Em andamento', 'Finalizado')) NOT NULL,
  	PRIMARY KEY(idTarefa),
	FOREIGN KEY(idUsuario) REFERENCES tarefas.usuario(idUsuario)
);

drop table if exists tarefas.tarefa

insert into tarefas.Tarefa(idUsuario,
						  descricaoTarefa,
						  statusTarefa) values(
						  1, 'arrumar a casa','Em andamento')

SELECT * FROM tarefas.Tarefa;

CREATE TABLE tarefas.Tag (
  idTag BIGSERIAL NOT NULL,
  idTarefa BIGINT NOT NULL,
  nomeTag VARCHAR(50) NOT NULL,
  PRIMARY KEY(idTag),
  FOREIGN KEY(idTarefa)
    REFERENCES tarefas.Tarefa(idTarefa)
);

insert into tarefas.tag(
idTarefa, nomeTag) values (1,
						  'casa')

select * from tarefas.Tag;
