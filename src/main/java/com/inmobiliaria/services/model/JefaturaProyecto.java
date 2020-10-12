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
	@Column(name="id_jefatura_proyecto")
	private int idJefaturaProyecto;

	private byte enable;

	@Column(name="id_jefatura")
	private int idJefatura;

	@Column(name="id_proyecto")
	private int idProyecto;

	public JefaturaProyecto() {
	}

	public int getIdJefaturaProyecto() {
		return this.idJefaturaProyecto;
	}

	public void setIdJefaturaProyecto(int idJefaturaProyecto) {
		this.idJefaturaProyecto = idJefaturaProyecto;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdJefatura() {
		return this.idJefatura;
	}

	public void setIdJefatura(int idJefatura) {
		this.idJefatura = idJefatura;
	}

	public int getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

}