drop database if exists alejandro;
create database alejandro;

use alejandro;



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
   idUsuarios BIGINT NOT NULL AUTO_INCREMENT,
   nombre VARCHAR (40) NOT NULL,
   apellidos VARCHAR (200) NOT NULL,
   email VARCHAR (40) NOT NULL,
   fecha_Nacimiento DATE NOT NULL,
   numeroTarjeta VARCHAR (40) NOT NULL,
   titularTarjeta VARCHAR (40) NOT NULL,
   codigoSeguridad VARCHAR (40) NOT NULL,
   direccion_facturacion VARCHAR (40) NOT NULL,
   passwordusuario VARCHAR (40) NOT NULL,
   PRIMARY KEY (idUsuarios)
);

CREATE TABLE compras
(
idCompras BIGINT NOT NULL AUTO_INCREMENT,
idUsuarios BIGINT NOT NULL,
PRIMARY KEY (idCompras),
CONSTRAINT FK_COMPRAS_USUARIOS FOREIGN KEY (idUsuarios) REFERENCES usuarios (idUsuarios) ON DELETE CASCADE
);