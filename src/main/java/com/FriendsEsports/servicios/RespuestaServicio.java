package com.FriendsEsports.servicios;

import java.util.List;

import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.Respuesta;
import com.FriendsEsports.entidades.Usuario;

public interface RespuestaServicio {

	public List<Respuesta> listarRespuestas(Conversacion conversacion);
	
	public Respuesta crearRespuesta(String respuesta, Usuario usuario, Conversacion idConversacion);
	
	public void borrarRespuesta(Long idRespuesta);
	
	public Respuesta editarRespuesta(Long idRespuesta, String respuesta);

}
