package com.ma.pedidos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7767005289119515993L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="id", unique=true, nullable=false)
	private Long id;
	
	private String direccion;
	
	private String email;
	
	private String telefono;
	
	private LocalTime horario;
	
	private LocalDate fechaAlta;
	
	private Double montoTotal;
	
	private boolean aplicoDescuento;
	
	private String estado;
	
	@OneToMany(mappedBy = "pedido")
	//@Fetch(FetchMode.SELECT)
	private Set<PedidoDetalle> detalle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public boolean getAplicoDescuento() {
		return aplicoDescuento;
	}

	public void setAplicoDescuento(boolean aplicoDescuento) {
		this.aplicoDescuento = aplicoDescuento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set<PedidoDetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(Set<PedidoDetalle> detalle) {
		this.detalle = detalle;
	}

	public Pedido(Long id, String direccion, String email, String telefono, LocalTime horario, LocalDate fechaAlta,
			Double montoTotal, boolean aplicoDescuento, String estado, Set<PedidoDetalle> detalle) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.horario = horario;
		this.fechaAlta = fechaAlta;
		this.montoTotal = montoTotal;
		this.aplicoDescuento = aplicoDescuento;
		this.estado = estado;
		this.detalle = detalle;
	}

	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
