package com.inmobiliaria.services.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="venta_files")
@NamedQuery(name="VentaFiles.findAll", query="SELECT v FROM VentaFiles v")
public class VentaFiles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_venta_files")
	private int idVentaFiles;
	
	@Column(name="id_venta")
	private int idVenta;
	
	@ManyToOne
	@JoinColumn(name="id_estado_venta")
	private EstadoVenta estadoVenta;
	
	@Column(name="file_ruta")
	private String fileRuta;

	public int getIdVentaFiles() {
		return idVentaFiles;
	}

	public void setIdVentaFiles(int idVentaFiles) {
		this.idVentaFiles = idVentaFiles;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public EstadoVenta getEstadoVenta() {
		return estadoVenta;
	}

	public void setEstadoVenta(EstadoVenta estadoVenta) {
		this.estadoVenta = estadoVenta;
	}

	public String getFileRuta() {
		return fileRuta;
	}

	public void setFileRuta(String fileRuta) {
		this.fileRuta = fileRuta;
	}
}
