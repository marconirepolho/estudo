CREATE TABLE categoria (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
);

INSERT INTO categoria (nome) values ('Medicamento');
INSERT INTO categoria (nome) values ('Higiene');
INSERT INTO categoria (nome) values ('Outros');