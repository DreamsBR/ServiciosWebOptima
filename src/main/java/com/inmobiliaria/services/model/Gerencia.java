package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gerencia database table.
 * 
 */
@Entity
@NamedQuery(name="Gerencia.findAll", query="SELECT g FROM Gerencia g")
public class Gerencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_gerencia")
	private int idGerencia;

	private byte enable;

	@Column(name="id_gerente")
	private int idGerente;

	private String nombre;

	public Gerencia() {
	}

	public int getIdGerencia() {
		return this.idGerencia;
	}

	public void setIdGerencia(int idGerencia) {
		this.idGerencia = idGerencia;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdGerente() {
		return this.idGerente;
	}

	public void setIdGerente(int idGerente) {
		this.idGerente = idGerente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}