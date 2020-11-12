package com.example.demo.dao;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DaoGenericoImp<T>  implements DaoGenerico<T>{
	
	@PersistenceContext
	protected EntityManager em;

	private Class<T> type;

	@Override
	public long contarTodos(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T crear(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T buscar(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T actualizar(T t) {
		// TODO Auto-generated method stub
		return null;
	}

}
