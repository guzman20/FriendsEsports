package com.example.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.example.demo.entidades.Tema;

@Repository
@Component("TemaDao")
public class TemaDaoImp extends DaoGenericoImp<Tema> implements TemaDao {

	@Override
	public List<Tema> listarPorTemas(String tema) {
		Query query =  this.em.createQuery("FROM Tema as t where t.tema = :tema");
		query.setParameter("tema", tema);
		query.setFirstResult(0);
		List<Tema> temas =  query.getResultList();

		if (temas != null) {
			return temas;
		}
		return null;
	}

	
}
