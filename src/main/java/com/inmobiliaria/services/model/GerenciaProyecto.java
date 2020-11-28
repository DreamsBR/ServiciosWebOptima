package com.inmobiliaria.services.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="gerencia_proyecto")
@NamedQuery(name="GerenciaProyecto.findAll", query="SELECT g FROM GerenciaProyecto g")
public class GerenciaProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_gerencia_proyecto")
	private int idGerenciaProyecto;

	private byte enable;

	@Column(name="id_gerencia")
	private int idGerencia;

	@Column(name="id_proyecto")
	private int idProyecto;

	public int getIdGerenciaProyecto() {
		return this.idGerenciaProyecto;
	}

	public void setIdGerenciaProyecto(int idGerenciaProyecto) {
		this.idGerenciaProyecto = idGerenciaProyecto;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdGerencia() {
		return this.idGerencia;
	}

	public void setIdGerencia(int idGerencia) {
		this.idGerencia = idGerencia;
	}

	public int getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}
}