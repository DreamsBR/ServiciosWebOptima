package com.inmobiliaria.services.model.request;

import java.util.Date;

public class GerenciaProyectoRequest {
	private int idGerenciaProyecto;

	private byte enable;
	
	private int iGerencia;

	private int idProyecto;

	private Date fechaAsignacion;

	private Date fechaTermin;

	public int getIdGerenciaProyecto() {
		return idGerenciaProyecto;
	}

	public void setIdGerenciaProyecto(int idGerenciaProyecto) {
		this.idGerenciaProyecto = idGerenciaProyecto;
	}

	public byte getEnable() {
		return enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getiGerencia() {
		return iGerencia;
	}

	public void setiGerencia(int iGerencia) {
		this.iGerencia = iGerencia;
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Date getFechaTermin() {
		return fechaTermin;
	}

	public void setFechaTermin(Date fechaTermin) {
		this.fechaTermin = fechaTermin;
	}
	
}
