INSERT INTO alejandro.usuarios ( apellidos, codigoseguridad, direccion_facturacion, email, fecha_nacimiento, nombre, numerotarjeta, passwordusuario, titulartarjeta) 
VALUES ('a', '1', 'a', 'a@a.com', '202-25-9', 'a', '1', '$2a$10$C7bYDLtja1vQARJuz798luHjiOoCaDTpgMxUFYdL/lHq2onyaL7gu', 'a');
INSERT INTO alejandro.usuarios ( apellidos, codigoseguridad, direccion_facturacion, email, fecha_nacimiento, nombre, numerotarjeta, passwordusuario, titulartarjeta) 
VALUES ('b', '1', 'b', 'b@b.com', '202-25-9', 'b', '1', '$2a$10$C7bYDLtja1vQARJuz798luHjiOoCaDTpgMxUFYdL/lHq2onyaL7gu', 'b');

INSERT INTO alejandro.rol (id_rol, nombre_rol) VALUES ('1', 'ROL_REGISTRADO');
INSERT INTO alejandro.rol (id_rol, nombre_rol) VALUES ('2','ROL_ADMIN');

INSERT INTO alejandro.usuario_rol (id_usuarios, id_rol) VALUES ('1', '2');
INSERT INTO alejandro.usuario_rol (id_usuarios, id_rol) VALUES ('2', '1');

INSERT INTO alejandro.productos (descripcionproducto,descuento,imagenproducto,nombreproducto,precio) 
VALUES ('Pimiento Rojo',0,'','Pimiento',1);
INSERT INTO alejandro.productos (descripcionproducto,descuento,imagenproducto,nombreproducto,precio) 
VALUES ('Manzana',0,'','fresco',1);
INSERT INTO alejandro.productos (descripcionproducto,descuento,imagenproducto,nombreproducto,precio) 
VALUES ('Pera',0,'','fresco',1);
INSERT INTO alejandro.productos (descripcionproducto,descuento,imagenproducto,nombreproducto,precio) 
VALUES ('Platano',0,'','fresco',1);
INSERT INTO alejandro.productos (descripcionproducto,descuento,imagenproducto,nombreproducto,precio) 
VALUES ('Lechuga',0,'','fresco',1);
INSERT INTO alejandro.productos (descripcionproducto,descuento,imagenproducto,nombreproducto,precio) 
VALUES ('Tomate',0,'','fresco',1);
INSERT INTO alejandro.productos (descripcionproducto,descuento,imagenproducto,nombreproducto,precio) 
VALUES ('Espinacas',0,'','fresco',1);

INSERT INTO alejandro.preguntas (pregunta,idproductos,id_usuarios) VALUES ('Esta bueno?','1','1');
INSERT INTO alejandro.respuestas (respuesta,id_pregunta,id_usuarios) VALUES ('Si','1','2');