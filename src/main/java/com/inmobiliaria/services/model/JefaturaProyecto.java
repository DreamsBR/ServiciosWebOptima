package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jefatura_proyecto database table.
 * 
 */
@Entity
@Table(name="jefatura_proyecto")
@NamedQuery(name="JefaturaProyecto.findAll", query="SELECT j FROM JefaturaProyecto j")
public class JefaturaProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idjefatura_proyecto")
	private int idjefaturaProyecto;

	private byte enable;

	//bi-directional many-to-one association to Jefatura
	@ManyToOne
	@JoinColumn(name="idjefatura")
	private Jefatura jefatura;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="idproyecto")
	private Proyecto proyecto;

	public JefaturaProyecto() {
	}

	public int getIdjefaturaProyecto() {
		return this.idjefaturaProyecto;
	}

	public void setIdjefaturaProyecto(int idjefaturaProyecto) {
		this.idjefaturaProyecto = idjefaturaProyecto;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public Jefatura getJefatura() {
		return this.jefatura;
	}

	public void setJefatura(Jefatura jefatura) {
		this.jefatura = jefatura;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}