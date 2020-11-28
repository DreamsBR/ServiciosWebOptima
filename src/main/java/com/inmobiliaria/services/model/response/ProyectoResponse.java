package com.inmobiliaria.services.model.response;

public class ProyectoResponse {
	private int idProyecto;

	private String direccion;

	private byte enable;

	private String nombre;

	private String codigo;

	private GerenciaInfoResponse gerencia;

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public byte getEnable() {
		return enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public GerenciaInfoResponse getGerencia() {
		return gerencia;
	}

	public void setGerencia(GerenciaInfoResponse gerencia) {
		this.gerencia = gerencia;
	}
}
