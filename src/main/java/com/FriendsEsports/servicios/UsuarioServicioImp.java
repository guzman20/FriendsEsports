package com.FriendsEsports.servicios;

import java.util.HashSet;
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
public class UsuarioServicioImp implements UsuarioServicio {

	private final int rolRegistrado = 1;

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private RolRepository rolRepositorio;

	@Autowired
	private BCryptPasswordEncoder Encriptador;

	@Override
	public boolean logIn(String nombreUsuario, String password) {
		return usuarioDao.logIn(nombreUsuario, password);
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		usuario.setPassword(Encriptador.encode(usuario.getPassword()));
		Rol rol = null;
		if (!rolRepositorio.findAll().stream().anyMatch(rolL -> rolL.getNombreRol().equals("rolRegistrado"))) {
			Rol rolUsuario = new Rol();
			rolUsuario.setNombreRol("rolRegistrado");
			Set<Usuario> usuarios = new HashSet<>();
			usuarios.add(usuario);
			rolUsuario.setUsuarios(usuarios);
			rolRepositorio.save(rolUsuario);
			rol = rolUsuario;
			usuario.anadirRol(rol);
		} else {
			Iterator<Rol> roles = rolRepositorio.findAll().iterator();
			Rol rolAyuda = null;
			while (roles.hasNext()) {
				if ((rolAyuda = roles.next()).getNombreRol().equals("rolRegistrado")) {
					rol = rolAyuda;
				}
			}
			usuario.anadirRol(rol);
		}
		return usuarioDao.crear(usuario);
	}

	@Override
	public void eliminarUsuario(long idUsuario) {
		usuarioDao.borrar(idUsuario);
	}

	@Override
	public Usuario buscarUsuario(long idUsuario) {
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
	public boolean verificarIdentidad(String antiguaPassword, String nombre) {
		Usuario usuario = usuarioDao.buscarPorNombre(nombre);
		return Encriptador.matches(antiguaPassword, usuario.getPassword());
	}

	@Override
	public List<Usuario> ObtenerListaUsuarios() {
		return usuarioDao.listarUsuarios();
	}

}
