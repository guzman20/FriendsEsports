package com.FriendsEsports.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class UsuarioDTO {

	@NotNull(message = "No puede ser nulo el nombre.")
	@NotBlank(message = "No puede ser vacio el nombre.")
	private String nombre;

	@NotNull(message = "No puede ser nulo la contraseña.")
	@NotBlank(message = "No puede ser vacio la contraseña.")
	private String contrasena;

	@NotNull(message = "No puede ser nulo el email.")
	@NotBlank(message = "No puede ser vacio el email.")
	private String email;

	@NotNull(message = "No puede ser nulo la fecha de nacimiento.")
	@NotBlank(message = "No puede ser vacio la fecha de nacimiento.")
	private String fechaNacimiento;

	private MultipartFile imagen;

	public UsuarioDTO(
			@NotNull(message = "No puede ser nulo el nombre.") @NotBlank(message = "No puede ser vacio el nombre.") String nombre,
			@NotNull(message = "No puede ser nulo la contraseña.") @NotBlank(message = "No puede ser vacio la contraseña.") String contrasena,
			@NotNull(message = "No puede ser nulo el email.") @NotBlank(message = "No puede ser vacio el email.") String email,
			@NotNull(message = "No puede ser nulo la fecha de nacimiento.") @NotBlank(message = "No puede ser vacio la fecha de nacimiento.") String fechaNacimiento,
			MultipartFile imagen) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public MultipartFile getImagen() {
		return imagen;
	}

	public void setImagen(MultipartFile imagen) {
		this.imagen = imagen;
	}

}
