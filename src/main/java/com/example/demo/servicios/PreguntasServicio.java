package com.example.demo.servicios;

import java.util.List;

import com.example.demo.entidades.Pregunta;
import com.example.demo.entidades.Producto;
import com.example.demo.entidades.User;

public interface PreguntasServicio {
	
	public List<Pregunta> listarPreguntas(Producto producto);
	
	public Pregunta crearPregunta(String texto,User usuario, Producto producto);

}
