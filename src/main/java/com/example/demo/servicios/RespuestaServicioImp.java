package com.example.demo.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RespuestasDao;
import com.example.demo.entidades.Conversacion;
import com.example.demo.entidades.Respuesta;
import com.example.demo.entidades.RespuestaDTO;
import com.example.demo.entidades.User;

@Transactional
@Service
public class RespuestaServicioImp implements RespuestaServicio {
	
	@Autowired
	private RespuestasDao respuestaDao;

	@Override
	public List<Respuesta> listarRespuestas(Conversacion conversacion) {
		return respuestaDao.listarRespuestasPorConversacion(conversacion);
	}

	@Override
	public Respuesta crearRespuesta(String texto, User usuario, Conversacion idConversacion) {
		Respuesta respuesta= new Respuesta(texto, usuario, idConversacion);
		respuestaDao.crear(respuesta);
		return respuesta;
	}

	@Override
	public RespuestaDTO conversionDTO(Respuesta respuesta) {

		RespuestaDTO respuestaDTO = new RespuestaDTO(respuesta.getIdRespuesta(), respuesta.getRespuesta(), respuesta.getUsuario().getNombre(), respuesta.getConversacion().getIdConversacion(), respuesta.fechaFormateada());
		return respuestaDTO;
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
