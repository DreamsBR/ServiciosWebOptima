package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the motivo database table.
 * 
 */
@Entity
@NamedQuery(name="Motivo.findAll", query="SELECT m FROM Motivo m")
public class Motivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_motivo")
	private int idMotivo;

	private boolean enable;

	private String nombre;

	public Motivo() {
	}

	public int getIdMotivo() {
		return this.idMotivo;
	}

	public void setIdMotivo(int idMotivo) {
		this.idMotivo = idMotivo;
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