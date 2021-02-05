package com.example.demo.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PreguntasDao;
import com.example.demo.dao.ProductoDao;
import com.example.demo.entidades.Pregunta;
import com.example.demo.entidades.Producto;


@Transactional
@Service
public class PreguntasServicioImp implements PreguntasServicio {
	
	@Autowired
	private PreguntasDao preguntasDao;
	
	public List<Pregunta> listarPreguntas(Producto producto) {
		return preguntasDao.listarPreguntasPorProducto(producto);
	}

}
