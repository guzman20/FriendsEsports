package com.FriendsEsports.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "juego")
public class Juego implements Serializable {
	
	private static final long serialVersionUID = -4755552236832699376L;
	
	private static final String imagenPath = "src/main/resources/static/imagenes-juegos/";
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id_juego")
	private Long idJuego;
	
	@NotNull(message= "No puede ser nulo el nombre.")
	@NotBlank(message= "No puede ser vacio el nombre.")
	@Column(name = "nombre", unique = true)
	private String nombre;
	
	@Column(name = "imagen")
	private String imagen;

	@OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Conversacion> conversaciones = new HashSet<>();

	public Juego(String nombre, String imagen) {
		this.nombre = nombre;
		this.imagen = imagen;
	}

	public Juego(String nombre) {
		this.nombre = nombre;
	}
	
	public Juego() {
		
	}

	public Long getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(Long idJuego) {
		this.idJuego = idJuego;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Conversacion> getConversaciones() {
		return conversaciones;
	}

	public void setConversaciones(Set<Conversacion> conversaciones) {
		this.conversaciones = conversaciones;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public static String getImagenPath() {
		return imagenPath;
	}
	
}	
