CREATE TABLE cliente (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
);

INSERT INTO cliente (nome) values ('Maria');
INSERT INTO cliente (nome) values ('Luis');
INSERT INTO cliente (nome) values ('João');
INSERT INTO cliente (nome) values ('Mario');