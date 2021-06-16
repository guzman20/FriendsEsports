package com.example.demo.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RespuestasDao;
import com.example.demo.entidades.Tema;
import com.example.demo.entidades.Respuesta;
import com.example.demo.entidades.RespuestaDTO;
import com.example.demo.entidades.User;

@Transactional
@Service
public class RespuestaServicioImp implements RespuestaServicio {
	
	@Autowired
	private RespuestasDao respuestaDao;

	@Override
	public List<Respuesta> listarRespuestas(Tema tema) {
		return respuestaDao.listarRespuestasPorTema(tema);
	}

	@Override
	public Respuesta crearRespuesta(String texto, User usuario, Tema idTema) {
		Respuesta respuesta= new Respuesta(texto, usuario, idTema);
		respuestaDao.crear(respuesta);
		return respuesta;
	}

	@Override
	public RespuestaDTO conversionDTO(Respuesta respuesta) {

		RespuestaDTO temaDTO = new RespuestaDTO(respuesta.getIdRespuesta(), respuesta.getRespuesta(), respuesta.getUsuario().getNombre(), respuesta.getTema().getIdTema(), respuesta.fechaFormateada());
		return temaDTO;
	}

	@Override
	public void borrarRespuesta(Long idRespuesta) {
		respuestaDao.borrar(idRespuesta);
	}
	
	@Override
	public Respuesta editarRespuesta(Long idRespuesta, String respuesta) {
		Respuesta objRespuesta = respuestaDao.buscar(idRespuesta);
		respuestaDao.borrar(idRespuesta);
		objRespuesta.setRespuesta(respuesta);
		respuestaDao.crear(objRespuesta);
		return objRespuesta;
		
	}
}
