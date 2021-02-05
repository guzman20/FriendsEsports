package com.example.demo.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RespuestasDao;
import com.example.demo.entidades.Pregunta;
import com.example.demo.entidades.Respuesta;

@Transactional
@Service
public class RespuestaServicioImp implements RespuestaServicio {
	
	@Autowired
	private RespuestasDao respuestaDao;

	@Override
	public List<Respuesta> listarRespuestas(Pregunta pregunta) {
		return respuestaDao.listarRespuestasPorPregunta(pregunta);
	}

	

}
