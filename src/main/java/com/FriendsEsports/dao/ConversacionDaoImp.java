package com.FriendsEsports.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.Juego;
import com.FriendsEsports.entidades.Usuario;

@Repository
@Component("ConversacionDao")
public class ConversacionDaoImp extends DaoGenericoImp<Conversacion> implements ConversacionDao {

	@Override
	public List<Conversacion> listarPorJuegos(Juego juego) {
		Query query =  this.em.createQuery("FROM Conversacion as j where j.juego = :juego");
		query.setParameter("juego", juego);
		query.setFirstResult(0);
		List<Conversacion> conversaciones =  query.getResultList();

		if (conversaciones != null) {
			return conversaciones;
		}
		return null;
	}

	@Override
	public List<Conversacion> ObtenerListaPorUsuario(Usuario usuario) {
		Query query =  this.em.createQuery("FROM Conversacion as u where u.usuario = :usuario");
		query.setParameter("usuario", usuario);
		query.setFirstResult(0);
		List<Conversacion> conversaciones =  query.getResultList();

		if (conversaciones != null) {
			return conversaciones;
		}
		return null;
	}

	
}
