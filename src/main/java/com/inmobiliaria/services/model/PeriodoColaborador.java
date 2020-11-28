package com.inmobiliaria.services.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;


/**
 * The persistent class for the periodo_colaborador database table.
 * 
 */
@Entity
@Table(name="periodo_colaborador")
@NamedQuery(name="PeriodoColaborador.findAll", query="SELECT p FROM PeriodoColaborador p")
public class PeriodoColaborador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_periodo_colaborador")
	private int idPeriodoColaborador;

	private byte enable;

	@Column(name="id_colaborador")
	private int idColaborador;

	@ManyToOne
	@JoinColumn(name="id_periodo")
	private Periodo periodo;

	private BigDecimal meta;

	public PeriodoColaborador() {
	}

	public int getIdPeriodoColaborador() {
		return this.idPeriodoColaborador;
	}

	public void setIdPeriodoColaborador(int idPeriodoColaborador) {
		this.idPeriodoColaborador = idPeriodoColaborador;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdColaborador() {
		return this.idColaborador;
	}

	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
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

}