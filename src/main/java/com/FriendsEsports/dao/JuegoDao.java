package com.FriendsEsports.dao;

import java.util.List;

import com.FriendsEsports.entidades.Juego;

public interface JuegoDao extends DaoGenerico<Juego>{

	Juego obtenerPorNombre(String juego);

	List<Juego> listarJuegos();

}
