package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jefeventa database table.
 * 
 */
@Entity
@NamedQuery(name="Jefeventa.findAll", query="SELECT j FROM Jefeventa j")
public class Jefeventa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idjefeventa;

	private byte enable;

	private int idpersona;

	//bi-directional many-to-one association to Jefatura
	@OneToMany(mappedBy="jefeventa")
	private List<Jefatura> jefaturas;

	public Jefeventa() {
	}

	public int getIdjefeventa() {
		return this.idjefeventa;
	}

	public void setIdjefeventa(int idjefeventa) {
		this.idjefeventa = idjefeventa;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public List<Jefatura> getJefaturas() {
		return this.jefaturas;
	}

	public void setJefaturas(List<Jefatura> jefaturas) {
		this.jefaturas = jefaturas;
	}

	public Jefatura addJefatura(Jefatura jefatura) {
		getJefaturas().add(jefatura);
		jefatura.setJefeventa(this);

		return jefatura;
	}

	public Jefatura removeJefatura(Jefatura jefatura) {
		getJefaturas().remove(jefatura);
		jefatura.setJefeventa(null);

		return jefatura;
	}

}