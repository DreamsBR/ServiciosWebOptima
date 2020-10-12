package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the financiamiento database table.
 * 
 */
@Entity
@NamedQuery(name="Financiamiento.findAll", query="SELECT f FROM Financiamiento f")
public class Financiamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_financiamiento")
	private int idFinanciamiento;

	private byte afp;

	private BigDecimal ahorro;

	private String asesor;

	private BigDecimal bono;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_fin_ahorro")
	private Date fechaFinAhorro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_inicio_ahorro")
	private Date fechaInicioAhorro;

	@Column(name="id_banco")
	private int idBanco;

	@Column(name="id_estado_financiamiento")
	private int idEstadoFinanciamiento;

	@Column(name="id_tipo_credito")
	private int idTipoCredito;

	public Financiamiento() {
	}

	public int getIdFinanciamiento() {
		return this.idFinanciamiento;
	}

	public void setIdFinanciamiento(int idFinanciamiento) {
		this.idFinanciamiento = idFinanciamiento;
	}

	public byte getAfp() {
		return this.afp;
	}

	public void setAfp(byte afp) {
		this.afp = afp;
	}

	public BigDecimal getAhorro() {
		return this.ahorro;
	}

	public void setAhorro(BigDecimal ahorro) {
		this.ahorro = ahorro;
	}

	public String getAsesor() {
		return this.asesor;
	}

	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	public BigDecimal getBono() {
		return this.bono;
	}

	public void setBono(BigDecimal bono) {
		this.bono = bono;
	}

	public Date getFechaFinAhorro() {
		return this.fechaFinAhorro;
	}

	public void setFechaFinAhorro(Date fechaFinAhorro) {
		this.fechaFinAhorro = fechaFinAhorro;
	}

	public Date getFechaInicioAhorro() {
		return this.fechaInicioAhorro;
	}

	public void setFechaInicioAhorro(Date fechaInicioAhorro) {
		this.fechaInicioAhorro = fechaInicioAhorro;
	}

	public int getIdBanco() {
		return this.idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	public int getIdEstadoFinanciamiento() {
		return this.idEstadoFinanciamiento;
	}

	public void setIdEstadoFinanciamiento(int idEstadoFinanciamiento) {
		this.idEstadoFinanciamiento = idEstadoFinanciamiento;
	}

	public int getIdTipoCredito() {
		return this.idTipoCredito;
	}

	public void setIdTipoCredito(int idTipoCredito) {
		this.idTipoCredito = idTipoCredito;
	}

}