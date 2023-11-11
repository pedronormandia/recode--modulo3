CREATE TABLE cliente (
id int primary key not null auto_increment,
nome varchar(45),
telefone varchar(45),
cpf varchar(45)
);


CREATE TABLE pacote (
id int primary key not null auto_increment,
data datetime,
valor double,
tempo_estadia int,
destino varchar(45)
);

CREATE TABLE compra (
id int primary key not null auto_increment,
id_cliente int,
id_pacote int,
forma_pagamento varchar(45),
FOREIGN KEY(id_cliente) REFERENCES cliente (id),
FOREIGN KEY(id_pacote) REFERENCES pacote (id)
);

ALTER TABLE `agenciaviagem`.`compra` 
DROP FOREIGN KEY `compra_ibfk_1`,
DROP FOREIGN KEY `compra_ibfk_2`;
ALTER TABLE `agenciaviagem`.`compra` 
ADD CONSTRAINT `compra_ibfk_1`
  FOREIGN KEY (`id_cliente`)
  REFERENCES `agenciaviagem`.`cliente` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `compra_ibfk_2`
  FOREIGN KEY (`id_pacote`)
  REFERENCES `agenciaviagem`.`pacote` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


