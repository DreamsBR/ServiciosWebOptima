package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the inmueble database table.
 * 
 */
@Entity
@NamedQuery(name="Inmueble.findAll", query="SELECT i FROM Inmueble i")
public class Inmueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idinmueble;

	private int arealibre;

	private int areatechada;

	private int areatotal;

	private int cantidaddormitorio;

	private String numero;

	private BigDecimal precio;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="idproyecto")
	private Proyecto proyecto;

	//bi-directional many-to-one association to Tipoinmueble
	@ManyToOne
	@JoinColumn(name="idtipounidad")
	private Tipoinmueble tipoinmueble;

	//bi-directional many-to-one association to Tipovista
	@ManyToOne
	@JoinColumn(name="idtipovista")
	private Tipovista tipovista;

	//bi-directional many-to-one association to VentaInmueble
	@OneToMany(mappedBy="inmueble")
	private List<VentaInmueble> ventaInmuebles;

	public Inmueble() {
	}

	public int getIdinmueble() {
		return this.idinmueble;
	}

	public void setIdinmueble(int idinmueble) {
		this.idinmueble = idinmueble;
	}

	public int getArealibre() {
		return this.arealibre;
	}

	public void setArealibre(int arealibre) {
		this.arealibre = arealibre;
	}

	public int getAreatechada() {
		return this.areatechada;
	}

	public void setAreatechada(int areatechada) {
		this.areatechada = areatechada;
	}

	public int getAreatotal() {
		return this.areatotal;
	}

	public void setAreatotal(int areatotal) {
		this.areatotal = areatotal;
	}

	public int getCantidaddormitorio() {
		return this.cantidaddormitorio;
	}

	public void setCantidaddormitorio(int cantidaddormitorio) {
		this.cantidaddormitorio = cantidaddormitorio;
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

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Tipoinmueble getTipoinmueble() {
		return this.tipoinmueble;
	}

	public void setTipoinmueble(Tipoinmueble tipoinmueble) {
		this.tipoinmueble = tipoinmueble;
	}

	public Tipovista getTipovista() {
		return this.tipovista;
	}

	public void setTipovista(Tipovista tipovista) {
		this.tipovista = tipovista;
	}

	public List<VentaInmueble> getVentaInmuebles() {
		return this.ventaInmuebles;
	}

	public void setVentaInmuebles(List<VentaInmueble> ventaInmuebles) {
		this.ventaInmuebles = ventaInmuebles;
	}

	public VentaInmueble addVentaInmueble(VentaInmueble ventaInmueble) {
		getVentaInmuebles().add(ventaInmueble);
		ventaInmueble.setInmueble(this);

		return ventaInmueble;
	}

	public VentaInmueble removeVentaInmueble(VentaInmueble ventaInmueble) {
		getVentaInmuebles().remove(ventaInmueble);
		ventaInmueble.setInmueble(null);

		return ventaInmueble;
	}

}