package com.inmobiliaria.services.model.request;

import java.math.BigDecimal;

public class InmuebleRequest {
	private int idInmueble;

	private BigDecimal areaLibre;

	private BigDecimal areaTechada;

	private BigDecimal areaTotal;

	private int cantidadDormitorio;

	private byte enable;

	private int idProyecto;

	private int idTipoInmueble;

	private int idTipoInmuebleCategoria;
	
	private int idTipoVista;
	
	private String numero;

	private BigDecimal precio;

	public int getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(int idInmueble) {
		this.idInmueble = idInmueble;
	}

	public BigDecimal getAreaLibre() {
		return areaLibre;
	}

	public void setAreaLibre(BigDecimal areaLibre) {
		this.areaLibre = areaLibre;
	}

	public BigDecimal getAreaTechada() {
		return areaTechada;
	}

	public void setAreaTechada(BigDecimal areaTechada) {
		this.areaTechada = areaTechada;
	}

	public BigDecimal getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(BigDecimal areaTotal) {
		this.areaTotal = areaTotal;
	}

	public int getCantidadDormitorio() {
		return cantidadDormitorio;
	}

	public void setCantidadDormitorio(int cantidadDormitorio) {
		this.cantidadDormitorio = cantidadDormitorio;
	}

	public byte getEnable() {
		return enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public int getIdTipoInmueble() {
		return idTipoInmueble;
	}

	public void setIdTipoInmueble(int idTipoInmueble) {
		this.idTipoInmueble = idTipoInmueble;
	}

	public int getIdTipoInmuebleCategoria() {
		return idTipoInmuebleCategoria;
	}

	public void setIdTipoInmuebleCategoria(int idTipoInmuebleCategoria) {
		this.idTipoInmuebleCategoria = idTipoInmuebleCategoria;
	}

	public int getIdTipoVista() {
		return idTipoVista;
	}

	public void setIdTipoVista(int idTipoVista) {
		this.idTipoVista = idTipoVista;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
}
