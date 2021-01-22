INSERT INTO alejandro.usuarios ( apellidos, codigoseguridad, direccion_facturacion, email, fecha_nacimiento, nombre, numerotarjeta, passwordusuario, titulartarjeta) 
VALUES ('a', '1', 'a', 'a@a.com', '202-25-9', 'a', '1', '$2a$10$C7bYDLtja1vQARJuz798luHjiOoCaDTpgMxUFYdL/lHq2onyaL7gu', 'a');

INSERT INTO alejandro.rol (id_rol, nombre_rol) VALUES ('1', 'ROL_REGISTRADO');
INSERT INTO alejandro.rol (nombre_rol) VALUES ('ROL_ADMIN');

INSERT INTO alejandro.usuario_rol (id_usuarios, id_rol) VALUES ('1', '2');