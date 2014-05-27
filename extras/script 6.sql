CREATE DATABASE bioextratus1;

USE bioextratus1;


CREATE TABLE cidade(idCidade INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
					nome VARCHAR(30) NOT NULL,
					uf CHAR(2) NOT NULL);
					

CREATE TABLE cliente(idCliente INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
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
					REFERENCES cidade(idCidade) ON DELETE RESTRICT);

CREATE TABLE PessoaFisica( 
					cpf CHAR(11),
					idCliente integer PRIMARY KEY ,
					FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente) ON DELETE RESTRICT);

CREATE TABLE PessoaJuridica(
					cnpj CHAR(15), 
					ie CHAR(20),
					idCliente integer PRIMARY KEY,
					FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente) ON DELETE RESTRICT);

CREATE TABLE linha(
					idLinha INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
					nome VARCHAR(40),
					descricao VARCHAR(100) NOT NULL);
					
CREATE TABLE TIPOPRODUTO(
					idTIPO INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
					descricao VARCHAR(60),
					unVenda VARCHAR(10));


CREATE TABLE produto(idProduto INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
					descricao VARCHAR(100),
					preco Float(5,2) NOT NULL, 
					statusVenda BOOLEAN NOT NULL,
					idLinha INTEGER,

					idTipo INTEGER,

					FOREIGN KEY(idLinha)
					REFERENCES linha(idLinha)ON DELETE RESTRICT,

					FOREIGN KEY(idTipo)
					REFERENCES TIPOPRODUTO(idTipo)ON DELETE RESTRICT);
					
					
CREATE TABLE pedido(idPedido INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, 
					descricao varchar(100),
					valorTotal Float(7,2),
					idCliente INTEGER,
					data date,
					FOREIGN KEY(idCliente)
					REFERENCES cliente(idCliente) ON DELETE RESTRICT);
					
CREATE TABLE pedido_item(idPedido_item INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
						idPedido INTEGER,
						idProduto INTEGER,
						quantidade INTEGER, 
						precoTotal float(7,2),
						FOREIGN KEY(idPedido)
						REFERENCES pedido(idPedido) ON DELETE RESTRICT,
						FOREIGN KEY(idProduto)
						REFERENCES produto(idProduto) ON DELETE RESTRICT);


/* inserção de dados*/

INSERT INTO CIDADE (NOME, UF)VALUES('COLATINA','ES');
INSERT INTO CIDADE (NOME, UF)VALUES('RESPLENDOR','MG');
INSERT INTO CIDADE (NOME, UF)VALUES('IBATIBA','ES');
INSERT INTO CIDADE (NOME, UF)VALUES('GOVERNADOR VALADARES','MG');
INSERT INTO CIDADE (NOME, UF)VALUES('VITORIA','ES');

SELECT * FROM CLIENTE;
/*
INSERT INTO CLIENTE( nome, endereco, numero, bairro, complemento, telFixo, telCel, idCidade, tipoCliente, cep, cnpj, ie)VALUES('MEGAMERCADO','PRIMEIRO DE MAIO','93','NORTE',NULL,'3332630000',NULL,2 ,'J','35230000','86874554000133','7927513716514');
INSERT INTO CLIENTE( nome, endereco, numero, bairro, complemento, telFixo, telCel, idCidade, tipoCliente, cep, cnpj, ie)VALUES('VENDAO','AV CASTRO','02','BAIRRO DA VISTA',NULL,'2737229090',NULL,1,'J','29700550','76741456000174','990565157');
INSERT INTO CLIENTE( nome, endereco, numero, bairro, complemento, telFixo, telCel, idCidade, tipoCliente, cep, cnpj, ie)VALUES('FARMAK','PEDRO MAIA', '1008','CENTRO',NULL,'2737225660',NULL,1,'J','35230000','05827315000120','350461562');
INSERT INTO CLIENTE( nome, endereco, numero, bairro, complemento, telFixo, telCel, idCidade, tipoCliente, cep, cnpj, ie)VALUES('TOPS','HENRIQUE BROSTEL', '45','BRASIL NOVO',NULL,'2712432190',NULL,3,'J','29395001','10265444000102','014147807');

INSERT INTO Cliente (nome, endereco, numero, bairro, complemento, telFixo, telCel, idCidade, tipoCliente, cep, cpf)VALUES ('RUAN','EDUARDO MENEGUSSI','93','NORTE','CAMPO DO AMERICA','3332632920','3391321006',2,'F','35230000','11014412044');
INSERT INTO Cliente (nome, endereco, numero, bairro, complemento, telFixo, telCel, idCidade, tipoCliente, cep, cpf)VALUES ('PAULO HENRIQUE','PEDRO EPCHIN','557','COLATINA VELHA','VASCO BAR',NULL,'27999867674',1,'F','28570032','81561643939');
*/
INSERT INTO LINHA(NOME, DESCRICAO)VALUES('VELHA GUARDA','PRODUTOS DESTINADOS A IDOSOS.');
INSERT INTO LINHA(NOME, DESCRICAO)VALUES('SUPER-HEROI','PRODUTOS DESTINADOS A CRIANÇAS.');
INSERT INTO LINHA(NOME, DESCRICAO)VALUES('BEAUTIFUL WOMAN','PRODUTOS DESTINADOS A MULHERES DE 20 A 30 ANOS.');
INSERT INTO LINHA(NOME, DESCRICAO)VALUES('NATURION','PRODUTOS QUE CONSERVAM PROPRIEDADES NATURAIS.');

