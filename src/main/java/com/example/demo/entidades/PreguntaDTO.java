package com.example.demo.entidades;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;



public class PreguntaDTO {

	private Long idPregunta;

	private String pregunta;

	private LocalDateTime fechaDeCreacion;

	private Long idUsuario;
	
	private String nombreUsuario;

	private Long idProducto;

	private Set<Respuesta> respuestas = new HashSet<>();

	public PreguntaDTO(Long idPregunta, String pregunta, LocalDateTime fechaDeCreacion, Long idUsuario,
			String nombreUsuario, Long idProducto, Set<Respuesta> respuestas) {
		super();
		this.idPregunta = idPregunta;
		this.pregunta = pregunta;
		this.fechaDeCreacion = fechaDeCreacion;
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.idProducto = idProducto;
		this.respuestas = respuestas;
	}

	public PreguntaDTO() {
	}

	public Long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public LocalDateTime getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Set<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	
	
	
}
