package com.inmobiliaria.services.model;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rango_periodo database table.
 * 
 */
@Entity
@Table(name="rango_periodo")
@NamedQuery(name="RangoPeriodo.findAll", query="SELECT r FROM RangoPeriodo r")
public class RangoPeriodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rango_periodo")
	private int idRangoPeriodo;

	@ManyToOne
	@JoinColumn(name="id_periodo")
	private Periodo periodo;

	@ManyToOne
	@JoinColumn(name="id_rango")
	private Rango rango;

	public RangoPeriodo() {
	}

	public int getIdRangoPeriodo() {
		return this.idRangoPeriodo;
	}

	public void setIdRangoPeriodo(int idRangoPeriodo) {
		this.idRangoPeriodo = idRangoPeriodo;
	}

	public Rango getRango() {
		return this.rango;
	}

	public void setRango(Rango rango) {
		this.rango = rango;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

}