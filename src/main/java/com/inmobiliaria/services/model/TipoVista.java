package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_vista database table.
 * 
 */
@Entity
@Table(name="tipo_vista")
@NamedQuery(name="TipoVista.findAll", query="SELECT t FROM TipoVista t")
public class TipoVista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_vista")
	private int idTipoVista;

	private boolean enable;

	private String nombre;

	public TipoVista() {
	}

	public int getIdTipoVista() {
		return this.idTipoVista;
	}

	public void setIdTipoVista(int idTipoVista) {
		this.idTipoVista = idTipoVista;
	}

	public boolean getEnable() {
		return this.enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}