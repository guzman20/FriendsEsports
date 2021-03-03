package com.example.demo.servicios;

import java.util.List;

import com.example.demo.entidades.Pregunta;
import com.example.demo.entidades.PreguntaDTO;
import com.example.demo.entidades.Producto;
import com.example.demo.entidades.Respuesta;
import com.example.demo.entidades.RespuestaDTO;
import com.example.demo.entidades.User;

public interface RespuestaServicio {

	public List<Respuesta> listarRespuestas(Pregunta pregunta);
	
	public Respuesta crearRespuesta(String respuesta, User usuario, Pregunta idPregunta);
	
	public RespuestaDTO conversionDTO(Respuesta respuesta);
	
	public void borrarRespuesta(Long idRespuesta);
	
	public Respuesta editarRespuesta(Long idRespuesta, String respuesta);

}
