package com.example.demo.dao;

import java.util.List;

import com.example.demo.entidades.Conversacion;
import com.example.demo.entidades.Respuesta;


public interface RespuestasDao extends DaoGenerico<Respuesta>{
	
	public List<Respuesta> listarRespuestasPorConversacion(Conversacion conversacion);

}
