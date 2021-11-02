package com.FriendsEsports.servicios;

import java.util.List;

import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.Juego;
import com.FriendsEsports.entidades.Usuario;

public interface ConversacionServicio {
	
	public void borrarConversacion(Long idConversacion);

	public Conversacion editarConversacion(Long idConversacion, String titulo, String texto);
	
	public Conversacion obtenerConversacion(long idConversacion);
	
	public Conversacion crearConversacion(Juego juego, String titulo,String texto, Usuario usuario);
	
	public List<Conversacion> ObtenerListaPorJuegos(Juego juego);

	public List<Conversacion> ObtenerListaPorUsuario(Usuario u);
}
