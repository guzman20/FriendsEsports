package com.example.demo.dao;

import java.util.List;

import com.example.demo.entidades.LineaCompra;
import com.example.demo.entidades.User;

public interface LineaCompraDao extends DaoGenerico<LineaCompra>{
	public List<LineaCompra> buscarComprasPorIdCompra(User usuario);
	
	public LineaCompra actualizar(LineaCompra lineaCompra);
}
