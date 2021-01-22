drop database if exists alejandro;
create database alejandro;

use alejandro;

CREATE TABLE USUARIOS
(
   id_usuarios BIGINT NOT NULL AUTO_INCREMENT,
   nombre VARCHAR (40) NOT NULL,
   apellidos VARCHAR (40) NOT NULL,
   passwordusuario VARCHAR (120) NOT NULL,
   email VARCHAR(50) NOT NULL,
   fecha_nacimiento VARCHAR(50) NOT NULL,
   direccion_facturacion VARCHAR(50) NOT NULL,
   numerotarjeta INT NOT NULL,
   titulartarjeta VARCHAR(40) not null,
   codigoseguridad INT NOT NULL,
   PRIMARY KEY (id_usuarios)
);

CREATE TABLE ROL
(
   ID_ROL INT AUTO_INCREMENT,
   NOMBRE_ROL VARCHAR (40) NOT NULL,
   PRIMARY KEY (ID_ROL)
);

CREATE TABLE USUARIO_ROL
(
   ID_USUARIOS BIGINT NOT NULL,
   ID_ROL INT,
      PRIMARY KEY
   (
      ID_USUARIOS,
      ID_ROL
   ),
   CONSTRAINT FK_USUARIO_ROL_1 FOREIGN KEY (ID_USUARIOS) REFERENCES USUARIOS (ID_USUARIOS) ON DELETE CASCADE,
   CONSTRAINT FK_USUARIO_ROL_2 FOREIGN KEY (ID_ROL) REFERENCES ROL (ID_ROL)
);

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

CREATE TABLE compras
(
idCompras BIGINT NOT NULL AUTO_INCREMENT,
ID_USUARIOS BIGINT NOT NULL,
PRIMARY KEY (idCompras),
CONSTRAINT FK_COMPRAS_USUARIOS FOREIGN KEY (ID_USUARIOS) REFERENCES usuarios (ID_USUARIOS) ON DELETE CASCADE
on update cascade
);
