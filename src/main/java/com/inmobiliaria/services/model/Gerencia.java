package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gerencia database table.
 * 
 */
@Entity
@NamedQuery(name="Gerencia.findAll", query="SELECT g FROM Gerencia g")
public class Gerencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idgerencia;

	private byte enable;

	private String nombre;

	//bi-directional many-to-one association to Gerente
	@ManyToOne
	@JoinColumn(name="idgerente")
	private Gerente gerente;

	//bi-directional many-to-one association to GerenciaJefatura
	@OneToMany(mappedBy="gerencia")
	private List<GerenciaJefatura> gerenciaJefaturas;

	public Gerencia() {
	}

	public int getIdgerencia() {
		return this.idgerencia;
	}

	public void setIdgerencia(int idgerencia) {
		this.idgerencia = idgerencia;
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

	public Gerente getGerente() {
		return this.gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public List<GerenciaJefatura> getGerenciaJefaturas() {
		return this.gerenciaJefaturas;
	}

	public void setGerenciaJefaturas(List<GerenciaJefatura> gerenciaJefaturas) {
		this.gerenciaJefaturas = gerenciaJefaturas;
	}

	public GerenciaJefatura addGerenciaJefatura(GerenciaJefatura gerenciaJefatura) {
		getGerenciaJefaturas().add(gerenciaJefatura);
		gerenciaJefatura.setGerencia(this);

		return gerenciaJefatura;
	}

	public GerenciaJefatura removeGerenciaJefatura(GerenciaJefatura gerenciaJefatura) {
		getGerenciaJefaturas().remove(gerenciaJefatura);
		gerenciaJefatura.setGerencia(null);

		return gerenciaJefatura;
	}

}