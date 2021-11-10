CREATE TABLE logradouro (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	rua VARCHAR(50) NOT NULL,
	bairro VARCHAR(50) NOT NULL
);

INSERT INTO logradouro (rua, bairro) values ('Rua A', 'Bairro A');
INSERT INTO logradouro (rua, bairro) values ('Rua B', 'Bairro A');
INSERT INTO logradouro (rua, bairro) values ('Rua C', 'Bairro B');
INSERT INTO logradouro (rua, bairro) values ('Rua D', 'Bairro D');