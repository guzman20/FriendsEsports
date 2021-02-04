package com.example.demo.servicios;

import java.util.List;

import com.example.demo.entidades.Pregunta;
import com.example.demo.entidades.Respuesta;

public interface RespuestaServicio {

	public List<Respuesta> listarRespuestas(Pregunta pregunta);

}
