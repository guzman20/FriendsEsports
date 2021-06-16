package com.example.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.example.demo.entidades.Conversacion;

@Repository
@Component("ConversacionDao")
public class ConversacionDaoImp extends DaoGenericoImp<Conversacion> implements ConversacionDao {

	@Override
	public List<Conversacion> listarPorTemas(String tema) {
		Query query =  this.em.createQuery("FROM Conversacion as t where t.tema = :tema");
		query.setParameter("tema", tema);
		query.setFirstResult(0);
		List<Conversacion> conversaciones =  query.getResultList();

		if (conversaciones != null) {
			return conversaciones;
		}
		return null;
	}

	
}
