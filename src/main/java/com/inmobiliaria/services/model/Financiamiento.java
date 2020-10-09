package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the financiamiento database table.
 * 
 */
@Entity
@NamedQuery(name="Financiamiento.findAll", query="SELECT f FROM Financiamiento f")
public class Financiamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idfinanciamiento;

	private byte afp;

	private BigDecimal ahorro;

	private String asesor;

	private BigDecimal bono;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechafinahorro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechainicioahorro;

	//bi-directional many-to-one association to Banco
	@ManyToOne
	@JoinColumn(name="idbanco")
	private Banco banco;

	//bi-directional many-to-one association to Estadofinanciamiento
	@ManyToOne
	@JoinColumn(name="idestadofinanciamiento")
	private Estadofinanciamiento estadofinanciamiento;

	//bi-directional many-to-one association to Tipocredito
	@ManyToOne
	@JoinColumn(name="idtipocredito")
	private Tipocredito tipocredito;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="financiamiento")
	private List<Venta> ventas;

	public Financiamiento() {
	}

	public int getIdfinanciamiento() {
		return this.idfinanciamiento;
	}

	public void setIdfinanciamiento(int idfinanciamiento) {
		this.idfinanciamiento = idfinanciamiento;
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

	public Date getFechafinahorro() {
		return this.fechafinahorro;
	}

	public void setFechafinahorro(Date fechafinahorro) {
		this.fechafinahorro = fechafinahorro;
	}

	public Date getFechainicioahorro() {
		return this.fechainicioahorro;
	}

	public void setFechainicioahorro(Date fechainicioahorro) {
		this.fechainicioahorro = fechainicioahorro;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Estadofinanciamiento getEstadofinanciamiento() {
		return this.estadofinanciamiento;
	}

	public void setEstadofinanciamiento(Estadofinanciamiento estadofinanciamiento) {
		this.estadofinanciamiento = estadofinanciamiento;
	}

	public Tipocredito getTipocredito() {
		return this.tipocredito;
	}

	public void setTipocredito(Tipocredito tipocredito) {
		this.tipocredito = tipocredito;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setFinanciamiento(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setFinanciamiento(null);

		return venta;
	}

}