package com.example.demo.entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "preguntas")
public class Pregunta implements Serializable {

	private static final long serialVersionUID = -1491461123132939572L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "idPregunta")
	private Long idPregunta;

	@Column(name = "pregunta")
	private String pregunta;

	@Column(name = "fechaDeCreacion")
	private String fechaDeCreacion;

	@ManyToOne
	@JoinColumn(name = "idUsuarios")
	private User usuario;

	@ManyToOne
	@JoinColumn(name = "idproductos")
	private Producto producto;
	
	@OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Respuesta> respuestas = new HashSet<>();

	public Pregunta(Long idPregunta, String pregunta, User usuario, Producto producto) {
		this.idPregunta = idPregunta;
		this.pregunta = pregunta;
		this.usuario = usuario;
		this.producto = producto;
		String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
		this.fechaDeCreacion = timeStamp;
	}

	public Pregunta() {

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

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Set<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}



}
