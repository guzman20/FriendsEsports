package com.FriendsEsports.entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuesta")
public class Respuesta implements Serializable {

	private static final long serialVersionUID = 4283034374507590772L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id_respuesta")
	private Long idRespuesta;

	@Column(name = "respuesta")
	private String respuesta;

	@Column(name = "fecha_de_creacion")
	private LocalDateTime fechaDeCreacion;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_conversacion")
	private Conversacion conversacion;

	public Respuesta(String respuesta, Usuario usuario, Conversacion idConversacion) {
		this.respuesta = respuesta;
		LocalDateTime date = LocalDateTime.now();
		this.fechaDeCreacion = date;
		this.usuario = usuario;
		this.conversacion = idConversacion;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Conversacion getConversacion() {
		return conversacion;
	}

	public void setIdConversacion(Conversacion conversacion) {
		this.conversacion = conversacion;
	}

	public String fechaFormateada() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDateTime = this.getFechaDeCreacion().format(formatter);

		return formattedDateTime;

	}

	public String horaFormateada() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
		String formattedDateTime = this.getFechaDeCreacion().format(formatter);

		return formattedDateTime;

	}
	
}
