package com.example.demo.servicios;

import java.util.List;

import com.example.demo.entidades.Conversacion;
import com.example.demo.entidades.Respuesta;
import com.example.demo.entidades.RespuestaDTO;
import com.example.demo.entidades.User;

public interface RespuestaServicio {

	public List<Respuesta> listarRespuestas(Conversacion conversacion);
	
	public Respuesta crearRespuesta(String respuesta, User usuario, Conversacion idConversacion);
	
	public RespuestaDTO conversionDTO(Respuesta respuesta);
	
	public void borrarRespuesta(Long idRespuesta);
	
	public Respuesta editarRespuesta(Long idRespuesta, String respuesta);

}
