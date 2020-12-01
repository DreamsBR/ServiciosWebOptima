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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_jefatura_proyecto")
	private int idJefaturaProyecto;

	private byte enable;

	@ManyToOne
	@JoinColumn(name="id_jefatura")
	private Jefatura jefatura;

	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

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

	public Jefatura getJefatura() {
		return jefatura;
	}

	public void setJefatura(Jefatura jefatura) {
		this.jefatura = jefatura;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}



}