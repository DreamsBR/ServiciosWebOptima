package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gerencia_proyecto database table.
 * 
 */
@Entity
@Table(name="gerencia_proyecto")
@NamedQuery(name="GerenciaProyecto.findAll", query="SELECT g FROM GerenciaProyecto g")
public class GerenciaProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_gerencia_proyecto")
	private int idGerenciaProyecto;

	private boolean enable;

	@Column(name="id_gerencia")
	private int idGerencia;

	@Column(name="id_proyecto")
	private int idProyecto;

	public GerenciaProyecto() {
	}

	public int getIdGerenciaProyecto() {
		return this.idGerenciaProyecto;
	}

	public void setIdGerenciaProyecto(int idGerenciaProyecto) {
		this.idGerenciaProyecto = idGerenciaProyecto;
	}

	public boolean getEnable() {
		return this.enable;
	}

	public void setEnable(boolean enable) {
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