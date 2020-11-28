package com.example.demo.entidades;

public class Carro {
	
	private Long idProductoCarro;
	private String nombreProductoCarro;
	private Double precioProductoCarro;
	private Integer cantidadProductoCarro;
	
	public Carro() {
		
	}
	
	public Carro(Long idProductoCarro, String nombreProductoCarro, Double precioProductoCarro,
			Integer cantidadProductoCarro) {
		super();
		this.idProductoCarro = idProductoCarro;
		this.nombreProductoCarro = nombreProductoCarro;
		this.precioProductoCarro = precioProductoCarro;
		this.cantidadProductoCarro = cantidadProductoCarro;
	}
	
	public Carro(Producto producto, Integer cantidadProductoCarro) {
		setIdProductoCarro(producto.getIdProducto());
		setNombreProductoCarro(producto.getNombre());
		setPrecioProductoCarro(producto.getPrecio());
		setCantidadProductoCarro(cantidadProductoCarro);
	}
	
	public Long getIdProductoCarro() {
		return idProductoCarro;
	}
	public void setIdProductoCarro(Long idProductoCarro) {
		this.idProductoCarro = idProductoCarro;
	}
	public String getNombreProductoCarro() {
		return nombreProductoCarro;
	}
	public void setNombreProductoCarro(String nombreProductoCarro) {
		this.nombreProductoCarro = nombreProductoCarro;
	}
	public Double getPrecioProductoCarro() {
		return precioProductoCarro;
	}
	public void setPrecioProductoCarro(Double precioProductoCarro) {
		this.precioProductoCarro = precioProductoCarro;
	}
	public Integer getCantidadProductoCarro() {
		return cantidadProductoCarro;
	}
	public void setCantidadProductoCarro(Integer cantidadProductoCarro) {
		this.cantidadProductoCarro = cantidadProductoCarro;
	}
	
	

}
