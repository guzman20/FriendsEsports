package com.example.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.User;

@Repository
@Component("UserDao")
public class UserDaoImp extends DaoGenericoImp<User> implements UserDao{

	@Override
	public boolean logIn(String nombreUsuario, String password) {
		User resultado = buscarPorNombre(nombreUsuario);
		if(resultado==null)
			return false;
		else if(resultado.getPassword().equals(password))
			return false;
		else
			return true;
	}
	
	@Override
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
