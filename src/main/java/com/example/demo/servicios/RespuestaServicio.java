package com.example.demo.servicios;

import java.util.List;

import com.example.demo.entidades.Conversacion;
import com.example.demo.entidades.Respuesta;
import com.example.demo.entidades.User;

public interface RespuestaServicio {

	public List<Respuesta> listarRespuestas(Conversacion conversacion);
	
	public Respuesta crearRespuesta(String respuesta, User usuario, Conversacion idConversacion);
	
	public void borrarRespuesta(Long idRespuesta);
	
	public Respuesta editarRespuesta(Long idRespuesta, String respuesta);

}
