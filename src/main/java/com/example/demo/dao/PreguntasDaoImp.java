package com.example.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.LineaCompra;
import com.example.demo.entidades.Pregunta;
import com.example.demo.entidades.Producto;

@Repository
@Component("Pregunta")
public class PreguntasDaoImp extends DaoGenericoImp<Pregunta> implements PreguntasDao {

	@Override
	public List<Pregunta> listarPreguntasPorProducto(Producto producto) {
		Query query =  this.em.createQuery("FROM Pregunta as p where p.producto = :producto");
		query.setParameter("producto", producto);
		query.setFirstResult(0);
		List<Pregunta> preguntas =  query.getResultList();

		if (preguntas != null) {
			return preguntas;
		}
		return null;
	}
	
}
