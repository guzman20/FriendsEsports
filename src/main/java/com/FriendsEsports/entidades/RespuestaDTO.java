package com.FriendsEsports.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class RespuestaDTO {

	private Long idrespuesta;
	
	private String idConversacion;
	
	@NotNull(message= "No puede ser nulo el textoRespuesta.")
	@NotBlank(message= "No puede ser vacio el textoRespuesta.")
	private String textoRespuesta;
	
	private Usuario usuario;
	
	private MultipartFile imagen;
	
	private Set<Respuesta> respuestas = new HashSet<>();

	public RespuestaDTO(Long idrespuesta,
			String idConversacion,
			@NotNull(message = "No puede ser nulo el textoRespuesta.") @NotBlank(message = "No puede ser vacio el textoRespuesta.") String textoRespuesta,
			Usuario usuario,
			MultipartFile imagen, Set<Respuesta> respuestas) {
		super();
		this.idrespuesta = idrespuesta;
		this.idConversacion = idConversacion;
		this.textoRespuesta = textoRespuesta;
		this.usuario = usuario;
		this.imagen = imagen;
		this.respuestas = respuestas;
	}

	public RespuestaDTO() {
		
	}

	public Long getIdrespuesta() {
		return idrespuesta;
	}

	public void setIdrespuesta(Long idrespuesta) {
		this.idrespuesta = idrespuesta;
	}

	public String getConversacion() {
		return idConversacion;
	}

	public void setConversacion(String idConversacion) {
		this.idConversacion = idConversacion;
	}

	public String gettextoRespuesta() {
		return textoRespuesta;
	}

	public void settextoRespuesta(String textoRespuesta) {
		this.textoRespuesta = textoRespuesta;
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
