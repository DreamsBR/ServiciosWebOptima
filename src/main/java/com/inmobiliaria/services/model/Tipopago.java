package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipopago database table.
 * 
 */
@Entity
@NamedQuery(name="Tipopago.findAll", query="SELECT t FROM Tipopago t")
public class Tipopago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtipopago;

	private byte enable;

	private String nombre;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="tipopago")
	private List<Pago> pagos;

	public Tipopago() {
	}

	public int getIdtipopago() {
		return this.idtipopago;
	}

	public void setIdtipopago(int idtipopago) {
		this.idtipopago = idtipopago;
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

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setTipopago(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setTipopago(null);

		return pago;
	}

}