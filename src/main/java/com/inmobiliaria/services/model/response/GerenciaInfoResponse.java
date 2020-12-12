package com.inmobiliaria.services.model.response;

import java.util.Date;

import com.inmobiliaria.services.model.Colaborador;

public class GerenciaInfoResponse {
	private int idGerencia;

	private Date fechaIngreso;

	private Colaborador gerente;
	
	private String nombre;

	public int getIdGerencia() {
		return idGerencia;
	}

	public void setIdGerencia(int idGerencia) {
		this.idGerencia = idGerencia;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Colaborador getGerente() {
		return gerente;
	}

	public void setGerente(Colaborador gerente) {
		this.gerente = gerente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
