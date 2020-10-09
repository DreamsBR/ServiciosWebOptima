package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipocredito database table.
 * 
 */
@Entity
@NamedQuery(name="Tipocredito.findAll", query="SELECT t FROM Tipocredito t")
public class Tipocredito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtipocredito;

	private byte enable;

	private String nombre;

	//bi-directional many-to-one association to Financiamiento
	@OneToMany(mappedBy="tipocredito")
	private List<Financiamiento> financiamientos;

	public Tipocredito() {
	}

	public int getIdtipocredito() {
		return this.idtipocredito;
	}

	public void setIdtipocredito(int idtipocredito) {
		this.idtipocredito = idtipocredito;
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
		financiamiento.setTipocredito(this);

		return financiamiento;
	}

	public Financiamiento removeFinanciamiento(Financiamiento financiamiento) {
		getFinanciamientos().remove(financiamiento);
		financiamiento.setTipocredito(null);

		return financiamiento;
	}

}