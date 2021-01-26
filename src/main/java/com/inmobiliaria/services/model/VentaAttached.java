package com.inmobiliaria.services.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="venta_attached")
@NamedQuery(name="VentaAttached.findAll", query="SELECT v FROM VentaAttached v")
public class VentaAttached implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_venta_attached")
	private int idVentaAttached;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Column(name="file_ruta")
	private String fileRuta;

	@Column(name="id_venta")
	private int idVenta;
	
	private String nombre;

	public VentaAttached() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdVentaAttached() {
		return this.idVentaAttached;
	}

	public void setIdVentaAttached(int idVentaAttached) {
		this.idVentaAttached = idVentaAttached;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFileRuta() {
		return this.fileRuta;
	}

	public void setFileRuta(String fileRuta) {
		this.fileRuta = fileRuta;
	}

	public int getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

}