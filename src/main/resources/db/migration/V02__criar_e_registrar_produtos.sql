CREATE TABLE produto (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	valor DECIMAL(10,2) NOT NULL,
	codigo_categoria BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo)
);

INSERT INTO produto (nome, valor, codigo_categoria) values ('analgésico', 10.00, 1);
INSERT INTO produto (nome, valor, codigo_categoria) values ('antibiótico', 11.00, 1);
INSERT INTO produto (nome, valor, codigo_categoria) values ('shampoo', 6.00, 2);
INSERT INTO produto (nome, valor, codigo_categoria) values ('sabonete líquido', 4.00, 2);
INSERT INTO produto (nome, valor, codigo_categoria) values ('iphone 13', 20.00, 3);