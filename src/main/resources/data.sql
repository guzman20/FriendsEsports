INSERT INTO alejandro.usuarios (  email, fecha_nacimiento, nombre, passwordusuario) 
VALUES ( 'a@a.com', '202-25-9', 'a', '$2a$10$C7bYDLtja1vQARJuz798luHjiOoCaDTpgMxUFYdL/lHq2onyaL7gu');
INSERT INTO alejandro.usuarios (  email, fecha_nacimiento, nombre, passwordusuario) 
VALUES ( 'b@b.com', '202-25-9', 'b', '$2a$10$C7bYDLtja1vQARJuz798luHjiOoCaDTpgMxUFYdL/lHq2onyaL7gu');

INSERT INTO alejandro.rol (id_rol, nombre_rol) VALUES ('1', 'ROL_REGISTRADO');
INSERT INTO alejandro.rol (id_rol, nombre_rol) VALUES ('2','ROL_ADMIN');

INSERT INTO alejandro.usuario_rol (id_usuarios, id_rol) VALUES ('1', '2');
INSERT INTO alejandro.usuario_rol (id_usuarios, id_rol) VALUES ('2', '1');

INSERT INTO alejandro.temas (tema,id_usuarios,fecha_de_creacion) VALUES ('Esta bueno?','1','2021-02-14 11:39:00.632136');
INSERT INTO alejandro.respuestas (respuesta,id_tema,id_usuarios,fecha_de_creacion) VALUES ('Si','1','2','2021-02-14 12:39:11');