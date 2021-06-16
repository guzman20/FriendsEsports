package com.example.demo.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ConversacionDao;
import com.example.demo.entidades.Conversacion;
import com.example.demo.entidades.User;


@Transactional
@Service
public class ConversacionServicioImp implements ConversacionServicio {
	
	@Autowired
	private ConversacionDao conversacionDao;

	@Override
	public void borrarConversacion(Long idConversacion) {
		conversacionDao.borrar(idConversacion);
	}

	@Override
	public Conversacion editarConversacion(Long idConversacion, String tema) {
		Conversacion objConversacion = conversacionDao.buscar(idConversacion);
		conversacionDao.borrar(idConversacion);
		conversacionDao.crear(objConversacion);
		return objConversacion;
		
	}

	@Override
	public Conversacion obtenerConversacion(long idConversacion) {
		return conversacionDao.buscar(idConversacion);
	}

	@Override
	public Conversacion crearConversacion(String tema, String titulo,String texto, User usuario) {
		Conversacion t= new Conversacion(tema, texto, titulo, usuario);
		conversacionDao.crear(t);
		return t;
	}

	@Override
	public List<Conversacion> ObtenerListaPorTemas(String tema) {
		return conversacionDao.listarPorTemas(tema);
	}

	


}
