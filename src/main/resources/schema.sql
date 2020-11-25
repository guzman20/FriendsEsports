drop database if exists Alejandro;
create database Alejandro;

use Alejandro;



CREATE TABLE productos
(
   idproductos BIGINT NOT NULL AUTO_INCREMENT,
   nombreproducto VARCHAR (40) NOT NULL,
   descripcionproducto VARCHAR (40) NOT NULL,
   imagenproducto VARCHAR (40) NOT NULL,
   precio DOUBLE NOT NULL,
   descuento BIGINT,
   PRIMARY KEY (idproductos)
);

CREATE TABLE usuarios
(
   idusuarios BIGINT NOT NULL AUTO_INCREMENT,
   nombreusuario VARCHAR (40) NOT NULL,
   apellidousuario VARCHAR (200) NOT NULL,
   emailusuario VARCHAR (40) NOT NULL,
   fecnacimiento DATE NOT NULL,
   ntarjeta VARCHAR (40) NOT NULL,
   titular VARCHAR (40) NOT NULL,
   csv VARCHAR (40) NOT NULL,
   direccion VARCHAR (40) NOT NULL,
   passwordusuario VARCHAR (40) NOT NULL,
   PRIMARY KEY (idusuarios)
);

CREATE TABLE `alejandro`.`lineacompra` (
  `idlineacompra` INT NOT NULL,
  `idproductos` BIGINT NULL,
  `cantidad` VARCHAR(45) NULL,
  PRIMARY KEY (`idlineacompra`),
  INDEX `idproductos_idx` (`idproductos` ASC),
  CONSTRAINT `idproductos`
    FOREIGN KEY (`idproductos`)
    REFERENCES `alejandro`.`productos` (`idproductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
CREATE TABLE `alejandro`.`compra` (
  `idcompra` INT NOT NULL AUTO_INCREMENT,
  `idusuarios` BIGINT NULL,
  `idlinea` INT NULL,
  PRIMARY KEY (`idcompra`),
  INDEX `idusuarios_idx` (`idusuarios` ASC),
  INDEX `idlinea_idx` (`idlinea` ASC),
  CONSTRAINT `idusuarios`
    FOREIGN KEY (`idusuarios`)
    REFERENCES `alejandro`.`usuarios` (`idusuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idlinea`
    FOREIGN KEY (`idlinea`)
    REFERENCES `alejandro`.`lineacompra` (`idlineacompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
