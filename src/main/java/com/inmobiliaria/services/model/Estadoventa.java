package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estadoventa database table.
 * 
 */
@Entity
@NamedQuery(name="Estadoventa.findAll", query="SELECT e FROM Estadoventa e")
public class Estadoventa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idestadoventa;

	private byte enable;

	private String nombre;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="estadoventa")
	private List<Venta> ventas;

	public Estadoventa() {
	}

	public int getIdestadoventa() {
		return this.idestadoventa;
	}

	public void setIdestadoventa(int idestadoventa) {
		this.idestadoventa = idestadoventa;
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
		venta.setEstadoventa(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setEstadoventa(null);

		return venta;
	}

}