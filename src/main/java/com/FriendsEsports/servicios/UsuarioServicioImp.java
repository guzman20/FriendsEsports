package com.FriendsEsports.servicios;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.FriendsEsports.dao.RolRepository;
import com.FriendsEsports.dao.UsuarioDao;
import com.FriendsEsports.entidades.Rol;
import com.FriendsEsports.entidades.Usuario;

@Transactional
@Service
public class UsuarioServicioImp implements UsuarioServicio{
	
	private final int rolRegistrado = 1;
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private RolRepository rolRepositorio;
	
	@Autowired
	private BCryptPasswordEncoder Encriptador;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	public boolean logIn(String nombreUsuario, String password) {
		return usuarioDao.logIn(nombreUsuario, password);
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		usuario.setPassword(Encriptador.encode(usuario.getPassword()));
		Rol rol = rolRepositorio.findById(rolRegistrado).orElse(null);
		usuario.anadirRol(rol);
		return usuarioDao.crear(usuario);
	}

	@Override
	public void eliminarUsuario(long idUsuario) {
		usuarioDao.borrar(idUsuario);
	}

	@Override
	public Usuario obtenerUsuario(long idUsuario) {
		return usuarioDao.buscar(idUsuario);
	}

	@Override
	public Usuario editarUsuario(Usuario usuario) {
		usuario.setPassword(Encriptador.encode(usuario.getPassword()));
		return usuarioDao.actualizar(usuario);
	}

	@Override
	public Usuario buscarUsuario(String nombreUsuario) {
		return usuarioDao.buscarPorNombre(nombreUsuario);
	}

	@Override
	public Usuario findByUsername(String username) {
		return usuarioDao.buscarPorNombre(username);
	}

	@Override
	public boolean verificarIdentidad(String antiguaPassword, String nombre) {
		Usuario usuario =usuarioDao.buscarPorNombre(nombre);
		return Encriptador.matches(antiguaPassword, usuario.getPassword());
	}

}
