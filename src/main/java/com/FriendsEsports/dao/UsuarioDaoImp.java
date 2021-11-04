package com.FriendsEsports.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.FriendsEsports.entidades.Usuario;

@Repository
@Component("UserDao")
public class UsuarioDaoImp extends DaoGenericoImp<Usuario> implements UsuarioDao {

	@Override
	public boolean logIn(String nombreUsuario, String password) {
		Usuario resultado = buscarPorNombre(nombreUsuario);
		if (resultado == null)
			return false;
		else if (!resultado.getPassword().equals(password))
			return false;
		else
			return true;
	}

	@Override
	public Usuario buscarPorNombre(String nombreUsuario) {

		Usuario usuario = new Usuario();
		try {
			Query query = this.em.createQuery("FROM Usuario u WHERE u.nombre=:nombre");
			query.setParameter("nombre", nombreUsuario);
			usuario = (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return usuario;
	}

	@Override
	public List<Usuario> listarUsuarios() {
		Query query = this.em.createQuery("FROM Usuario");
		query.setFirstResult(0);
		List<Usuario> usuarios = query.getResultList();

		if (usuarios != null) {
			return usuarios;
		}
		return null;
	}
}
