package com.example.demo.servicios;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PreguntasDao;
import com.example.demo.dao.ProductoDao;
import com.example.demo.entidades.Pregunta;
import com.example.demo.entidades.Producto;
import com.example.demo.entidades.User;


@Transactional
@Service
public class PreguntasServicioImp implements PreguntasServicio {
	
	@Autowired
	private PreguntasDao preguntasDao;
	
	public List<Pregunta> listarPreguntas(Producto producto) {
		return preguntasDao.listarPreguntasPorProducto(producto);
	}

	public Pregunta crearPregunta(String texto, User usuario, Producto producto) {
		Pregunta pregunta= new Pregunta(texto, usuario, producto);
		preguntasDao.crear(pregunta);
		return pregunta;
	}


}
