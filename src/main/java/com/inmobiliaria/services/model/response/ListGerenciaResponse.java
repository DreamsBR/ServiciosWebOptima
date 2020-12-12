package com.inmobiliaria.services.model.response;

import java.util.Date;

public class ListGerenciaResponse {
	private int idGerencia;
	private String nombre;
	private int idGerente;
	private String nombreGerente;
	private String apellidosGerente;
	private Date fechaIngreso;
	private byte enable;
	public int getIdGerencia() {
		return idGerencia;
	}
	public void setIdGerencia(int idGerencia) {
		this.idGerencia = idGerencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdGerente() {
		return idGerente;
	}
	public void setIdGerente(int idGerente) {
		this.idGerente = idGerente;
	}
	public String getNombreGerente() {
		return nombreGerente;
	}
	public void setNombreGerente(String nombreGerente) {
		this.nombreGerente = nombreGerente;
	}
	public String getApellidosGerente() {
		return apellidosGerente;
	}
	public void setApellidosGerente(String apellidosGerente) {
		this.apellidosGerente = apellidosGerente;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public byte getEnable() {
		return enable;
	}
	public void setEnable(byte enable) {
		this.enable = enable;
	}
}
