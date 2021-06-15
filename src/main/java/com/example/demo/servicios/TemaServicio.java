package com.example.demo.servicios;

import java.util.List;

import com.example.demo.entidades.Tema;
import com.example.demo.entidades.TemaDTO;
import com.example.demo.entidades.User;

public interface TemaServicio {
	
	public TemaDTO conversionDTO(Tema tema);
	
	public void borrarTema(Long idTema);

	public Tema editarTema(Long idTema, String tema);
	
	public Tema obtenerTema(long idTema);
	
	public Tema crearTema(User usuarios, String texto);
}
