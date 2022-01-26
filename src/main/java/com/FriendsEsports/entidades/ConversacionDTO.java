package com.FriendsEsports.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class ConversacionDTO {

	private Long idConversacion;
	
	private String idJuego;
	
	@NotNull(message= "No puede ser nulo el titulo.")
	@NotBlank(message= "No puede ser vacio el titulo.")
	private String titulo;
	
	@NotNull(message= "No puede ser nulo el texto.")
	@NotBlank(message= "No puede ser vacio el texto.")
	private String texto;
	
	private Usuario usuario;
	
	private MultipartFile imagen;
	
	private Set<Respuesta> respuestas = new HashSet<>();

	public ConversacionDTO() {
	}

	public ConversacionDTO(Long idConversacion,
			@NotNull(message = "No puede ser nulo el juego.") String idJuego,
			@NotNull(message = "No puede ser nulo el titulo.") @NotBlank(message = "No puede ser vacio el titulo.") String titulo,
			@NotNull(message = "No puede ser nulo el texto.") @NotBlank(message = "No puede ser vacio el texto.") String texto,
			@NotNull(message = "No puede ser nulo el juego.") Usuario usuario,
			MultipartFile imagen, Set<Respuesta> respuestas) {
		super();
		this.idConversacion = idConversacion;
		this.idJuego = idJuego;
		this.titulo = titulo;
		this.texto = texto;
		this.usuario = usuario;
		this.imagen = imagen;
		this.respuestas = respuestas;
	}

	public Long getIdConversacion() {
		return idConversacion;
	}

	public void setIdConversacion(Long idConversacion) {
		this.idConversacion = idConversacion;
	}

	public String getJuego() {
		return idJuego;
	}

	public void setJuego(String idJuego) {
		this.idJuego = idJuego;
	}

	public String getTitulo() {
		return titulo;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public MultipartFile getImagen() {
		return imagen;
	}

	public void setImagen(MultipartFile imagen) {
		this.imagen = imagen;
	}

	public Set<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	
	
	
}
