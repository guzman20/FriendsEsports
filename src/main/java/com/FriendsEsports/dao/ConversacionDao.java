package com.FriendsEsports.dao;


import java.util.List;

import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.Juego;
import com.FriendsEsports.entidades.Usuario;

public interface ConversacionDao extends DaoGenerico<Conversacion>{

	List<Conversacion> listarPorJuegos(Juego juego);

	List<Conversacion> ObtenerListaPorUsuario(Usuario u);

}