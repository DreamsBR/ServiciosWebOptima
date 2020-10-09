package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the canal database table.
 * 
 */
@Entity
@NamedQuery(name="Canal.findAll", query="SELECT c FROM Canal c")
public class Canal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcanal;

	private byte enabe;

	private String nombre;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="canal")
	private List<Venta> ventas;

	public Canal() {
	}

	public int getIdcanal() {
		return this.idcanal;
	}

	public void setIdcanal(int idcanal) {
		this.idcanal = idcanal;
	}

	public byte getEnabe() {
		return this.enabe;
	}

	public void setEnabe(byte enabe) {
		this.enabe = enabe;
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
		venta.setCanal(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setCanal(null);

		return venta;
	}

}