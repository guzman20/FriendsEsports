package com.FriendsEsports.entidades;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class JuegoDTO {

	@NotNull(message = "No puede ser nulo el nombre.")
	@NotBlank(message = "No puede ser vacio el nombre.")
	private String nombre;

	private MultipartFile imagen;

	public JuegoDTO() {
		super();
	}

	public JuegoDTO(
			@NotNull(message = "No puede ser nulo el nombre.") @NotBlank(message = "No puede ser vacio el nombre.") String nombre,
			MultipartFile imagen) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public MultipartFile getImagen() {
		return imagen;
	}

	public void setImagen(MultipartFile imagen) {
		this.imagen = imagen;
	}

}
