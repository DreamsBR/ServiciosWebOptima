package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jefatura database table.
 * 
 */
@Entity
@NamedQuery(name="Jefatura.findAll", query="SELECT j FROM Jefatura j")
public class Jefatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idjefatura;

	private byte enable;

	private String nombre;

	//bi-directional many-to-one association to GerenciaJefatura
	@OneToMany(mappedBy="jefatura")
	private List<GerenciaJefatura> gerenciaJefaturas;

	//bi-directional many-to-one association to Jefeventa
	@ManyToOne
	@JoinColumn(name="idjefeventa")
	private Jefeventa jefeventa;

	//bi-directional many-to-one association to JefaturaProyecto
	@OneToMany(mappedBy="jefatura")
	private List<JefaturaProyecto> jefaturaProyectos;

	//bi-directional many-to-one association to Vendedor
	@OneToMany(mappedBy="jefatura")
	private List<Vendedor> vendedors;

	public Jefatura() {
	}

	public int getIdjefatura() {
		return this.idjefatura;
	}

	public void setIdjefatura(int idjefatura) {
		this.idjefatura = idjefatura;
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

	public List<GerenciaJefatura> getGerenciaJefaturas() {
		return this.gerenciaJefaturas;
	}

	public void setGerenciaJefaturas(List<GerenciaJefatura> gerenciaJefaturas) {
		this.gerenciaJefaturas = gerenciaJefaturas;
	}

	public GerenciaJefatura addGerenciaJefatura(GerenciaJefatura gerenciaJefatura) {
		getGerenciaJefaturas().add(gerenciaJefatura);
		gerenciaJefatura.setJefatura(this);

		return gerenciaJefatura;
	}

	public GerenciaJefatura removeGerenciaJefatura(GerenciaJefatura gerenciaJefatura) {
		getGerenciaJefaturas().remove(gerenciaJefatura);
		gerenciaJefatura.setJefatura(null);

		return gerenciaJefatura;
	}

	public Jefeventa getJefeventa() {
		return this.jefeventa;
	}

	public void setJefeventa(Jefeventa jefeventa) {
		this.jefeventa = jefeventa;
	}

	public List<JefaturaProyecto> getJefaturaProyectos() {
		return this.jefaturaProyectos;
	}

	public void setJefaturaProyectos(List<JefaturaProyecto> jefaturaProyectos) {
		this.jefaturaProyectos = jefaturaProyectos;
	}

	public JefaturaProyecto addJefaturaProyecto(JefaturaProyecto jefaturaProyecto) {
		getJefaturaProyectos().add(jefaturaProyecto);
		jefaturaProyecto.setJefatura(this);

		return jefaturaProyecto;
	}

	public JefaturaProyecto removeJefaturaProyecto(JefaturaProyecto jefaturaProyecto) {
		getJefaturaProyectos().remove(jefaturaProyecto);
		jefaturaProyecto.setJefatura(null);

		return jefaturaProyecto;
	}

	public List<Vendedor> getVendedors() {
		return this.vendedors;
	}

	public void setVendedors(List<Vendedor> vendedors) {
		this.vendedors = vendedors;
	}

	public Vendedor addVendedor(Vendedor vendedor) {
		getVendedors().add(vendedor);
		vendedor.setJefatura(this);

		return vendedor;
	}

	public Vendedor removeVendedor(Vendedor vendedor) {
		getVendedors().remove(vendedor);
		vendedor.setJefatura(null);

		return vendedor;
	}

}