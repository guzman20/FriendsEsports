package com.example.demo.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LineaCompraDao;
import com.example.demo.entidades.LineaCompra;

@Transactional
@Service
public class LineaCompraServicioImp implements LineaCompraServicio{

	@Autowired
	private LineaCompraDao lineaCompraDao;
	
	@Override
	public LineaCompra crearLineaCompra(LineaCompra lineaCompra) {
		return lineaCompraDao.crear(lineaCompra);
	}

}
