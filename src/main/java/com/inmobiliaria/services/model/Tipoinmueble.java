package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoinmueble database table.
 * 
 */
@Entity
@NamedQuery(name="Tipoinmueble.findAll", query="SELECT t FROM Tipoinmueble t")
public class Tipoinmueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtipoinmueble;

	private byte enable;

	private String nombre;

	//bi-directional many-to-one association to Inmueble
	@OneToMany(mappedBy="tipoinmueble")
	private List<Inmueble> inmuebles;

	public Tipoinmueble() {
	}

	public int getIdtipoinmueble() {
		return this.idtipoinmueble;
	}

	public void setIdtipoinmueble(int idtipoinmueble) {
		this.idtipoinmueble = idtipoinmueble;
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
		inmueble.setTipoinmueble(this);

		return inmueble;
	}

	public Inmueble removeInmueble(Inmueble inmueble) {
		getInmuebles().remove(inmueble);
		inmueble.setTipoinmueble(null);

		return inmueble;
	}

}