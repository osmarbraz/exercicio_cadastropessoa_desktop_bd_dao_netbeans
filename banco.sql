#criar o database chamado exercicio
create database if not exists exercicio;

#entrar no database exercicio
use exercicio;

#remove a tabela para recriá-la
drop table if exists Pessoa;

#cria a tabela de pessoa
CREATE TABLE Pessoa (
	pessoaID       INTEGER NOT NULL AUTO_INCREMENT,    	 
	nome           VARCHAR(50) NOT NULL,     
	idade          INTEGER,	
	dataNascimento Date,
	cidade         VARCHAR(25),
	estadoCivil    VARCHAR(20),	
	PRIMARY KEY(pessoaID)    
);

#lista a tabela criada
show tables;
