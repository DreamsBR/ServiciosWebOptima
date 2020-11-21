package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_inmueble_categoria database table.
 * 
 */
@Entity
@Table(name="tipo_inmueble_categoria")
@NamedQuery(name="TipoInmuebleCategoria.findAll", query="SELECT t FROM TipoInmuebleCategoria t")
public class TipoInmuebleCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_inmueble_categoria")
	private int idTipoInmuebleCategoria;

	private byte enable;

	@Column(name="id_tipo_inmueble")
	private int idTipoInmueble;

	private String nombre;

	public TipoInmuebleCategoria() {
	}

	public int getIdTipoInmuebleCategoria() {
		return this.idTipoInmuebleCategoria;
	}

	public void setIdTipoInmuebleCategoria(int idTipoInmuebleCategoria) {
		this.idTipoInmuebleCategoria = idTipoInmuebleCategoria;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdTipoInmueble() {
		return this.idTipoInmueble;
	}

	public void setIdTipoInmueble(int idTipoInmueble) {
		this.idTipoInmueble = idTipoInmueble;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}