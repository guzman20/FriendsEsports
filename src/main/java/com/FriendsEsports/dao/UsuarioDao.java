package com.FriendsEsports.dao;

import java.util.List;

import com.FriendsEsports.entidades.Usuario;

public interface UsuarioDao extends DaoGenerico<Usuario> {
	
	public boolean logIn(String nombreUsuario, String password);

	public Usuario buscarPorNombre (String nombreUsuario);

	public List<Usuario> listarUsuarios();
	
}
