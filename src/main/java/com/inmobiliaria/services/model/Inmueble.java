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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_inmueble")
	private int idInmueble;

	@Column(name="area_libre")
	private BigDecimal areaLibre;

	@Column(name="area_techada")
	private BigDecimal areaTechada;

	@Column(name="area_total")
	private BigDecimal areaTotal;

	@Column(name="cantidad_dormitorio")
	private int cantidadDormitorio;

	private byte enable;

	@Column(name="id_proyecto")
	private int idProyecto;

	//bi-directional many-to-one association to TipoInmueble
	@ManyToOne
	@JoinColumn(name="id_tipo_inmueble")
	private TipoInmueble tipoInmueble;

	//bi-directional many-to-one association to TipoInmuebleCategoria
	@ManyToOne
	@JoinColumn(name="id_tipo_inmueble_categoria")
	private TipoInmuebleCategoria tipoInmuebleCategoria;
	

	//bi-directional many-to-one association to TipoInmueble
	@ManyToOne
	@JoinColumn(name="id_tipo_vista")
	private TipoVista tipoVista;
	
	private String moneda;

	@Column(name="tipo_cambio")
	private BigDecimal tipoCambio;
	
	private String numero;

	private BigDecimal precio;

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(BigDecimal tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public int getIdInmueble() {
		return this.idInmueble;
	}

	public void setIdInmueble(int idInmueble) {
		this.idInmueble = idInmueble;
	}

	public BigDecimal getAreaLibre() {
		return this.areaLibre;
	}

	public void setAreaLibre(BigDecimal areaLibre) {
		this.areaLibre = areaLibre;
	}

	public BigDecimal getAreaTechada() {
		return this.areaTechada;
	}

	public void setAreaTechada(BigDecimal areaTechada) {
		this.areaTechada = areaTechada;
	}

	public BigDecimal getAreaTotal() {
		return this.areaTotal;
	}

	public void setAreaTotal(BigDecimal areaTotal) {
		this.areaTotal = areaTotal;
	}

	public int getCantidadDormitorio() {
		return this.cantidadDormitorio;
	}

	public void setCantidadDormitorio(int cantidadDormitorio) {
		this.cantidadDormitorio = cantidadDormitorio;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
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

	public TipoInmueble getTipoInmueble() {
		return tipoInmueble;
	}

	public void setTipoInmueble(TipoInmueble tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}

	public TipoInmuebleCategoria getTipoInmuebleCategoria() {
		return tipoInmuebleCategoria;
	}

	public void setTipoInmuebleCategoria(TipoInmuebleCategoria tipoInmuebleCategoria) {
		this.tipoInmuebleCategoria = tipoInmuebleCategoria;
	}

	public TipoVista getTipoVista() {
		return tipoVista;
	}

	public void setTipoVista(TipoVista tipoVista) {
		this.tipoVista = tipoVista;
	}

}