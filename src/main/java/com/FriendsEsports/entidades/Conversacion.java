package com.FriendsEsports.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
@Table(name = "Conversaciones")
public class Conversacion implements Serializable {

	private static final long serialVersionUID = -1491461123132939572L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "idConversacion")
	private Long idConversacion;

	@Column(name= "juego")
	private String juego;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "texto")
	private String texto;

	@Column(name = "fechaDeCreacion")
	private LocalDateTime fechaDeCreacion;

	@ManyToOne
	@JoinColumn(name = "idUsuarios")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "conversacion", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Respuesta> respuestas = new HashSet<>();

	public Conversacion(String juego,String titulo, String texto, Usuario usuario) {
		this.juego = juego;
		this.titulo = titulo;
		this.texto = texto;
		this.usuario = usuario;
		LocalDateTime date = LocalDateTime.now();
		this.fechaDeCreacion = date;
	}

	public Conversacion() {

	}
	
	

	public String getTitulo() {
		return titulo;
	}

	public String getJuego() {
		return juego;
	}

	public void setJuego(String tema) {
		this.juego = juego;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getIdConversacion() {
		return idConversacion;
	}

	public void setIdConversacion(Long idConversacion) {
		this.idConversacion = idConversacion;
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

	public Set<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public String fechaFormateada() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDateTime = this.getFechaDeCreacion().format(formatter);
		
		return formattedDateTime;
		
	}

}
