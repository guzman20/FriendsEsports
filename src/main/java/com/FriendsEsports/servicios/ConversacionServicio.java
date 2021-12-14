package com.FriendsEsports.servicios;

import java.util.List;

import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.Juego;
import com.FriendsEsports.entidades.Usuario;

public interface ConversacionServicio {
	
	public void borrarConversacion(Long idConversacion);

	public Conversacion editarConversacion(Long idConversacion, String titulo, String texto);
	
	public Conversacion editarConversacion(Long idConversacion, String titulo, String texto, String imagen);
	
	public Conversacion obtenerConversacion(long idConversacion);
	
	public Conversacion crearConversacion(Conversacion c);
	
	public List<Conversacion> ObtenerListaPorJuegos(Juego juego);

	public List<Conversacion> ObtenerListaPorUsuario(Usuario u);
}
