package com.example.demo.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductoDao;
import com.example.demo.entidades.Producto;

@Transactional
@Service
public class ProductoServicioImp implements ProductoServicio {
	
	@Autowired
	private ProductoDao productoDao;
	

	@Override
	public Producto crearProducto(Producto producto) {
		return productoDao.crear(producto);
	}

	@Override
	public void eliminarProducto(long idProducto) {
		productoDao.borrar(idProducto);
		
	}

	@Override
	public Producto obtenerProducto(long idProducto) {
		
		return productoDao.buscar(idProducto);
	}

	@Override
	public Producto modificarProducto(Producto profesor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> listarProductos() {
		return productoDao.listarProductos();
	}

}
