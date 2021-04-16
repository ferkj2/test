package com.ma.pedidos.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@JsonIgnoreProperties(ignoreUnknown = true) 
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8248558605995398707L;

	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="id", unique=true, nullable=false)
	private String id;
	
	private String nombre;
	
	private String descripcionCorta;
	
	private String descripcionLarga;
		
	private double precioUnitario;
	
	@OneToMany(mappedBy = "producto")
	private Set<PedidoDetalle> productos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getDescripcionLarga() {
		return descripcionLarga;
	}

	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	@OneToMany(mappedBy = "producto")
    Set<PedidoDetalle> pedidosDetalles;

	
	public Producto(String id) {
		this.id = id;
	}

	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
