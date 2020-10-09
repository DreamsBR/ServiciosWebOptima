package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the venta_inmueble database table.
 * 
 */
@Entity
@Table(name="venta_inmueble")
@NamedQuery(name="VentaInmueble.findAll", query="SELECT v FROM VentaInmueble v")
public class VentaInmueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idventainmueble;

	private String arealibre;

	private String areatechada;

	private String areatotal;

	private BigDecimal ayudainicial;

	private BigDecimal descuento;

	private int dormitorios;

	private BigDecimal importe;

	private BigDecimal precio;

	private String vista;

	//bi-directional many-to-one association to Inmueble
	@ManyToOne
	@JoinColumn(name="idinmueble")
	private Inmueble inmueble;

	//bi-directional many-to-one association to Venta
	@ManyToOne
	@JoinColumn(name="idventa")
	private Venta venta;

	public VentaInmueble() {
	}

	public int getIdventainmueble() {
		return this.idventainmueble;
	}

	public void setIdventainmueble(int idventainmueble) {
		this.idventainmueble = idventainmueble;
	}

	public String getArealibre() {
		return this.arealibre;
	}

	public void setArealibre(String arealibre) {
		this.arealibre = arealibre;
	}

	public String getAreatechada() {
		return this.areatechada;
	}

	public void setAreatechada(String areatechada) {
		this.areatechada = areatechada;
	}

	public String getAreatotal() {
		return this.areatotal;
	}

	public void setAreatotal(String areatotal) {
		this.areatotal = areatotal;
	}

	public BigDecimal getAyudainicial() {
		return this.ayudainicial;
	}

	public void setAyudainicial(BigDecimal ayudainicial) {
		this.ayudainicial = ayudainicial;
	}

	public BigDecimal getDescuento() {
		return this.descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public int getDormitorios() {
		return this.dormitorios;
	}

	public void setDormitorios(int dormitorios) {
		this.dormitorios = dormitorios;
	}

	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getVista() {
		return this.vista;
	}

	public void setVista(String vista) {
		this.vista = vista;
	}

	public Inmueble getInmueble() {
		return this.inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}