package com.example.demo.servicios;

import java.util.List;

import com.example.demo.entidades.Conversacion;
import com.example.demo.entidades.User;

public interface ConversacionServicio {
	
	public void borrarConversacion(Long idConversacion);

	public Conversacion editarConversacion(Long idConversacion, String tema);
	
	public Conversacion obtenerConversacion(long idConversacion);
	
	public Conversacion crearConversacion(String tema, String titulo,String texto, User usuario);
	
	public List<Conversacion> ObtenerListaPorTemas(String tema);
}
