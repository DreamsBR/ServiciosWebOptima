package com.inmobiliaria.services.model.request;

import java.math.BigDecimal;

import javax.persistence.Column;
public class PeriodoGerenciaRequest {
	private int idPeriodoGerencia;

	private byte enable;

	@Column(name="id_gerencia")
	private int idGerencia;

	@Column(name="id_periodo")
	private int idPeriodo;

	private BigDecimal meta;

	public int getIdPeriodoGerencia() {
		return idPeriodoGerencia;
	}

	public void setIdPeriodoGerencia(int idPeriodoGerencia) {
		this.idPeriodoGerencia = idPeriodoGerencia;
	}

	public byte getEnable() {
		return enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdGerencia() {
		return idGerencia;
	}

	public void setIdGerencia(int idGerencia) {
		this.idGerencia = idGerencia;
	}

	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public BigDecimal getMeta() {
		return meta;
	}

	public void setMeta(BigDecimal meta) {
		this.meta = meta;
	}
}
