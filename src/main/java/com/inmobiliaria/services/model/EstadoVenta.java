package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado_venta database table.
 * 
 */
@Entity
@Table(name="estado_venta")
@NamedQuery(name="EstadoVenta.findAll", query="SELECT e FROM EstadoVenta e")
public class EstadoVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_venta")
	private int idEstadoVenta;

	private boolean enable;

	private String nombre;

	public EstadoVenta() {
	}

	public int getIdEstadoVenta() {
		return this.idEstadoVenta;
	}

	public void setIdEstadoVenta(int idEstadoVenta) {
		this.idEstadoVenta = idEstadoVenta;
	}

	public boolean getEnable() {
		return this.enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}