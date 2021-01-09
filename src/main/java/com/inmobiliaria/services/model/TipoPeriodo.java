package com.inmobiliaria.services.model;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_periodo database table.
 * 
 */
@Entity
@Table(name="tipo_periodo")
@NamedQuery(name="TipoPeriodo.findAll", query="SELECT t FROM TipoPeriodo t")
public class TipoPeriodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_periodo")
	private int idTipoPeriodo;

	private byte enable;

	private String nombre;

	public TipoPeriodo() {
	}

	public int getIdTipoPeriodo() {
		return this.idTipoPeriodo;
	}

	public void setIdTipoPeriodo(int idTipoPeriodo) {
		this.idTipoPeriodo = idTipoPeriodo;
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