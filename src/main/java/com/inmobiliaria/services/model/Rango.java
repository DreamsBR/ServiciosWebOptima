package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rango database table.
 * 
 */
@Entity
@Table(name="rango")
@NamedQuery(name="Rango.findAll", query="SELECT r FROM Rango r")
public class Rango implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rango")
	private int idRango;

	private int anio;

	private byte enable;

	private String nombre;

	//bi-directional many-to-one association to TipoPeriodo
	@ManyToOne
	@JoinColumn(name="id_tipo_periodo")
	private TipoPeriodo tipoPeriodo;

	public Rango() {
	}

	public int getIdRango() {
		return this.idRango;
	}

	public void setIdRango(int idRango) {
		this.idRango = idRango;
	}

	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoPeriodo getTipoPeriodo() {
		return this.tipoPeriodo;
	}

	public void setTipoPeriodo(TipoPeriodo tipoPeriodo) {
		this.tipoPeriodo = tipoPeriodo;
	}


}