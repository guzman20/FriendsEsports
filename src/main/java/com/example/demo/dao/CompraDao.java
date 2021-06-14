package com.example.demo.dao;

import java.util.List;

import com.example.demo.entidades.Compra;
import com.example.demo.entidades.LineaCompra;
import com.example.demo.entidades.User;

public interface CompraDao extends DaoGenerico<Compra> {

	public Compra addLineaCompra(Compra compra, LineaCompra lineaCompra);
	
	public List<LineaCompra> listarCompra(Compra compra);
}
