package com.example.demo.dao;

import java.util.List;

import com.example.demo.entidades.Pregunta;
import com.example.demo.entidades.Producto;

public interface PreguntasDao {
	
	public List<Pregunta> listarPreguntasPorProducto(Producto producto);

}
