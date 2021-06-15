package com.example.demo.servicios;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TemaDao;
import com.example.demo.entidades.Tema;
import com.example.demo.entidades.TemaDTO;
import com.example.demo.entidades.User;


@Transactional
@Service
public class TemaServicioImp implements TemaServicio {
	
	@Autowired
	private TemaDao temasDao;
	
	public TemaDTO conversionDTO(Tema tema) {
		
		TemaDTO temaDTO = new TemaDTO();
		temaDTO.setFechaDeCreacion(tema.fechaFormateada());
		temaDTO.setIdTema(tema.getIdTema());
		temaDTO.setIdUsuario(tema.getUsuario().getIdUsuarios());
		temaDTO.setNombreUsuario(tema.getUsuario().getNombre());
		temaDTO.setTema(tema.getTema());
		temaDTO.setRespuestas(tema.getRespuestas());
		
		return temaDTO;
		
	}

	@Override
	public void borrarTema(Long idTema) {
		temasDao.borrar(idTema);
	}

	@Override
	public Tema editarTema(Long idTema, String tema) {
		Tema objTema = temasDao.buscar(idTema);
		temasDao.borrar(idTema);
		objTema.setTema(tema);
		temasDao.crear(objTema);
		return objTema;
		
	}

	@Override
	public Tema obtenerTema(long idTema) {
		return temasDao.buscar(idTema);
	}

	@Override
	public Tema crearTema(User usuarios, String texto) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
