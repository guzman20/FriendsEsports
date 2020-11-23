package com.example.demo.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.NoResultException;
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
		else if(!resultado.getPassword().equals(password))
			return false;
		else
			return true;
	}
	
	@Override
	public User buscarPorNombre(String nombreUsuario) {
		
		User usuario = new User();
		try{
			Query query = this.em.createQuery("FROM User u WHERE u.nombre=:a");
			query.setParameter("a", nombreUsuario);
			usuario = (User)query.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
		return usuario;
	}
}
