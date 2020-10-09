package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estadofinanciamiento database table.
 * 
 */
@Entity
@NamedQuery(name="Estadofinanciamiento.findAll", query="SELECT e FROM Estadofinanciamiento e")
public class Estadofinanciamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idestadofinanciamiento;

	private byte enable;

	private String nombre;

	//bi-directional many-to-one association to Financiamiento
	@OneToMany(mappedBy="estadofinanciamiento")
	private List<Financiamiento> financiamientos;

	public Estadofinanciamiento() {
	}

	public int getIdestadofinanciamiento() {
		return this.idestadofinanciamiento;
	}

	public void setIdestadofinanciamiento(int idestadofinanciamiento) {
		this.idestadofinanciamiento = idestadofinanciamiento;
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

	public List<Financiamiento> getFinanciamientos() {
		return this.financiamientos;
	}

	public void setFinanciamientos(List<Financiamiento> financiamientos) {
		this.financiamientos = financiamientos;
	}

	public Financiamiento addFinanciamiento(Financiamiento financiamiento) {
		getFinanciamientos().add(financiamiento);
		financiamiento.setEstadofinanciamiento(this);

		return financiamiento;
	}

	public Financiamiento removeFinanciamiento(Financiamiento financiamiento) {
		getFinanciamientos().remove(financiamiento);
		financiamiento.setEstadofinanciamiento(null);

		return financiamiento;
	}

}