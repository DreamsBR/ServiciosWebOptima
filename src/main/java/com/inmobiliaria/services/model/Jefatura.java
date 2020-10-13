package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jefatura database table.
 * 
 */
@Entity
@NamedQuery(name="Jefatura.findAll", query="SELECT j FROM Jefatura j")
public class Jefatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_jefatura")
	private int idJefatura;

	private byte enable;

	@Column(name="id_jefe_venta")
	private int idJefeVenta;

	private String nombre;

	public int getIdJefatura() {
		return this.idJefatura;
	}

	public void setIdJefatura(int idJefatura) {
		this.idJefatura = idJefatura;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdJefeVenta() {
		return this.idJefeVenta;
	}

	public void setIdJefeVenta(int idJefeVenta) {
		this.idJefeVenta = idJefeVenta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}