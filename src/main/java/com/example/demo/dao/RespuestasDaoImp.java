package com.example.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Conversacion;
import com.example.demo.entidades.Respuesta;

@Repository
@Component("Respuesta")
public class RespuestasDaoImp extends DaoGenericoImp<Respuesta> implements RespuestasDao{

	@Override
	public List<Respuesta> listarRespuestasPorConversacion(Conversacion conversacion) {
		Query query =  this.em.createQuery("FROM Respuesta as t where t.conversacion = :conversacion");
		query.setParameter("conversacion", conversacion);
		query.setFirstResult(0);
		List<Respuesta> respuestas =  query.getResultList();

		if (respuestas != null) {
			return respuestas;
		}
		return null;
	}

}
