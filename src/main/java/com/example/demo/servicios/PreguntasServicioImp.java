package com.example.demo.servicios;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PreguntasDao;
import com.example.demo.dao.ProductoDao;
import com.example.demo.entidades.Pregunta;
import com.example.demo.entidades.PreguntaDTO;
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
	
	public PreguntaDTO conversionDTO(Pregunta pregunta) {
		
		PreguntaDTO preguntaDTO = new PreguntaDTO();
		preguntaDTO.setFechaDeCreacion(pregunta.fechaFormateada());
		preguntaDTO.setIdPregunta(pregunta.getIdPregunta());
		preguntaDTO.setIdProducto(pregunta.getProducto().getIdProducto());
		preguntaDTO.setIdUsuario(pregunta.getUsuario().getIdUsuarios());
		preguntaDTO.setNombreUsuario(pregunta.getUsuario().getNombre());
		preguntaDTO.setPregunta(pregunta.getPregunta());
		preguntaDTO.setRespuestas(pregunta.getRespuestas());
		
		return preguntaDTO;
		
	}

	@Override
	public void borrarPregunta(Long idPregunta) {
		preguntasDao.borrar(idPregunta);
	}


}
