package com.inmobiliaria.services.model;

import java.io.Serializable;
import java.math.BigDecimal;

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

	@ManyToOne
	@JoinColumn(name="id_periodo")
	private Periodo periodo;
	
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	private BigDecimal meta;

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

	public BigDecimal getMeta() {
		return this.meta;
	}

	public void setMeta(BigDecimal meta) {
		this.meta = meta;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

}