INSERT INTO alejandro.usuarios (  email, fecha_nacimiento, nombre, passwordusuario) 
VALUES ( 'a@a.com', '202-25-9', 'a', '$2a$10$C7bYDLtja1vQARJuz798luHjiOoCaDTpgMxUFYdL/lHq2onyaL7gu');
INSERT INTO alejandro.usuarios (  email, fecha_nacimiento, nombre, passwordusuario) 
VALUES ( 'b@b.com', '202-25-9', 'b', '$2a$10$C7bYDLtja1vQARJuz798luHjiOoCaDTpgMxUFYdL/lHq2onyaL7gu');

INSERT INTO alejandro.rol (id_rol, nombre_rol) VALUES ('1', 'ROL_REGISTRADO');
INSERT INTO alejandro.rol (id_rol, nombre_rol) VALUES ('2','ROL_ADMIN');

INSERT INTO alejandro.usuario_rol (id_usuarios, id_rol) VALUES ('1', '2');
INSERT INTO alejandro.usuario_rol (id_usuarios, id_rol) VALUES ('2', '1');

INSERT INTO alejandro.conversaciones (tema, titulo, texto,id_usuarios,fecha_de_creacion) VALUES ('lol','Anivia, la criofenix','Mi campeón favorito, sin duda alguna Anivia, la criofenix. No tendrá mucho ataque, no tendrá mucha defensa... pero me encanta. Es muy difícil de controlar, sobre todo la Q, porque tienes que petarla y controlar la distancia muy bien para stunear.','1','2021-06-16 18:31:44.813730');
INSERT INTO alejandro.respuestas (respuesta,id_conversacion,id_usuarios,fecha_de_creacion) VALUES ('Si','1','2','2021-02-14 12:39:11');
INSERT INTO alejandro.conversaciones (tema, titulo, texto,id_usuarios,fecha_de_creacion) VALUES ('valorant','Os juro, Como oiga a alguien decir otra vez que no se puede hacer counter a Viper despues de plantar ','1) Pushea bro?
2) Humea la posicion desde donde defiende para que no vea nada
3) Tira alguna habilidad que la haga salir
4) Haz bodyblock a la granada venenosa
5) Tira el muro de sage para ver desde arriba','2','2021-06-16 18:31:44.813730');