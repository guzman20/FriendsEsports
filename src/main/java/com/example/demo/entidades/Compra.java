package com.example.demo.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compras")
public class Compra implements Serializable{
	
	private static final long serialVersionUID = -8459003842472014657L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCompras")
	private Long idCompra;

	@ManyToOne
	@JoinColumn(name = "idUsuarios")
	private User user;
	
	// Relación OneToMany LineasProducto
	@OneToMany(mappedBy="compra", 
			cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
			orphanRemoval=true)
	private Set<LineaCompra> productos = new HashSet<>();

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}
	
	public User User() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public Set<LineaCompra> getProductos() {
		return productos;
	}

	public void setProductos(Set<LineaCompra> productos) {
		this.productos = productos;
	}

	public User getUser() {
		return user;
	}
	
	

}