INSERT INTO TIPOPRODUTO(DESCRICAO, UNVENDA)VALUES('SHAMPOO','PCT X 12');
INSERT INTO TIPOPRODUTO(DESCRICAO, UNVENDA)VALUES('CONDICIONADOR','PCT X 12');
INSERT INTO TIPOPRODUTO(DESCRICAO, UNVENDA)VALUES('SABONETE LIQUIDO','1UN');
INSERT INTO TIPOPRODUTO(DESCRICAO, UNVENDA)VALUES('CREME','PCT X 12');
INSERT INTO TIPOPRODUTO(DESCRICAO, UNVENDA)VALUES('FINALIZADOR','UN');

INSERT INTO PRODUTO(descricao, preco, idlinha, IDTIPO, statusVenda)VALUES('SH FLASH 250ML', 10, 2,1, TRUE);
INSERT INTO PRODUTO(descricao, preco, idlinha, IDTIPO, statusVenda)VALUES('SH SPIDER MAN 250ML', 10, 2,1, TRUE);
INSERT INTO PRODUTO(descricao, preco, idlinha, IDTIPO, statusVenda)VALUES('SH BATMAN 250ML', 10, 2,1, TRUE);
INSERT INTO PRODUTO(descricao, preco, idlinha, IDTIPO, statusVenda)VALUES('SH WOLVERINE 250ML', 10, 2,1, TRUE);
INSERT INTO PRODUTO(descricao, preco, idlinha, IDTIPO, statusVenda)VALUES('COND FLASH 250ML', 10, 2,2, TRUE);
INSERT INTO PRODUTO(descricao, preco, idlinha, IDTIPO, statusVenda)VALUES('COND SPIDER MAN 250ML', 10, 2,2, TRUE);
INSERT INTO PRODUTO(descricao, preco, idlinha, IDTIPO, statusVenda)VALUES('COND BATMAN 250ML', 10, 2,2, TRUE);
INSERT INTO PRODUTO(descricao, preco, idlinha, IDTIPO, statusVenda)VALUES('COND WOLVERINE 250ML', 10, 2,2, TRUE);

INSERT INTO PRODUTO(descricao, preco, idlinha, IDTIPO, statusVenda)VALUES('SH VIVENCIAS 250ML', 10, 1,1, TRUE);
INSERT INTO PRODUTO(descricao, preco, idlinha, IDTIPO, statusVenda)VALUES('COND VIVENCIAS 250ML', 10, 1,2, TRUE);
INSERT INTO PRODUTO(descricao, preco, idlinha, IDTIPO, statusVenda)VALUES('SH MARIA 250ML', 10, 1,1, TRUE);
INSERT INTO PRODUTO(descricao, preco, idlinha, IDTIPO, statusVenda)VALUES('COND MARIA 250ML', 10, 1,2, TRUE);

INSERT INTO PRODUTO(descricao, preco, idlinha, IDTIPO, statusVenda)VALUES('SAB LIQ MAOS 150ML', 19.90, 4,3, TRUE);
INSERT INTO PRODUTO(descricao, preco, idlinha, IDTIPO, statusVenda)VALUES('SAB LIQ ROSTO 150ML', 39.90, 4,3, TRUE);
INSERT INTO PRODUTO(descricao, preco, idlinha, IDTIPO, statusVenda)VALUES('SAB LIQ ALCOOL 150ML', 19.90, 4,null, TRUE);

SELECT * FROM PRODUTO;
SELECT * from cliente;
SELECT * from cidade;
SELECT * FROM PESSOAFISICA;
SELECT * FROM PESSOAJURIDICA;
SELECT * FROM TIPOPRODUTO;
select * from pedido;
select * from pedido_item;