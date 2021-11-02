package com.FriendsEsports.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FriendsEsports.dao.JuegoDao;
import com.FriendsEsports.entidades.Juego;

@Transactional
@Service
public class JuegoServicioImp implements JuegoServicio{
	
	@Autowired
	private JuegoDao juegoDao;

	@Override
	public Juego obtenerPorNombre(String juego) {
		return juegoDao.obtenerPorNombre(juego);
	}

	@Override
	public List<Juego> listarJuegos() {
		return juegoDao.listarJuegos();
	}

	@Override
	public Juego obtenerPorId(long idjuego) {
		return juegoDao.buscar(idjuego);
	}
}
