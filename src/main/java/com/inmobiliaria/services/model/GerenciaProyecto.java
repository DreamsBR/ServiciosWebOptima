package com.inmobiliaria.services.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@ManyToOne
	@JoinColumn(name="id_gerencia")
	private Gerencia gerencia;

	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_asignacion")
	private Date fechaAsignacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_termino")
	private Date fechaTermino;

	
	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Date getFechaTermin() {
		return fechaTermino;
	}

	public void setFechaTermin(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

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

	public Gerencia getGerencia() {
		return gerencia;
	}

	public void setGerencia(Gerencia gerencia) {
		this.gerencia = gerencia;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
}