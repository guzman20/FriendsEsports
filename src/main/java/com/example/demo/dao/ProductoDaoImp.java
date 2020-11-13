package com.example.demo.dao;

import java.util.List;

import com.example.demo.entidades.Producto;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("ProductoDao")
public class ProductoDaoImp extends DaoGenericoImp<Producto> implements ProductoDao {

	@Override
	public Producto buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto buscarPorCategoria(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto anadirProducto(String nombre, String descripcion, String imagen) {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public List<Producto> listarProductos() {
		Query query =  this.em.createQuery("FROM Producto");
		List<Producto> lProducto =  query.getResultList();

		if (lProducto != null) {
			return lProducto;
		}
		return null;
	}

}
