package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the motivo database table.
 * 
 */
@Entity
@NamedQuery(name="Motivo.findAll", query="SELECT m FROM Motivo m")
public class Motivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idmotivo;

	private byte enable;

	private String nombre;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="motivo")
	private List<Venta> ventas;

	public Motivo() {
	}

	public int getIdmotivo() {
		return this.idmotivo;
	}

	public void setIdmotivo(int idmotivo) {
		this.idmotivo = idmotivo;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setMotivo(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setMotivo(null);

		return venta;
	}

}