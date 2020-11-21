package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the jefatura database table.
 * 
 */
@Entity
@NamedQuery(name="Jefatura.findAll", query="SELECT j FROM Jefatura j")
public class Jefatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_jefatura")
	private int idJefatura;

	private byte enable;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	@Column(name="id_gerencia")
	private int idGerencia;

	@Column(name="id_jefe_venta")
	private int idJefeVenta;

	private String nombre;

	public Jefatura() {
	}

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

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getIdGerencia() {
		return this.idGerencia;
	}

	public void setIdGerencia(int idGerencia) {
		this.idGerencia = idGerencia;
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