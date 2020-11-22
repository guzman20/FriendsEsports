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