SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `bioextratus1` DEFAULT CHARACTER SET utf8 ;
USE `bioextratus1` ;

-- -----------------------------------------------------
-- Table `bioextratus1`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bioextratus1`.`cidade` (
  `idCidade` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(30) NOT NULL,
  `uf` CHAR(2) NOT NULL,
  PRIMARY KEY (`idCidade`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bioextratus1`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bioextratus1`.`cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NULL DEFAULT NULL,
  `endereco` VARCHAR(60) NULL DEFAULT NULL,
  `numero` CHAR(7) NULL DEFAULT NULL,
  `bairro` VARCHAR(60) NULL DEFAULT NULL,
  `complemento` VARCHAR(60) NULL DEFAULT NULL,
  `telFixo` CHAR(15) NULL DEFAULT NULL,
  `telCel` CHAR(15) NULL DEFAULT NULL,
  `idCidade` INT(11) NULL DEFAULT NULL,
  `cep` CHAR(9) NULL DEFAULT NULL,
  `tipoCliente` CHAR(1) NULL DEFAULT NULL,
  `email` CHAR(40) NULL DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `idCidade` (`idCidade` ASC),
  CONSTRAINT `cliente_ibfk_1`
    FOREIGN KEY (`idCidade`)
    REFERENCES `bioextratus1`.`cidade` (`idCidade`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bioextratus1`.`linha`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bioextratus1`.`linha` (
  `idLinha` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(40) NULL DEFAULT NULL,
  `descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idLinha`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bioextratus1`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bioextratus1`.`pedido` (
  `idPedido` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NULL DEFAULT NULL,
  `valorTotal` FLOAT(7,2) NULL DEFAULT NULL,
  `idCliente` INT(11) NULL DEFAULT NULL,
  `data` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idPedido`),
  INDEX `idCliente` (`idCliente` ASC),
  CONSTRAINT `pedido_ibfk_1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `bioextratus1`.`cliente` (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bioextratus1`.`tipoproduto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bioextratus1`.`tipoproduto` (
  `idTIPO` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(60) NULL DEFAULT NULL,
  `unVenda` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`idTIPO`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bioextratus1`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bioextratus1`.`produto` (
  `idProduto` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NULL DEFAULT NULL,
  `preco` FLOAT(5,2) NOT NULL,
  `statusVenda` TINYINT(1) NOT NULL,
  `idLinha` INT(11) NULL DEFAULT NULL,
  `idTipo` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idProduto`),
  INDEX `idLinha` (`idLinha` ASC),
  INDEX `idTipo` (`idTipo` ASC),
  CONSTRAINT `produto_ibfk_1`
    FOREIGN KEY (`idLinha`)
    REFERENCES `bioextratus1`.`linha` (`idLinha`),
  CONSTRAINT `produto_ibfk_2`
    FOREIGN KEY (`idTipo`)
    REFERENCES `bioextratus1`.`tipoproduto` (`idTIPO`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bioextratus1`.`pedido_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bioextratus1`.`pedido_item` (
  `idPedido_item` INT(11) NOT NULL AUTO_INCREMENT,
  `idPedido` INT(11) NULL DEFAULT NULL,
  `idProduto` INT(11) NULL DEFAULT NULL,
  `quantidade` INT(11) NULL DEFAULT NULL,
  `precoTotal` FLOAT(7,2) NULL DEFAULT NULL,
  PRIMARY KEY (`idPedido_item`),
  INDEX `idPedido` (`idPedido` ASC),
  INDEX `idProduto` (`idProduto` ASC),
  CONSTRAINT `pedido_item_ibfk_1`
    FOREIGN KEY (`idPedido`)
    REFERENCES `bioextratus1`.`pedido` (`idPedido`),
  CONSTRAINT `pedido_item_ibfk_2`
    FOREIGN KEY (`idProduto`)
    REFERENCES `bioextratus1`.`produto` (`idProduto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bioextratus1`.`pessoafisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bioextratus1`.`pessoafisica` (
  `idCliente` INT(11) NOT NULL,
  `cpf` CHAR(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  CONSTRAINT `fk_pessoafisica_cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `bioextratus1`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bioextratus1`.`pessoajuridica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bioextratus1`.`pessoajuridica` (
  `idCliente` INT(11) NOT NULL,
  `cnpj` CHAR(15) NULL DEFAULT NULL,
  `ie` CHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  CONSTRAINT `fk_pessoajuridica_cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `bioextratus1`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

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
