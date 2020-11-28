package com.inmobiliaria.services.model.request;

import java.math.BigDecimal;

public class VentaInmuebleRequest {
	private int idVentaInmueble;

	private String areaLibre;

	private String areaTechada;

	private String areaTotal;

	private BigDecimal ayudainicial;

	private BigDecimal descuento;

	private int dormitorios;

	private byte enable;

	private int idInmueble;
	
	private int idVenta;

	private BigDecimal importe;

	private BigDecimal precio;

	private String vista;

	public int getIdVentaInmueble() {
		return idVentaInmueble;
	}

	public void setIdVentaInmueble(int idVentaInmueble) {
		this.idVentaInmueble = idVentaInmueble;
	}

	public String getAreaLibre() {
		return areaLibre;
	}

	public void setAreaLibre(String areaLibre) {
		this.areaLibre = areaLibre;
	}

	public String getAreaTechada() {
		return areaTechada;
	}

	public void setAreaTechada(String areaTechada) {
		this.areaTechada = areaTechada;
	}

	public String getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(String areaTotal) {
		this.areaTotal = areaTotal;
	}

	public BigDecimal getAyudainicial() {
		return ayudainicial;
	}

	public void setAyudainicial(BigDecimal ayudainicial) {
		this.ayudainicial = ayudainicial;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public int getDormitorios() {
		return dormitorios;
	}

	public void setDormitorios(int dormitorios) {
		this.dormitorios = dormitorios;
	}

	public byte getEnable() {
		return enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(int idInmueble) {
		this.idInmueble = idInmueble;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getVista() {
		return vista;
	}

	public void setVista(String vista) {
		this.vista = vista;
	}
}
