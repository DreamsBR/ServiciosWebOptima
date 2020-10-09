package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pago database table.
 * 
 */
@Entity
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idpago;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private BigDecimal monto;

	private int numerooperacion;

	private byte pagado;

	private String porcentaje;

	//bi-directional many-to-one association to Venta
	@ManyToOne
	@JoinColumn(name="idventa")
	private Venta venta;

	//bi-directional many-to-one association to Tipopago
	@ManyToOne
	@JoinColumn(name="idtipopago")
	private Tipopago tipopago;

	public Pago() {
	}

	public int getIdpago() {
		return this.idpago;
	}

	public void setIdpago(int idpago) {
		this.idpago = idpago;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public int getNumerooperacion() {
		return this.numerooperacion;
	}

	public void setNumerooperacion(int numerooperacion) {
		this.numerooperacion = numerooperacion;
	}

	public byte getPagado() {
		return this.pagado;
	}

	public void setPagado(byte pagado) {
		this.pagado = pagado;
	}

	public String getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Tipopago getTipopago() {
		return this.tipopago;
	}

	public void setTipopago(Tipopago tipopago) {
		this.tipopago = tipopago;
	}

}