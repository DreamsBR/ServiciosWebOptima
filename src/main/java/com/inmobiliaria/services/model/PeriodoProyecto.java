package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the periodo_proyecto database table.
 * 
 */
@Entity
@Table(name="periodo_proyecto")
@NamedQuery(name="PeriodoProyecto.findAll", query="SELECT p FROM PeriodoProyecto p")
public class PeriodoProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_periodo_proyecto")
	private int idPeriodoProyecto;

	private byte enable;

	@Column(name="id_periodo")
	private int idPeriodo;

	@Column(name="id_proyecto")
	private int idProyecto;

	private double meta;

	public PeriodoProyecto() {
	}

	public int getIdPeriodoProyecto() {
		return this.idPeriodoProyecto;
	}

	public void setIdPeriodoProyecto(int idPeriodoProyecto) {
		this.idPeriodoProyecto = idPeriodoProyecto;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdPeriodo() {
		return this.idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public int getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public double getMeta() {
		return this.meta;
	}

	public void setMeta(double meta) {
		this.meta = meta;
	}

}