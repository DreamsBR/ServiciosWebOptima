package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estadocivil database table.
 * 
 */
@Entity
@NamedQuery(name="Estadocivil.findAll", query="SELECT e FROM Estadocivil e")
public class Estadocivil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idestadocivil;

	private byte enable;

	private String nombre;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="estadocivil")
	private List<Cliente> clientes;

	public Estadocivil() {
	}

	public int getIdestadocivil() {
		return this.idestadocivil;
	}

	public void setIdestadocivil(int idestadocivil) {
		this.idestadocivil = idestadocivil;
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

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setEstadocivil(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setEstadocivil(null);

		return cliente;
	}

}