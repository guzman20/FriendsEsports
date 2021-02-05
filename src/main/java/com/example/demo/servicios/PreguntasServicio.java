package com.example.demo.servicios;

import java.util.List;

import com.example.demo.entidades.Pregunta;
import com.example.demo.entidades.Producto;

public interface PreguntasServicio {
	
	public List<Pregunta> listarPreguntas(Producto producto);

}
