package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipovista database table.
 * 
 */
@Entity
@NamedQuery(name="Tipovista.findAll", query="SELECT t FROM Tipovista t")
public class Tipovista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtipovista;

	private byte enable;

	private String nombre;

	//bi-directional many-to-one association to Inmueble
	@OneToMany(mappedBy="tipovista")
	private List<Inmueble> inmuebles;

	public Tipovista() {
	}

	public int getIdtipovista() {
		return this.idtipovista;
	}

	public void setIdtipovista(int idtipovista) {
		this.idtipovista = idtipovista;
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

	public List<Inmueble> getInmuebles() {
		return this.inmuebles;
	}

	public void setInmuebles(List<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

	public Inmueble addInmueble(Inmueble inmueble) {
		getInmuebles().add(inmueble);
		inmueble.setTipovista(this);

		return inmueble;
	}

	public Inmueble removeInmueble(Inmueble inmueble) {
		getInmuebles().remove(inmueble);
		inmueble.setTipovista(null);

		return inmueble;
	}

}