package com.example.demo.servicios;

import com.example.demo.entidades.User;

public interface UserServicio {

	public boolean logIn(String nombreUsuario, String password);
	
	public User crearUsuario(User usuario);
	
	public void eliminarUsuario (long idUsuarios);

	public User obtenerUsuario(long idUsuarios);
	
	public User modificarUsuario(User usuario);
}
