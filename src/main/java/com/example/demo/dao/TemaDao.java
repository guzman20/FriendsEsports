package com.example.demo.dao;


import java.util.List;

import com.example.demo.entidades.Tema;

public interface TemaDao extends DaoGenerico<Tema>{

	List<Tema> listarPorTemas(String tema);

}