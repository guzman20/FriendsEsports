package com.example.demo.entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuestas")
public class Respuesta implements Serializable {

	private static final long serialVersionUID = 4283034374507590772L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "idRespuesta")
	private Long idRespuesta;

	@Column(name = "respuesta")
	private String respuesta;

	@Column(name = "fechaDeCreacion")
	private LocalDateTime fechaDeCreacion;

	@ManyToOne
	@JoinColumn(name = "idUsuarios")
	private User usuario;

	@ManyToOne
	@JoinColumn(name = "idPregunta")
	private Pregunta pregunta;

	public Respuesta(String respuesta, User usuario, Pregunta idPregunta) {
		this.respuesta = respuesta;
		LocalDateTime date = LocalDateTime.now();
		this.fechaDeCreacion = date;
		this.usuario = usuario;
		this.pregunta = idPregunta;
	}

	public Respuesta() {

	}

	public Long getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(Long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public LocalDateTime getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setIdPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public String fechaFormateada() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDateTime = this.getFechaDeCreacion().format(formatter);
		
		return formattedDateTime;
		
	}
	
}
