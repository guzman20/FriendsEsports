package com.FriendsEsports.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FriendsEsports.dao.RespuestasDao;
import com.FriendsEsports.entidades.Conversacion;
import com.FriendsEsports.entidades.Respuesta;
import com.FriendsEsports.entidades.Usuario;

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
	public Respuesta crearRespuesta(String texto, Usuario usuario, Conversacion idConversacion) {
		Respuesta respuesta= new Respuesta(texto, usuario, idConversacion);
		respuestaDao.crear(respuesta);
		return respuesta;
	}

	@Override
	public void borrarRespuesta(Long idRespuesta) {
		respuestaDao.borrar(idRespuesta);
	}
	
	@Override
	public Respuesta editarRespuesta(Long idRespuesta, String texto) {
		Respuesta t = respuestaDao.buscar(idRespuesta);
		t.setRespuesta(texto);
		respuestaDao.borrar(idRespuesta);
		respuestaDao.crear(t);
		return t;
		
	}
}
