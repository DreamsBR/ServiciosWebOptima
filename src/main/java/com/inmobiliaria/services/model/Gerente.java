package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gerente database table.
 * 
 */
@Entity
@NamedQuery(name="Gerente.findAll", query="SELECT g FROM Gerente g")
public class Gerente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idgerente;

	private byte enable;

	private int idpersona;

	//bi-directional many-to-one association to Gerencia
	@OneToMany(mappedBy="gerente")
	private List<Gerencia> gerencias;

	public Gerente() {
	}

	public int getIdgerente() {
		return this.idgerente;
	}

	public void setIdgerente(int idgerente) {
		this.idgerente = idgerente;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public List<Gerencia> getGerencias() {
		return this.gerencias;
	}

	public void setGerencias(List<Gerencia> gerencias) {
		this.gerencias = gerencias;
	}

	public Gerencia addGerencia(Gerencia gerencia) {
		getGerencias().add(gerencia);
		gerencia.setGerente(this);

		return gerencia;
	}

	public Gerencia removeGerencia(Gerencia gerencia) {
		getGerencias().remove(gerencia);
		gerencia.setGerente(null);

		return gerencia;
	}

}