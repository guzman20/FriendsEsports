package com.example.demo.entidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RespuestaDTO {
	
	private Long idRespuesta;

	private String respuesta;

	private String fechaDeCreacion;

	private User usuario;

	private Pregunta pregunta;
	
	public RespuestaDTO(Long idRespuesta, String respuesta, User usuario, Pregunta idPregunta) {
		this.idRespuesta = idRespuesta;
		this.respuesta = respuesta;
		String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
		this.fechaDeCreacion = timeStamp;
		this.usuario = usuario;
		this.pregunta = idPregunta;
	}

	public RespuestaDTO() {

	}

	public Long getIdRespuestaDTO() {
		return idRespuesta;
	}

	public void setIdRespuestaDTO(Long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public String getRespuestaDTO() {
		return respuesta;
	}

	public void setRespuestaDTO(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(String fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Pregunta getIdPregunta() {
		return pregunta;
	}

	public void setIdPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

}
