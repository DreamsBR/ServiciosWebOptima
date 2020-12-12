package com.inmobiliaria.services.model.request;

import java.math.BigDecimal;
import java.util.Date;

public class FinanciamientoRequest {
	private int idFinanciamiento;

	private BigDecimal afp;

	private BigDecimal ahorro;

	private String asesor;

	private BigDecimal bono;

	private byte enable;

	private Date fechaFinAhorro;

	private Date fechaInicioAhorro;

	private int idBanco;

	private int idEstadoFinanciamiento;

	private int idTipoCredito;
	
	private BigDecimal montoCuotaInicial;

	private BigDecimal montoFinanciado;
	
	private String porcCuotaInicial;

	public int getIdFinanciamiento() {
		return idFinanciamiento;
	}

	public void setIdFinanciamiento(int idFinanciamiento) {
		this.idFinanciamiento = idFinanciamiento;
	}

	public BigDecimal getAfp() {
		return afp;
	}

	public void setAfp(BigDecimal afp) {
		this.afp = afp;
	}

	public BigDecimal getAhorro() {
		return ahorro;
	}

	public void setAhorro(BigDecimal ahorro) {
		this.ahorro = ahorro;
	}

	public String getAsesor() {
		return asesor;
	}

	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	public BigDecimal getBono() {
		return bono;
	}

	public void setBono(BigDecimal bono) {
		this.bono = bono;
	}

	public byte getEnable() {
		return enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public Date getFechaFinAhorro() {
		return fechaFinAhorro;
	}

	public void setFechaFinAhorro(Date fechaFinAhorro) {
		this.fechaFinAhorro = fechaFinAhorro;
	}

	public Date getFechaInicioAhorro() {
		return fechaInicioAhorro;
	}

	public void setFechaInicioAhorro(Date fechaInicioAhorro) {
		this.fechaInicioAhorro = fechaInicioAhorro;
	}

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	public int getIdEstadoFinanciamiento() {
		return idEstadoFinanciamiento;
	}

	public void setIdEstadoFinanciamiento(int idEstadoFinanciamiento) {
		this.idEstadoFinanciamiento = idEstadoFinanciamiento;
	}

	public int getIdTipoCredito() {
		return idTipoCredito;
	}

	public void setIdTipoCredito(int idTipoCredito) {
		this.idTipoCredito = idTipoCredito;
	}

	public BigDecimal getMontoCuotaInicial() {
		return montoCuotaInicial;
	}

	public void setMontoCuotaInicial(BigDecimal montoCuotaInicial) {
		this.montoCuotaInicial = montoCuotaInicial;
	}

	public BigDecimal getMontoFinanciado() {
		return montoFinanciado;
	}

	public void setMontoFinanciado(BigDecimal montoFinanciado) {
		this.montoFinanciado = montoFinanciado;
	}

	public String getPorcCuotaInicial() {
		return porcCuotaInicial;
	}

	public void setPorcCuotaInicial(String porcCuotaInicial) {
		this.porcCuotaInicial = porcCuotaInicial;
	}
}
