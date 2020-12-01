package com.inmobiliaria.services.model.request;


public class JefaturaProyectoRequest {
	private int idJefaturaProyecto;

	private byte enable;

	private int idProyecto;

	private int idJefatura;

	public int getIdJefaturaProyecto() {
		return idJefaturaProyecto;
	}

	public void setIdJefaturaProyecto(int idJefaturaProyecto) {
		this.idJefaturaProyecto = idJefaturaProyecto;
	}

	public byte getEnable() {
		return enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public int getIdJefatura() {
		return idJefatura;
	}

	public void setIdJefatura(int idJefatura) {
		this.idJefatura = idJefatura;
	}
}
