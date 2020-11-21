package com.inmobiliaria.services.model.response;

import java.math.BigDecimal;

public class VentaInmuebleProyectoDetalleResponse {
	private int idVentaInmueble;
	
	private String areaLibre;
	
	private String areaTechada;

	private String areaTotal;

	private int idInmueble;
	
	private int dormitorios;
	
	private String numero;

	private String tipo;

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

	public int getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(int idInmueble) {
		this.idInmueble = idInmueble;
	}

	public int getDormitorios() {
		return dormitorios;
	}

	public void setDormitorios(int dormitorios) {
		this.dormitorios = dormitorios;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
