package com.example.demo.dao;

import java.util.List;

import javax.persistence.Query;

import com.example.demo.entidades.User;

public abstract class UserDaoImp extends DaoGenericoImp<User> implements UserDao{

	public boolean logIn(String nombreUsuario, String password) {
		User resultado = buscarPorNombre(nombreUsuario);
		if(resultado==null)
			return false;
		else if(resultado.getPassword().equals(password))
			return false;
		else
			return true;
	}
	
	public User buscarPorNombre(String nombreUsuario) {
		Query query = this.em.createQuery("FROM User u where u.nombre LIKE :nombre");
		query.setParameter("nombre", nombreUsuario);
		List<User> lUsuario = query.getResultList();

		if (lUsuario != null) {
			User resultado = (User) query.getParameter(0);
			return resultado;
		}
		return null;
	}
}
