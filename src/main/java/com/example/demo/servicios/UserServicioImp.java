package com.example.demo.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entidades.User;

@Transactional
@Service
public class UserServicioImp implements UserServicio{
	
	@Autowired
	private UserDao userDao;

	@Override
	public boolean logIn(String nombreUsuario, String password) {
		return userDao.logIn(nombreUsuario, password);
	}

	@Override
	public User crearUsuario(User usuario) {
		return userDao.crear(usuario);
	}

	@Override
	public void eliminarUsuario(long idUsuario) {
		userDao.borrar(idUsuario);
	}

	@Override
	public User obtenerUsuario(long idUsuario) {
		return userDao.buscar(idUsuario);
	}

	@Override
	public User modificarUsuario(User usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
