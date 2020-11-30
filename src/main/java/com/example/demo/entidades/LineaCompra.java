package com.example.demo.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lineadecompras")
public class LineaCompra implements Serializable{

	private static final long serialVersionUID = -945618135868956277L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idLineaCompra")
	private Long idLineaCompra;
	
	@ManyToOne
	@JoinColumn(name = "idCompras")
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name = "idproductos")
	private Producto producto;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	public LineaCompra() {
		
	}


	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Compra getCompra() {
		return compra;
	}


	public void setCompra(Compra compra) {
		this.compra = compra;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		producto = producto;
	}


}
