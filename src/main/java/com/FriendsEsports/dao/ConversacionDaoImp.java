package com.FriendsEsports.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.FriendsEsports.entidades.Conversacion;

@Repository
@Component("ConversacionDao")
public class ConversacionDaoImp extends DaoGenericoImp<Conversacion> implements ConversacionDao {

	@Override
	public List<Conversacion> listarPorJuegos(String juego) {
		Query query =  this.em.createQuery("FROM Conversacion as j where j.juego = :juego");
		query.setParameter("juego", juego);
		query.setFirstResult(0);
		List<Conversacion> conversaciones =  query.getResultList();

		if (conversaciones != null) {
			return conversaciones;
		}
		return null;
	}

	
}
