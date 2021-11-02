package com.FriendsEsports.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FriendsEsports.dao.ConversacionDao;
import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.Juego;
import com.FriendsEsports.entidades.Usuario;

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
	public Conversacion editarConversacion(Long idConversacion, String titulo, String texto) {
		Conversacion t = conversacionDao.buscar(idConversacion);
		t.setTitulo(titulo);
		t.setTexto(texto);
		conversacionDao.borrar(idConversacion);
		conversacionDao.crear(t);
		return t;

	}

	@Override
	public Conversacion obtenerConversacion(long idConversacion) {
		return conversacionDao.buscar(idConversacion);
	}

	@Override
	public Conversacion crearConversacion(Juego juego, String titulo, String texto, Usuario usuario) {
		Conversacion t = new Conversacion(juego, texto, titulo, usuario);
		conversacionDao.crear(t);
		return t;
	}

	@Override
	public List<Conversacion> ObtenerListaPorJuegos(Juego juego) {
		return conversacionDao.listarPorJuegos(juego);
	}

	@Override
	public List<Conversacion> ObtenerListaPorUsuario(Usuario u) {
		return conversacionDao.ObtenerListaPorUsuario(u);
	}

}
