package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the canal database table.
 * 
 */
@Entity
@NamedQuery(name="Canal.findAll", query="SELECT c FROM Canal c")
public class Canal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_canal")
	private int idCanal;

	private byte enable;

	private String nombre;

	public int getIdCanal() {
		return this.idCanal;
	}

	public void setIdCanal(int idCanal) {
		this.idCanal = idCanal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getEnable() {
		return enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

}