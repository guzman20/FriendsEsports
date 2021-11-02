INSERT INTO FriendEsports.usuario (  email, fecha_nacimiento, nombre, password_usuario) 
VALUES ( 'a@a.com', '2020-09-25', 'a', '$2a$10$C7bYDLtja1vQARJuz798luHjiOoCaDTpgMxUFYdL/lHq2onyaL7gu');
INSERT INTO FriendEsports.usuario (  email, fecha_nacimiento, nombre, password_usuario) 
VALUES ( 'b@b.com', '2020-09-25', 'b', '$2a$10$C7bYDLtja1vQARJuz798luHjiOoCaDTpgMxUFYdL/lHq2onyaL7gu');

INSERT INTO FriendEsports.rol (id_rol, nombre_rol) VALUES ('1', 'rolRegistrado');
INSERT INTO FriendEsports.rol (id_rol, nombre_rol) VALUES ('2','rolAdmin');

INSERT INTO FriendEsports.usuario_rol (id_usuario, id_rol) VALUES ('1', '2');
INSERT INTO FriendEsports.usuario_rol (id_usuario, id_rol) VALUES ('2', '1');

INSERT INTO FriendEsports.juego(id_juego,nombre) VALUES('1','League Of Legends');
INSERT INTO FriendEsports.juego(id_juego,nombre) VALUES('2','Valorant');
INSERT INTO FriendEsports.juego(id_juego,nombre) VALUES('3','Counter Strike : Global Ofensive');

INSERT INTO FriendEsports.conversacion (id_juego, titulo, texto,id_usuario,fecha_de_creacion) VALUES ('1','Anivia, la criofenix','Mi campeón favorito, sin duda alguna Anivia, la criofenix. No tendrá mucho ataque, no tendrá mucha defensa... pero me encanta. Es muy difícil de controlar, sobre todo la Q, porque tienes que petarla y controlar la distancia muy bien para stunear.','1','2021-06-16 18:31:44.813730');
INSERT INTO FriendEsports.conversacion (id_juego, titulo, texto,id_usuario,fecha_de_creacion) VALUES ('2','Os juro, Como oiga a alguien decir otra vez que no se puede hacer counter a Viper despues de plantar ','1) Pushea bro?
2) Humea la posicion desde donde defiende para que no vea nada
3) Tira alguna habilidad que la haga salir
4) Haz bodyblock a la granada venenosa
5) Tira el muro de sage para ver desde arriba','2','2021-06-16 18:31:44.813730');
INSERT INTO FriendEsports.conversacion (id_juego, titulo, texto,id_usuario,fecha_de_creacion) VALUES ('3','Opinion S1mple','S1mple es fantástico. Solo necesita trabajar en la comunicación, el map awareness, la gestión de la economía, las granadas, los humos, las flashes, el posicionamiento, el spray controll y las kills.','1','2021-06-16 18:31:44.813730');
INSERT INTO FriendEsports.respuesta (respuesta,id_conversacion,id_usuario,fecha_de_creacion) VALUES ('Me encata anivia. <3','1','2','2021-02-14 12:39:11');
INSERT INTO FriendEsports.respuesta (respuesta,id_conversacion,id_usuario,fecha_de_creacion) VALUES ('Pero cuando me encuentro con una Viper es tan Zzz.','2','2','2021-02-14 12:39:11');
INSERT INTO FriendEsports.respuesta (respuesta,id_conversacion,id_usuario,fecha_de_creacion) VALUES ('S1mple podria mejorar pero es la ostia bro.','3','1','2021-02-14 12:39:11');