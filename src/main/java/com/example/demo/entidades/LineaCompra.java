package com.example.demo.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "lineadecompras")
public class LineaCompra implements Serializable{

//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -945618135868956277L;
//
//	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "compras", 
//	joinColumns = @JoinColumn(name = "idCompra"), 
//	inverseJoinColumns = @JoinColumn(name = "idCompras"))
//	private Long idCompra;
//	
//	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "productos", 
//	joinColumns = @JoinColumn(name = "idproducto"), 
//	inverseJoinColumns = @JoinColumn(name = "idproductos"))
//	private Long idProducto;
//	
//	@Column(name = "cantidad")
//	private int cantidad;
//	
//	public LineaCompra() {
//		
//	}
//
//	public LineaCompra(Long idCompra) {
//		this.idCompra = idCompra;
//	}
//
//	public Long getIdCompra() {
//		return idCompra;
//	}
//
//	public void setIdCompra(Long idCompra) {
//		this.idCompra = idCompra;
//	}
//
//	public Long getIdProducto() {
//		return idProducto;
//	}
//
//	public void setIdProducto(Long idProducto) {
//		this.idProducto = idProducto;
//	}
//
//	public int getCantidad() {
//		return cantidad;
//	}
//
//	public void setCantidad(int cantidad) {
//		this.cantidad = cantidad;
//	}


}
