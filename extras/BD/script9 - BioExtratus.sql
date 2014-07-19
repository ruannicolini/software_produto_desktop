CREATE DATABASE bioextratus;

USE bioextratus;


CREATE TABLE Cidade(idCidade INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
					nome VARCHAR(30) NOT NULL,
					uf CHAR(2) NOT NULL);

CREATE TABLE Configuracoes(idConfiguracoes INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
					nomeVendedor VARCHAR(60) NOT NULL,
					enderecoVendedor VARCHAR(120),
					telFixoVendedor CHAR(30), 
					telCelVendedor CHAR(30),					
					emailVendedor char(80),
					emailEnvioPedido char(80)

);

-- Alter Table Configuracoes modify emailEnvioPedido char(80) --

insert into Configuracoes(nomeVendedor, enderecoVendedor, telFixoVendedor, telCelVendedor, emailVendedor, emailEnvioPedido)values('','','','','','');

CREATE TABLE Cliente(idCliente INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
					nome VARCHAR(60),
					endereco VARCHAR(60), 
					numero CHAR(7),
					bairro VARCHAR(60), 
					complemento VARCHAR(60),
					telFixo CHAR(15), 
					telCel CHAR(15),
					idCidade INTEGER,
					cep char(9),
					tipoCliente char(1),
					email char(40),
					FOREIGN KEY(idCidade)
					REFERENCES Cidade(idCidade) ON DELETE RESTRICT);

CREATE TABLE PessoaFisica( 
					cpf CHAR(11),
					idCliente integer PRIMARY KEY ,
					FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente) ON DELETE RESTRICT);

CREATE TABLE PessoaJuridica(
					cnpj CHAR(15), 
					ie CHAR(20),
					idCliente integer PRIMARY KEY,
					FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente) ON DELETE RESTRICT);

CREATE TABLE Linha(
					idLinha INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
					nome VARCHAR(40),
					descricao VARCHAR(100) NOT NULL);
					
CREATE TABLE TipoProduto(
					idTipo INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
					descricao VARCHAR(60),
					unVenda VARCHAR(10),
					porcentagem int);


CREATE TABLE Produto(idProduto INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
					descricao VARCHAR(100),
					preco Float(5,2) NOT NULL, 
					statusVenda BOOLEAN NOT NULL,
					idLinha INTEGER,

					idTipo INTEGER,

					FOREIGN KEY(idLinha)
					REFERENCES Linha(idLinha)ON DELETE RESTRICT,

					FOREIGN KEY(idTipo)
					REFERENCES TipoProduto(idTipo)ON DELETE RESTRICT);
					
					
CREATE TABLE Pedido(idPedido INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
					descricao varchar(100),
					valorTotal Float(7,2),
					idCliente INTEGER,
					data date,
					FOREIGN KEY(idCliente)
					REFERENCES Cliente(idCliente) ON DELETE RESTRICT);
					
CREATE TABLE PedidoItem(idPedidoItem INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
						idPedido INTEGER,
						idProduto INTEGER,
						quantidade INTEGER,
						precoUnitario float(7,2), 
						precoParcial float(7,2),
						FOREIGN KEY(idPedido)
						REFERENCES Pedido(idPedido) ON DELETE RESTRICT,
						FOREIGN KEY(idProduto)
						REFERENCES Produto(idProduto) ON DELETE RESTRICT);


/* inserção de dados*/

INSERT INTO TIPOPRODUTO(DESCRICAO, UNVENDA, porcentagem)VALUES('SHAMPOO','PCT X 12', 7);
INSERT INTO TIPOPRODUTO(DESCRICAO, UNVENDA, porcentagem)VALUES('CONDICIONADOR','PCT X 12',7);
INSERT INTO TIPOPRODUTO(DESCRICAO, UNVENDA, porcentagem)VALUES('SABONETE LIQUIDO','1UN',7);
INSERT INTO TIPOPRODUTO(DESCRICAO, UNVENDA, porcentagem)VALUES('CREME','PCT X 12',7);
INSERT INTO TIPOPRODUTO(DESCRICAO, UNVENDA, porcentagem)VALUES('FINALIZADOR','UN',7);
