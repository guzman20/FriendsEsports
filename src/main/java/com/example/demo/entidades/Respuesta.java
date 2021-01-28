package com.example.demo.entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
	private String fechaDeCreacion;

	@ManyToOne
	@JoinColumn(name = "idUsuarios")
	private User usuario;

	@ManyToOne
	@JoinColumn(name = "idPregunta")
	private Pregunta pregunta;

	public Respuesta(Long idRespuesta, String respuesta, User usuario, Pregunta idPregunta) {
		this.idRespuesta = idRespuesta;
		this.respuesta = respuesta;
		String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
		this.fechaDeCreacion = timeStamp;
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
