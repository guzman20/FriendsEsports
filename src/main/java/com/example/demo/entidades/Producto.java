package com.example.demo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = -8668594760203621162L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "idproductos")
	private Long idProducto;
	
	@Column(name = "nombreproducto")
	private String nombre;
	
	@Column(name = "descripcionproducto")
	private String descripcion;
	
	@Column(name = "imagenproducto")
	private String imagen;
	
	@Column(name = "precio")
	private int precio;

	public Producto() {
		
	}
	
	private Producto(String nombre, String descripcion, String imagen, int precio) {
		setNombre(nombre);
		setDescripcion(descripcion);
		setImagen(imagen);
		setPrecio(precio);
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
