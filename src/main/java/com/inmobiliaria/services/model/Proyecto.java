package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proyecto database table.
 * 
 */
@Entity
@NamedQuery(name="Proyecto.findAll", query="SELECT p FROM Proyecto p")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idproyecto;

	private String direccion;

	private byte enable;

	private String nombre;

	//bi-directional many-to-one association to Inmueble
	@OneToMany(mappedBy="proyecto")
	private List<Inmueble> inmuebles;

	//bi-directional many-to-one association to JefaturaProyecto
	@OneToMany(mappedBy="proyecto")
	private List<JefaturaProyecto> jefaturaProyectos;

	public Proyecto() {
	}

	public int getIdproyecto() {
		return this.idproyecto;
	}

	public void setIdproyecto(int idproyecto) {
		this.idproyecto = idproyecto;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public List<Inmueble> getInmuebles() {
		return this.inmuebles;
	}

	public void setInmuebles(List<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

	public Inmueble addInmueble(Inmueble inmueble) {
		getInmuebles().add(inmueble);
		inmueble.setProyecto(this);

		return inmueble;
	}

	public Inmueble removeInmueble(Inmueble inmueble) {
		getInmuebles().remove(inmueble);
		inmueble.setProyecto(null);

		return inmueble;
	}

	public List<JefaturaProyecto> getJefaturaProyectos() {
		return this.jefaturaProyectos;
	}

	public void setJefaturaProyectos(List<JefaturaProyecto> jefaturaProyectos) {
		this.jefaturaProyectos = jefaturaProyectos;
	}

	public JefaturaProyecto addJefaturaProyecto(JefaturaProyecto jefaturaProyecto) {
		getJefaturaProyectos().add(jefaturaProyecto);
		jefaturaProyecto.setProyecto(this);

		return jefaturaProyecto;
	}

	public JefaturaProyecto removeJefaturaProyecto(JefaturaProyecto jefaturaProyecto) {
		getJefaturaProyectos().remove(jefaturaProyecto);
		jefaturaProyecto.setProyecto(null);

		return jefaturaProyecto;
	}

}