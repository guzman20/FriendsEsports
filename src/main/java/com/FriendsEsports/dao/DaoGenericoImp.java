package com.FriendsEsports.dao;

import java.util.Map;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DaoGenericoImp<T>  implements DaoGenerico<T>{
	
	@PersistenceContext
	protected EntityManager em;

	private Class<T> type;
	
	public DaoGenericoImp() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public long contarTodos(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T crear(T t) {
		this.em.persist(t);
		return t;
	}

	@Override
	public void borrar(Object id) {
		this.em.remove(this.em.getReference(type, id));
		
	}

	@Override
	public T buscar(Object id) {
		return (T) this.em.find(type, id);
	}

	@Override
	public T actualizar(T entity) {
		return (T) this.em.merge(entity);
	}

	

}
