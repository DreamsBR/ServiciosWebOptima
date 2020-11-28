package com.inmobiliaria.services.model.request;

import java.math.BigDecimal;

public class PeriodoColaboradorRequest {
	private int idPeriodoColaborador;

	private byte enable;

	private int idColaborador;

	private int idPeriodo;

	private BigDecimal meta;

	public int getIdPeriodoColaborador() {
		return idPeriodoColaborador;
	}

	public void setIdPeriodoColaborador(int idPeriodoColaborador) {
		this.idPeriodoColaborador = idPeriodoColaborador;
	}

	public byte getEnable() {
		return enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
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
