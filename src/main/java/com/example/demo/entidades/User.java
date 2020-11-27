package com.example.demo.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class User implements Serializable {
	
	
	private static final long serialVersionUID = -790316512454150774L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "idUsuarios")
	private Long idUsuarios;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "passwordusuario")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "fecha_Nacimiento")
	private String fecha_Nacimiento;
	
	@Column(name = "numeroTarjeta")
	private Integer numeroTarjeta;
	
	@Column(name = "titularTarjeta")
	private String titularTarjeta;
	
	@Column(name = "codigoSeguridad")
	private Integer codigoSeguridad;
	
	@Column(name = "direccion_facturacion")
	private String direccion_facturacion;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Compra> compra = new HashSet<>();
	
	
	public User() {
		
	}
	public User(Long idUsuarios, String nombre, String apellidos, String password, String email,
			String fecha_Nacimiento, Integer numeroTarjeta, String titularTarjeta, Integer codigoSeguridad,
			String direccion_facturacion) {
		this.idUsuarios = idUsuarios;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.password = password;
		this.email = email;
		this.fecha_Nacimiento = fecha_Nacimiento;
		this.numeroTarjeta = numeroTarjeta;
		this.titularTarjeta = titularTarjeta;
		this.codigoSeguridad = codigoSeguridad;
		this.direccion_facturacion = direccion_facturacion;
	}
	public User(String nombre, String apellidos, String password, String email, String fecha_Nacimiento,
			Integer numeroTarjeta, String titularTarjeta, Integer codigoSeguridad, String direccion_facturacion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.password = password;
		this.email = email;
		this.fecha_Nacimiento = fecha_Nacimiento;
		this.numeroTarjeta = numeroTarjeta;
		this.titularTarjeta = titularTarjeta;
		this.codigoSeguridad = codigoSeguridad;
		this.direccion_facturacion = direccion_facturacion;
	}
	public Long getIdUsuarios() {
		return idUsuarios;
	}
	public void setIdUsuarios(Long idUsuarios) {
		this.idUsuarios = idUsuarios;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}
	public void setFecha_Nacimiento(String fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}
	public Integer getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(Integer numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getTitularTarjeta() {
		return titularTarjeta;
	}
	public void setTitularTarjeta(String titularTarjeta) {
		this.titularTarjeta = titularTarjeta;
	}
	public Integer getCodigoSeguridad() {
		return codigoSeguridad;
	}
	public void setCodigoSeguridad(Integer codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}
	public String getDireccion_facturacion() {
		return direccion_facturacion;
	}
	public void setDireccion_facturacion(String direccion_facturacion) {
		this.direccion_facturacion = direccion_facturacion;
	}
	
	
	public Set<Compra> getProductos() {
		return compra;
	}

	public void setProductos(Set<Compra> compra) {
		this.compra = compra;
	}

	public boolean anadirProductos(Compra compra) {
		compra.setUser(this);
		return getProductos().add(compra);
		}
		public void eliminarEmails(Compra compra) {
			getProductos().remove(compra);
		}

	
	
	
	

}
