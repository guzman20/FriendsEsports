package com.example.demo.dao;

import java.util.List;

import com.example.demo.entidades.Compra;
import com.example.demo.entidades.User;

public interface UserDao extends DaoGenerico<User> {
	
	public boolean logIn(String nombreUsuario, String password);

	public User buscarPorNombre (String nombreUsuario);
	
}
