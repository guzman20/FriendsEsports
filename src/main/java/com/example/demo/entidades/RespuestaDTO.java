package com.example.demo.entidades;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

public class RespuestaDTO {
	
	private Long idRespuesta;

	private String respuesta;

	private String fechaDeCreacion;

	private String nombreUsuario;

	private Long idConversacion;
	
	public RespuestaDTO(Long idRespuesta, String respuesta, String nombreUsuario, Long idConversacion, String fecha) {
		this.idRespuesta = idRespuesta;
		this.respuesta = respuesta;
		this.fechaDeCreacion = fecha;
		this.nombreUsuario = nombreUsuario;
		this.idConversacion = idConversacion;
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

	public String getUsuario() {
		return nombreUsuario;
	}

	public void setUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Long getIdConversacion() {
		return idConversacion;
	}

	public void setIdConversacion(Long idConversacion) {
		this.idConversacion = idConversacion;
	}

}
