package com.FriendsEsports.dao;


import java.util.List;

import com.FriendsEsports.entidades.Conversacion;

public interface ConversacionDao extends DaoGenerico<Conversacion>{

	List<Conversacion> listarPorJuegos(String juego);

}