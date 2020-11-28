package com.example.demo.entidades;

public class Carro {
	
	private Long idProductoCarrito;
	private String nombreProductoCarrito;
	private Double precioProductoCarrito;
	private Integer cantidadProductoCarrito;
	
	public Carro() {
		
	}
	
	public Carro(Long idProductoCarrito, String nombreProductoCarrito, Double precioProductoCarrito,
			Integer cantidadProductoCarrito) {
		super();
		this.idProductoCarrito = idProductoCarrito;
		this.nombreProductoCarrito = nombreProductoCarrito;
		this.precioProductoCarrito = precioProductoCarrito;
		this.cantidadProductoCarrito = cantidadProductoCarrito;
	}
	public Long getIdProductoCarrito() {
		return idProductoCarrito;
	}
	public void setIdProductoCarrito(Long idProductoCarrito) {
		this.idProductoCarrito = idProductoCarrito;
	}
	public String getNombreProductoCarrito() {
		return nombreProductoCarrito;
	}
	public void setNombreProductoCarrito(String nombreProductoCarrito) {
		this.nombreProductoCarrito = nombreProductoCarrito;
	}
	public Double getPrecioProductoCarrito() {
		return precioProductoCarrito;
	}
	public void setPrecioProductoCarrito(Double precioProductoCarrito) {
		this.precioProductoCarrito = precioProductoCarrito;
	}
	public Integer getCantidadProductoCarrito() {
		return cantidadProductoCarrito;
	}
	public void setCantidadProductoCarrito(Integer cantidadProductoCarrito) {
		this.cantidadProductoCarrito = cantidadProductoCarrito;
	}
	
	

}
