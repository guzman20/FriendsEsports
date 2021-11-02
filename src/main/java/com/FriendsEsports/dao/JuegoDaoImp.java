package com.FriendsEsports.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.FriendsEsports.entidades.Juego;

@Repository
@Component("JuegoDao")
public class JuegoDaoImp extends DaoGenericoImp<Juego> implements JuegoDao{

	@Override
	public Juego obtenerPorNombre(String nombre) {
		Juego juego = new Juego();
		try{
			Query query = this.em.createQuery("FROM Juego j WHERE j.nombre=:nombre");
			query.setParameter("nombre", nombre);
			juego = (Juego)query.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
		return juego;
	}

	@Override
	public List<Juego> listarJuegos() {
		Query query =  this.em.createQuery("FROM Juego");
		query.setFirstResult(0);
		List<Juego> juegos =  query.getResultList();

		if (juegos != null) {
			return juegos;
		}
		return null;
	}

	

}
