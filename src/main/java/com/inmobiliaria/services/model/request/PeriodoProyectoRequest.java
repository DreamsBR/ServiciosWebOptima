package com.inmobiliaria.services.model.request;

import java.math.BigDecimal;

public class PeriodoProyectoRequest {
	private int idPeriodoProyecto;

	private byte enable;

	private int idPeriodo;
	
	private int idProyecto;

	private BigDecimal meta;

	public int getIdPeriodoProyecto() {
		return idPeriodoProyecto;
	}

	public void setIdPeriodoProyecto(int idPeriodoProyecto) {
		this.idPeriodoProyecto = idPeriodoProyecto;
	}

	public byte getEnable() {
		return enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public BigDecimal getMeta() {
		return meta;
	}

	public void setMeta(BigDecimal meta) {
		this.meta = meta;
	}
}
