
CREATE database crudtarefas;

create schema tarefas;

CREATE TABLE tarefas.Usuario (
  idUsuario BIGSERIAL NOT NULL,
  nomeUsuario VARCHAR(50) NOT NULL,
  emailUsuario VARCHAR(50) NOT NULL,
  senhaUsuario VARCHAR(50) NOT NULL,
  PRIMARY KEY(idUsuario)
);

CREATE TABLE tarefas.Projeto (
  idProjeto BIGSERIAL NOT NULL,
  Usuario_idUsuario BIGINT REFERENCES tarefas.usuario (idUsuario),
  PRIMARY KEY(idProjeto)
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
  Projeto_idProjeto BIGINT NOT NULL,
  descricaoTarefa VARCHAR(100) NOT NULL,
  dataTarefa DATE DEFAULT NOW() NOT NULL,
  horario TIME NOT NULL,
  statusTabela VARCHAR(50) CHECK (statusTabela IN ('Não iniciado', 'Em andamento', 'Finalizado')) NOT NULL,
  PRIMARY KEY(idTarefa),
  FOREIGN KEY(Projeto_idProjeto)
    REFERENCES tarefas.Projeto(idProjeto)
);

SELECT * FROM tarefas.Tarefa;

CREATE TABLE tarefas.Tag (
  idTag BIGSERIAL NOT NULL,
  Tarefa_idTarefa BIGINT NOT NULL,
  nomeTag VARCHAR(50) NOT NULL,
  PRIMARY KEY(idTag),
  FOREIGN KEY(Tarefa_idTarefa)
    REFERENCES tarefas.Tarefa(idTarefa)
);

select * from tarefas.Tag;

CREATE TABLE tarefas.Tasklist (
  idTasklist BIGSERIAL NOT NULL,
  descricaoTasklist VARCHAR(100) NOT NULL,
  PRIMARY KEY(idTasklist)
);

SELECT * FROM tarefas.Tasklist;

CREATE TABLE tarefa_has_tasklist (
  id_Tarefa_has_tasklist BIGSERIAL NOT NULL,
  Tasklist_idTasklist BIGINT NOT NULL,
  Tarefa_idTarefa BIGINT NOT NULL,
  FOREIGN KEY(Tarefa_idTarefa)
    REFERENCES tarefas.Tarefa(idTarefa),
  FOREIGN KEY(Tasklist_idTasklist)
    REFERENCES tarefas.Tasklist(idTasklist)
);

SELECT * FROM tarefa_has_tasklist;

