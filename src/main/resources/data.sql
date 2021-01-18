INSERT INTO usuarios ( apellidos, codigoseguridad, direccion_facturacion, email, fecha_nacimiento, nombre, numerotarjeta, passwordusuario, titulartarjeta) 
VALUES ('a', '1', 'a', 'a@a.com', '202-25-9', 'a', '1', '$10$caIr0AKQQXvus5hL2fwo..QB6jux0L2OFNdxRH/CMXxyLEYhbrNBe', 'a');

INSERT INTO rol (id_rol, nombre_rol) VALUES ('1', 'ROL_REGISTRADO');
INSERT INTO rol (nombre_rol) VALUES ('ROL_ADMIN');

INSERT INTO usuario_rol (id_usuarios, id_rol) VALUES ('1', '1');