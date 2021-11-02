package com.FriendsEsports.servicios;

import com.FriendsEsports.entidades.Usuario;

public interface UsuarioServicio {

	public boolean logIn(String nombreUsuario, String password);
	
	public Usuario crearUsuario(Usuario usuario);
	
	public void eliminarUsuario (long idUsuarios);

	public Usuario buscarUsuario(long idUsuarios);
	
	public Usuario editarUsuario(Usuario usuario);
	
	public Usuario buscarUsuario(String nombreUsuario);

	public boolean verificarIdentidad(String antiguaPassword, String string);
}
