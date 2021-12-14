package com.FriendsEsports.servicios;

import java.util.List;

import com.FriendsEsports.entidades.Juego;

public interface JuegoServicio {

	Juego obtenerPorNombre(String juego);
	
	Juego obtenerPorId(long idjuego);

	List<Juego> listarJuegos();

	Juego crearJuego(Juego juego);

	boolean borrarJuego(Juego juego);
}
