package com.example.demo.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	private String nombre;
	private String descripcion;
	private String imagen;
	
	public Producto() {
		
	}
	
	private Producto(String nombre, String descripcion, String imagen) {
		setNombre(nombre);
		setDescripcion(descripcion);
		setImagen(imagen);
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
}
