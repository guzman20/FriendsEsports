package com.example.demo.entidades;

import java.util.HashSet;
import java.util.Set;

public class TemaDTO {

	private Long idTema;

	private String tema;

	private String fechaDeCreacion;

	private Long idUsuario;
	
	private String nombreUsuario;

	private Long idProducto;

	private Set<Respuesta> respuestas = new HashSet<>();

	public TemaDTO(Long idTema, String tema, String fechaDeCreacion, Long idUsuario,
			String nombreUsuario, Long idProducto, Set<Respuesta> respuestas) {
		super();
		this.idTema = idTema;
		this.tema = tema;
		this.fechaDeCreacion = fechaDeCreacion;
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.idProducto = idProducto;
		this.respuestas = respuestas;
	}

	public TemaDTO() {
	}

	public Long getIdTema() {
		return idTema;
	}

	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(String fechaDeCreacion) {
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
