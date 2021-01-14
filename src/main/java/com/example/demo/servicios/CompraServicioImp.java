package com.example.demo.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CompraDao;
import com.example.demo.entidades.Compra;
import com.example.demo.entidades.LineaCompra;
import com.example.demo.entidades.Producto;
import com.example.demo.entidades.User;

@Transactional
@Service
public class CompraServicioImp implements CompraServicio {
	
	@Autowired
	private CompraDao compraDao;

	@Override
	public Compra crearCompra(Compra compra) {
		return compraDao.crear(compra);
	}

	@Override
	public void addLineaCompra(Compra compra, LineaCompra lineaCompra) {
		compra=compraDao.addLineaCompra(compra, lineaCompra);
		
	}

	public List<Compra> comprasDeUsuario(User usuario){
		return compraDao.comprasUsuarios(usuario);
	}

	@Override
	public Compra buscarCompra(Long id) {
		return compraDao.buscar(id);
	}

	@Override
	public List<LineaCompra> listarCompra(Compra compra) {
		return compraDao.listarCompra(compra);
	}

	@Override
	public void borrarCompra(Long id) {
		compraDao.borrar(id);
		
	}
	

}
