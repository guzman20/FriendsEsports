package com.example.demo.servicios;

import java.util.List;

import com.example.demo.entidades.Tema;
import com.example.demo.entidades.User;

public interface TemaServicio {
	
	public void borrarTema(Long idTema);

	public Tema editarTema(Long idTema, String tema);
	
	public Tema obtenerTema(long idTema);
	
	public Tema crearTema(String tema, String titulo,String texto, User usuario);
	
	public List<Tema> ObtenerListaPorTemas(String tema);
}
