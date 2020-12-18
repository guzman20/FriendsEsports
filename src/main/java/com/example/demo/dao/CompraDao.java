package com.example.demo.dao;

import com.example.demo.entidades.Compra;
import com.example.demo.entidades.LineaCompra;

public interface CompraDao extends DaoGenerico<Compra> {

	public Compra addLineaCompra(Compra compra, LineaCompra lineaCompra);
	
}
