/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jefe_venta database table.
 * 
 */
@Entity
@Table(name="jefe_venta")
@NamedQuery(name="JefeVenta.findAll", query="SELECT j FROM JefeVenta j")
public class JefeVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_jefe_venta")
	private int idJefeVenta;

	private byte enable;

	@Column(name="id_persona")
	private int idPersona;

	public int getIdJefeVenta() {
		return this.idJefeVenta;
	}

	public void setIdJefeVenta(int idJefeVenta) {
		this.idJefeVenta = idJefeVenta;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

}