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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_financiamiento")
	private int idFinanciamiento;

	private BigDecimal afp;

	private BigDecimal ahorro;

	private String asesor;

	private BigDecimal bono;

	private byte enable;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_fin_ahorro")
	private Date fechaFinAhorro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_inicio_ahorro")
	private Date fechaInicioAhorro;

	@ManyToOne
	@JoinColumn(name="id_banco")
	private Banco banco;

	@ManyToOne
	@JoinColumn(name="id_estado_financiamiento")
	private EstadoFinanciamiento estadoFinanciamiento;

	@ManyToOne
	@JoinColumn(name="id_tipo_credito")
	private TipoCredito tipoCredito;

	@Column(name="monto_cuota_inicial")
	private BigDecimal montoCuotaInicial;

	@Column(name="monto_financiado")
	private BigDecimal montoFinanciado;
	
	@Column(name="porc_cuota_inicial")
	private String porcCuotaInicial;
	
	public BigDecimal getMontoCuotaInicial() {
		return montoCuotaInicial;
	}

	public void setMontoCuotaInicial(BigDecimal montoCuotaInicial) {
		this.montoCuotaInicial = montoCuotaInicial;
	}

	public String getPorcCuotaInicial() {
		return porcCuotaInicial;
	}

	public void setPorcCuotaInicial(String porcCuotaInicial) {
		this.porcCuotaInicial = porcCuotaInicial;
	}

	public int getIdFinanciamiento() {
		return this.idFinanciamiento;
	}

	public void setIdFinanciamiento(int idFinanciamiento) {
		this.idFinanciamiento = idFinanciamiento;
	}

	public BigDecimal getAfp() {
		return this.afp;
	}

	public void setAfp(BigDecimal afp) {
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

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
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

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public EstadoFinanciamiento getEstadoFinanciamiento() {
		return estadoFinanciamiento;
	}

	public void setEstadoFinanciamiento(EstadoFinanciamiento estadoFinanciamiento) {
		this.estadoFinanciamiento = estadoFinanciamiento;
	}

	public TipoCredito getTipoCredito() {
		return tipoCredito;
	}

	public void setTipoCredito(TipoCredito tipoCredito) {
		this.tipoCredito = tipoCredito;
	}

	public BigDecimal getMontoFinanciado() {
		return montoFinanciado;
	}

	public void setMontoFinanciado(BigDecimal montoFinanciado) {
		this.montoFinanciado = montoFinanciado;
	}



}