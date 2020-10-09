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
	@Column(name="idgerencia_jefatura")
	private int idgerenciaJefatura;

	private byte enable;

	//bi-directional many-to-one association to Gerencia
	@ManyToOne
	@JoinColumn(name="idgerencia")
	private Gerencia gerencia;

	//bi-directional many-to-one association to Jefatura
	@ManyToOne
	@JoinColumn(name="idjefatura")
	private Jefatura jefatura;

	public GerenciaJefatura() {
	}

	public int getIdgerenciaJefatura() {
		return this.idgerenciaJefatura;
	}

	public void setIdgerenciaJefatura(int idgerenciaJefatura) {
		this.idgerenciaJefatura = idgerenciaJefatura;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public Gerencia getGerencia() {
		return this.gerencia;
	}

	public void setGerencia(Gerencia gerencia) {
		this.gerencia = gerencia;
	}

	public Jefatura getJefatura() {
		return this.jefatura;
	}

	public void setJefatura(Jefatura jefatura) {
		this.jefatura = jefatura;
	}

}