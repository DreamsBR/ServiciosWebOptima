package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gerente database table.
 * 
 */
@Entity
@NamedQuery(name="Gerente.findAll", query="SELECT g FROM Gerente g")
public class Gerente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_gerente")
	private int idGerente;

	private byte enable;

	@Column(name="id_persona")
	private int idPersona;

	public Gerente() {
	}

	public int getIdGerente() {
		return this.idGerente;
	}

	public void setIdGerente(int idGerente) {
		this.idGerente = idGerente;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

}