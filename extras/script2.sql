CREATE DATABASE bioextratus;

USE bioextratus;
show tables;

CREATE TABLE cidade(id_cidade INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
					nome CHAR(25) NOT NULL,
					uf CHAR(2) NOT NULL);
					

CREATE TABLE cliente(id_cliente INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
					nome VARCHAR(60),
					endereco VARCHAR(60), 
					numero CHAR(7),
					bairro VARCHAR(60), 
					complemento VARCHAR(60),
					telefone CHAR(15), 
					celular CHAR(15),
					id_cidade INTEGER,
					cep char(9),
					tipo_cliente char(1),
					cpf CHAR(11),
					cnpj CHAR(15), 
					ie CHAR(20),
					email char(40),
					FOREIGN KEY(id_cidade)
					REFERENCES cidade(id_cidade) ON DELETE RESTRICT);

CREATE TABLE linha(id_linha INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, nome VARCHAR(40),
					descricao VARCHAR(100) NOT NULL);
					
CREATE TABLE produto(id_produto INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, descricao VARCHAR(100),
					preco DECIMAL(5,2) NOT NULL, status BOOLEAN NOT NULL,
					id_linha INTEGER,
					FOREIGN KEY(id_linha)
					REFERENCES linha(id_linha));
					
					
CREATE TABLE pedido(id_pedido INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
					descricao varchar(100),
					valor_total DECIMAL(7,2),
					id_cliente INTEGER,
					data date,
					FOREIGN KEY(id_cliente)
					REFERENCES cliente(id_cliente) ON DELETE RESTRICT);
					
CREATE TABLE pedido_item(id_pedido_item INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
						id_pedido INTEGER,
						id_produto INTEGER,
						quantidade INTEGER, 
						preco_total DECIMAL(7,2),
						FOREIGN KEY(id_pedido)
						REFERENCES pedido(id_pedido) ON DELETE RESTRICT,
						FOREIGN KEY(id_produto)
						REFERENCES produto(id_produto) ON DELETE RESTRICT);

SELECT * FROM Cidade;
