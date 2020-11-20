package com.example.demo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class User implements Serializable {
	
	private static final long serialVersionUID = -8668594760203621162L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "idusuarios")
	private Long idUsuarios;
	
	@Column(name = "nombreusuario")
	private String nombreUsuario;
	
	@Column(name = "passwordusuario")
	private String passwordUsuario;
	
	public User() {
		
	}
	
	private User(String nombreUsuario, String passwordUsuario) {
		setNombreUsuario(nombreUsuario);
		setPassword(passwordUsuario);
	}
	
	public Long getIdUsuarios() {
		return idUsuarios;
	}

	public void setIdUsuarios(Long idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return passwordUsuario;
	}

	public void setPassword(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

}
