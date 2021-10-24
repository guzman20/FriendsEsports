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
import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {


	private static final long serialVersionUID = -790316512454150774L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id_usuarios")
	private Long idUsuarios;

	@Column(name = "nombre", unique = true)
	private String nombre;

	@Column(name = "passwordusuario")
	private String password;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "fecha_Nacimiento")
	private String fecha_Nacimiento;
	
	@ManyToMany(mappedBy = "usuarios")
	private Set<Rol> roles = new HashSet<>();

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}


	public Usuario() {

	}
	public Usuario(Long idUsuarios, String nombre, String password, String email,
			String fecha_Nacimiento) {
		this.idUsuarios = idUsuarios;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.fecha_Nacimiento = fecha_Nacimiento;
	}
	public Usuario(String nombre, String password, String email, String fecha_Nacimiento) {
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.fecha_Nacimiento = fecha_Nacimiento;
	}
	public Long getIdUsuarios() {
		return idUsuarios;
	}
	public void setIdUsuarios(Long idUsuarios) {
		this.idUsuarios = idUsuarios;
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
	public String getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}
	public void setFecha_Nacimiento(String fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}

	public boolean anadirRol(Rol rol) {
		rol.anadirUsuario(this);
		return getRoles().add(rol);
	}

	public void eliminarRol(Rol rol) {
		this.roles.remove(rol);
		rol.getUsuarios().remove(this);
	}

	
}
