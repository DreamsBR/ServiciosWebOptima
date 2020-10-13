package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the inmueble database table.
 * 
 */
@Entity
@NamedQuery(name="Inmueble.findAll", query="SELECT i FROM Inmueble i")
public class Inmueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_inmueble")
	private int idInmueble;

	@Column(name="area_libre")
	private int areaLibre;

	@Column(name="area_techada")
	private int areaTechada;

	@Column(name="area_total")
	private int areaTotal;

	@Column(name="cantidad_dormitorio")
	private int cantidadDormitorio;

	@Column(name="id_proyecto")
	private int idProyecto;

	@Column(name="id_tipo_inmueble")
	private int idTipoInmueble;

	@Column(name="id_tipo_vista")
	private int idTipoVista;

	private String numero;

	private BigDecimal precio;

	public int getIdInmueble() {
		return this.idInmueble;
	}

	public void setIdInmueble(int idInmueble) {
		this.idInmueble = idInmueble;
	}

	public int getAreaLibre() {
		return this.areaLibre;
	}

	public void setAreaLibre(int areaLibre) {
		this.areaLibre = areaLibre;
	}

	public int getAreaTechada() {
		return this.areaTechada;
	}

	public void setAreaTechada(int areaTechada) {
		this.areaTechada = areaTechada;
	}

	public int getAreaTotal() {
		return this.areaTotal;
	}

	public void setAreaTotal(int areaTotal) {
		this.areaTotal = areaTotal;
	}

	public int getCantidadDormitorio() {
		return this.cantidadDormitorio;
	}

	public void setCantidadDormitorio(int cantidadDormitorio) {
		this.cantidadDormitorio = cantidadDormitorio;
	}

	public int getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public int getIdTipoInmueble() {
		return this.idTipoInmueble;
	}

	public void setIdTipoInmueble(int idTipoInmueble) {
		this.idTipoInmueble = idTipoInmueble;
	}

	public int getIdTipoVista() {
		return this.idTipoVista;
	}

	public void setIdTipoVista(int idTipoVista) {
		this.idTipoVista = idTipoVista;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}