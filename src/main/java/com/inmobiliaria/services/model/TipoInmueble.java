package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_inmueble database table.
 * 
 */
@Entity
@Table(name="tipo_inmueble")
@NamedQuery(name="TipoInmueble.findAll", query="SELECT t FROM TipoInmueble t")
public class TipoInmueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_inmueble")
	private int idTipoInmueble;

	private boolean enable;

	private String nombre;

	public TipoInmueble() {
	}

	public int getIdTipoInmueble() {
		return this.idTipoInmueble;
	}

	public void setIdTipoInmueble(int idTipoInmueble) {
		this.idTipoInmueble = idTipoInmueble;
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