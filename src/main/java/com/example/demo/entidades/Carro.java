package com.example.demo.entidades;

public class Carro {
	
	private Long idProductoCarro;
	private String nombreProductoCarro;
	private Integer cantidadProductoCarro;
	
	public Carro() {
		
	}
	
	public Carro(Long idProductoCarro, String nombreProductoCarro,
			Integer cantidadProductoCarro) {
		super();
		this.idProductoCarro = idProductoCarro;
		this.nombreProductoCarro = nombreProductoCarro;
		this.cantidadProductoCarro = cantidadProductoCarro;
	}
	
	public Carro(Producto producto, Integer cantidadProductoCarro) {
		setIdProductoCarro(producto.getIdProducto());
		setNombreProductoCarro(producto.getNombre());
		setCantidadProductoCarro(cantidadProductoCarro);
	}
	

	public Carro(Producto producto) {
		setIdProductoCarro(producto.getIdProducto());
		setNombreProductoCarro(producto.getNombre());
		setCantidadProductoCarro(1);
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
	public Integer getCantidadProductoCarro() {
		return cantidadProductoCarro;
	}
	public void setCantidadProductoCarro(Integer cantidadProductoCarro) {
		this.cantidadProductoCarro = cantidadProductoCarro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProductoCarro == null) ? 0 : idProductoCarro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (idProductoCarro == null) {
			if (other.idProductoCarro != null)
				return false;
		} else if (!idProductoCarro.equals(other.idProductoCarro))
			return false;
		return true;
	}
	
	
	
}
