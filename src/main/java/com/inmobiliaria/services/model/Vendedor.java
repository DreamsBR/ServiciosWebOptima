package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vendedor database table.
 * 
 */
@Entity
@NamedQuery(name="Vendedor.findAll", query="SELECT v FROM Vendedor v")
public class Vendedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_vendedor")
	private int idVendedor;

	private byte enable;

	@Column(name="id_jefatura")
	private int idJefatura;

	private String nombre;

	public Vendedor() {
	}

	public int getIdVendedor() {
		return this.idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdJefatura() {
		return this.idJefatura;
	}

	public void setIdJefatura(int idJefatura) {
		this.idJefatura = idJefatura;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}