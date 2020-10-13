/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
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
	@Column(name="id_tipo_inmueble")
	private int idTipoInmueble;

	private byte enable;

	private String nombre;

	public int getIdTipoInmueble() {
		return this.idTipoInmueble;
	}

	public void setIdTipoInmueble(int idTipoInmueble) {
		this.idTipoInmueble = idTipoInmueble;
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

}