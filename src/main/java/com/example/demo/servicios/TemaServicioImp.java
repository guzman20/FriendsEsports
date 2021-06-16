package com.example.demo.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TemaDao;
import com.example.demo.entidades.Tema;
import com.example.demo.entidades.User;


@Transactional
@Service
public class TemaServicioImp implements TemaServicio {
	
	@Autowired
	private TemaDao temasDao;

	@Override
	public void borrarTema(Long idTema) {
		temasDao.borrar(idTema);
	}

	@Override
	public Tema editarTema(Long idTema, String tema) {
		Tema objTema = temasDao.buscar(idTema);
		temasDao.borrar(idTema);
		temasDao.crear(objTema);
		return objTema;
		
	}

	@Override
	public Tema obtenerTema(long idTema) {
		return temasDao.buscar(idTema);
	}

	@Override
	public Tema crearTema(String tema, String titulo,String texto, User usuario) {
		Tema t= new Tema(tema, texto, titulo, usuario);
		temasDao.crear(t);
		return t;
	}

	@Override
	public List<Tema> ObtenerListaPorTemas(String tema) {
		return temasDao.listarPorTemas(tema);
	}

	


}
