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
   passwordusuario VARCHAR (40) NOT NULL,
   PRIMARY KEY (idusuarios)
);