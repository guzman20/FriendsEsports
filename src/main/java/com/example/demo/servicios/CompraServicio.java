package com.example.demo.servicios;

import java.util.List;

import com.example.demo.entidades.Compra;
import com.example.demo.entidades.LineaCompra;
import com.example.demo.entidades.User;


public interface CompraServicio {

	public Compra crearCompra(Compra compra);

	void addLineaCompra(Compra compra, LineaCompra lineaCompra);

	public List<LineaCompra> listarCompra(Compra compra);
	
	public void borrarCompra(Long id);
}
