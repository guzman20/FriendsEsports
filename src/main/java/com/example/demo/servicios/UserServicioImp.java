package com.example.demo.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RolRepository;
import com.example.demo.dao.UserDao;
import com.example.demo.entidades.Rol;
import com.example.demo.entidades.User;

@Transactional
@Service
public class UserServicioImp implements UserServicio{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder(); // or any other password encoder
	}
	
	@Override
	public boolean logIn(String nombreUsuario, String password) {
		return userDao.logIn(nombreUsuario, password);
	}

	@Override
	public User crearUsuario(User usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		Rol r = rolRepository.findById(2).orElse(null);
		usuario.anadirRol(r);
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

	@Override
	public User buscarUsuario(String nombreUsuario) {
		return userDao.buscarPorNombre(nombreUsuario);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.buscarPorNombre(username);
	}

}
