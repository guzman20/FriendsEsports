package com.example.demo.dao;


import java.util.List;

import com.example.demo.entidades.Conversacion;

public interface ConversacionDao extends DaoGenerico<Conversacion>{

	List<Conversacion> listarPorTemas(String tema);

}