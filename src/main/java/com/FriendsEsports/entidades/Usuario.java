package com.FriendsEsports.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -790316512454150774L;

	private static final String imagenPath = "src/main/resources/static/imagenes-usuarios/";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@Column(name = "nombre", unique = true)
	private String nombre;

	@Column(name = "password_usuario")
	private String password;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "fecha_nacimiento")
	private String fechaNacimiento;

	@Column(name = "imagen")
	private String imagen;

	@ManyToMany(mappedBy = "usuarios", cascade = CascadeType.ALL)
	private Set<Rol> roles = new HashSet<>();

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Respuesta> respuestas = new HashSet<>();

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Conversacion> conversaciones = new HashSet<>();

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public Usuario() {

	}

	public Usuario(Long idUsuario, String nombre, String password, String email, String fechaNacimiento,
			String imagen) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.imagen = imagen;
	}

	public Usuario(Long idUsuario, String nombre, String password, String email, String fechaNacimiento) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Usuario(String nombre, String password, String email, String fechaNacimiento, String imagen) {
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.imagen = imagen;
	}

	public Usuario(String nombre, String password, String email, String fechaNacimiento) {
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean anadirRol(Rol rol) {
		rol.anadirUsuario(this);
		return getRoles().add(rol);
	}

	public void eliminarRol(Rol rol) {
		this.roles.remove(rol);
		rol.getUsuarios().remove(this);
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Set<Conversacion> getConversaciones() {
		return conversaciones;
	}

	public void setConversaciones(Set<Conversacion> conversaciones) {
		this.conversaciones = conversaciones;
	}

	public Set<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public static String getImagenPath() {
		return imagenPath;
	}

}
