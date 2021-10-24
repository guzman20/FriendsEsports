package com.FriendsEsports.dao;

import java.util.List;

import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.Respuesta;


public interface RespuestasDao extends DaoGenerico<Respuesta>{
	
	public List<Respuesta> listarRespuestasPorConversacion(Conversacion conversacion);

}
