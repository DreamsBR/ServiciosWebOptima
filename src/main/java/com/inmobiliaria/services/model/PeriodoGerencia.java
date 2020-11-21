package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the periodo_gerencia database table.
 * 
 */
@Entity
@Table(name="periodo_gerencia")
@NamedQuery(name="PeriodoGerencia.findAll", query="SELECT p FROM PeriodoGerencia p")
public class PeriodoGerencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_periodo_gerencia")
	private int idPeriodoGerencia;

	private byte enable;

	@Column(name="id_gerencia")
	private int idGerencia;

	@Column(name="id_periodo")
	private int idPeriodo;

	private double meta;

	public PeriodoGerencia() {
	}

	public int getIdPeriodoGerencia() {
		return this.idPeriodoGerencia;
	}

	public void setIdPeriodoGerencia(int idPeriodoGerencia) {
		this.idPeriodoGerencia = idPeriodoGerencia;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdGerencia() {
		return this.idGerencia;
	}

	public void setIdGerencia(int idGerencia) {
		this.idGerencia = idGerencia;
	}

	public int getIdPeriodo() {
		return this.idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public double getMeta() {
		return this.meta;
	}

	public void setMeta(double meta) {
		this.meta = meta;
	}

}