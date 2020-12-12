package com.inmobiliaria.services.model.request;

import java.util.Date;


public class JefaturaRequest {
	private int idJefatura;

	private byte enable;

	private Date fechaIngreso;

	private Date fechaTermino;
	
	private int idGerencia;

	private int idJefeVenta;

	private String nombre;

	public int getIdJefatura() {
		return idJefatura;
	}

	public void setIdJefatura(int idJefatura) {
		this.idJefatura = idJefatura;
	}

	public byte getEnable() {
		return enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public int getIdGerencia() {
		return idGerencia;
	}

	public void setIdGerencia(int idGerencia) {
		this.idGerencia = idGerencia;
	}

	public int getIdJefeVenta() {
		return idJefeVenta;
	}

	public void setIdJefeVenta(int idJefeVenta) {
		this.idJefeVenta = idJefeVenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
