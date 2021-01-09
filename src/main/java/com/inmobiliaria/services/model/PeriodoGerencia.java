package com.inmobiliaria.services.model;

import java.io.Serializable;
import java.math.BigDecimal;

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

	@ManyToOne
	@JoinColumn(name="id_periodo")
	private Periodo periodo;

	private BigDecimal meta;

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

	public BigDecimal getMeta() {
		return this.meta;
	}

	public void setMeta(BigDecimal meta) {
		this.meta = meta;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public int getIdGerencia() {
		return idGerencia;
	}

	public void setIdGerencia(int idGerencia) {
		this.idGerencia = idGerencia;
	}


}