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

CREATE TABLE `alejandro`.`compras` (
  `idCompras` INT NOT NULL AUTO_INCREMENT,
  `idUsuarios` BIGINT NULL,
  PRIMARY KEY (`idCompras`),
  INDEX `idusuarios_idx` (`idUsuarios` ASC),
  CONSTRAINT `idusuarios`
    FOREIGN KEY (`idUsuarios`)
    REFERENCES `alejandro`.`usuarios` (`idusuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `alejandro`.`lineasdecompras` (
  `idCompra` INT NULL,
  `idProducto` BIGINT NULL,
  `cantidad` BIGINT NULL,
  INDEX `idCompra_idx` (`idCompra` ASC),
  INDEX `idProducto_idx` (`idProducto` ASC),
  CONSTRAINT `idCompra`
    FOREIGN KEY (`idCompra`)
    REFERENCES `alejandro`.`compras` (`idCompras`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idProducto`
    FOREIGN KEY (`idProducto`)
    REFERENCES `alejandro`.`productos` (`idproductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
