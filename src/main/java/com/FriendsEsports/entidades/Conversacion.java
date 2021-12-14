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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "conversacion")
public class Conversacion implements Serializable {

	private static final long serialVersionUID = -1491461123132939572L;
	
	private static final String imagenPath = "src/main/resources/static/imagenes-conversacion/";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_conversacion")
	private Long idConversacion;

	@NotNull(message= "No puede ser nulo el juego.")
	@ManyToOne
	@JoinColumn(name = "id_juego")
	private Juego juego;

	@NotNull(message= "No puede ser nulo el titulo.")
	@NotBlank(message= "No puede ser vacio el titulo.")
	@Column(name = "titulo")
	private String titulo;

	@NotNull(message= "No puede ser nulo el texto.")
	@NotBlank(message= "No puede ser vacio el texto.")
	@Column(name = "texto")
	private String texto;

	@Column(name = "fecha_de_creacion")
	private LocalDateTime fechaDeCreacion;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@Column(name = "imagen")
	private String imagen;

	@OneToMany(mappedBy = "conversacion", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Respuesta> respuestas = new HashSet<>();

	public Conversacion(Juego juego, String titulo, String texto, Usuario usuario) {
		this.juego = juego;
		this.titulo = titulo;
		this.texto = texto;
		this.usuario = usuario;
		LocalDateTime date = LocalDateTime.now();
		this.fechaDeCreacion = date;
	}
	
	

	public Conversacion(Juego juego, String titulo, String texto, Usuario usuario, String imagen) {
		super();
		this.juego = juego;
		this.titulo = titulo;
		this.texto = texto;
		this.usuario = usuario;
		this.imagen = imagen;
		LocalDateTime date = LocalDateTime.now();
		this.fechaDeCreacion = date;
	}



	public Conversacion() {

	}

	public String getTitulo() {
		return titulo;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
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
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public static String getImagenPath() {
		return imagenPath;
	}

	public String fechaFormateada() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDateTime = this.getFechaDeCreacion().format(formatter);

		return formattedDateTime;

	}

	public String horaFormateada() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
		String formattedDateTime = this.getFechaDeCreacion().format(formatter);

		return formattedDateTime;

	}

}
