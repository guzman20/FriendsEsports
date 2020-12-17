package com.example.demo.servicios;

import com.example.demo.entidades.Compra;
import com.example.demo.entidades.LineaCompra;


public interface CompraServicio {

	public Compra crearCompra(Compra compra);

	void addLineaCompra(Compra compra, LineaCompra lineaCompra);
}
