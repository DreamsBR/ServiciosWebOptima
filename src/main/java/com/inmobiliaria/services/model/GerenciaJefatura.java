package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gerencia_jefatura database table.
 * 
 */
@Entity
@Table(name="gerencia_jefatura")
@NamedQuery(name="GerenciaJefatura.findAll", query="SELECT g FROM GerenciaJefatura g")
public class GerenciaJefatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_gerencia_jefatura")
	private int idGerenciaJefatura;

	private boolean enable;

	@Column(name="id_gerencia")
	private int idGerencia;

	@Column(name="id_jefatura")
	private int idJefatura;

	public GerenciaJefatura() {
	}

	public int getIdGerenciaJefatura() {
		return this.idGerenciaJefatura;
	}

	public void setIdGerenciaJefatura(int idGerenciaJefatura) {
		this.idGerenciaJefatura = idGerenciaJefatura;
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

	public int getIdJefatura() {
		return this.idJefatura;
	}

	public void setIdJefatura(int idJefatura) {
		this.idJefatura = idJefatura;
	}

}