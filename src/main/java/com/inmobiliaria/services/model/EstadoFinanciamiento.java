package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado_financiamiento database table.
 * 
 */
@Entity
@Table(name="estado_financiamiento")
@NamedQuery(name="EstadoFinanciamiento.findAll", query="SELECT e FROM EstadoFinanciamiento e")
public class EstadoFinanciamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_financiamiento")
	private int idEstadoFinanciamiento;

	private boolean enable;

	private String nombre;

	public EstadoFinanciamiento() {
	}

	public int getIdEstadoFinanciamiento() {
		return this.idEstadoFinanciamiento;
	}

	public void setIdEstadoFinanciamiento(int idEstadoFinanciamiento) {
		this.idEstadoFinanciamiento = idEstadoFinanciamiento;
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