package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_credito database table.
 * 
 */
@Entity
@Table(name="tipo_credito")
@NamedQuery(name="TipoCredito.findAll", query="SELECT t FROM TipoCredito t")
public class TipoCredito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_credito")
	private int idTipoCredito;

	private boolean enable;

	private String nombre;

	public TipoCredito() {
	}

	public int getIdTipoCredito() {
		return this.idTipoCredito;
	}

	public void setIdTipoCredito(int idTipoCredito) {
		this.idTipoCredito = idTipoCredito;
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