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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_venta_inmueble")
	private int idVentaInmueble;

	@Column(name="area_libre")
	private String areaLibre;

	@Column(name="area_techada")
	private String areaTechada;

	@Column(name="area_total")
	private String areaTotal;

	private BigDecimal ayudainicial;

	private BigDecimal descuento;

	private int dormitorios;

	private byte enable;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//bi-directional many-to-one association to Inmueble
	@ManyToOne
	@JoinColumn(name="id_inmueble")
	private Inmueble inmueble;
	

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	@Column(name="id_venta")
	private int idVenta;

	private BigDecimal importe;

	private BigDecimal precio;

	private String vista;

	public int getIdVentaInmueble() {
		return this.idVentaInmueble;
	}

	public void setIdVentaInmueble(int idVentaInmueble) {
		this.idVentaInmueble = idVentaInmueble;
	}

	public String getAreaLibre() {
		return this.areaLibre;
	}

	public void setAreaLibre(String areaLibre) {
		this.areaLibre = areaLibre;
	}

	public String getAreaTechada() {
		return this.areaTechada;
	}

	public void setAreaTechada(String areaTechada) {
		this.areaTechada = areaTechada;
	}

	public String getAreaTotal() {
		return this.areaTotal;
	}

	public void setAreaTotal(String areaTotal) {
		this.areaTotal = areaTotal;
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

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
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

}