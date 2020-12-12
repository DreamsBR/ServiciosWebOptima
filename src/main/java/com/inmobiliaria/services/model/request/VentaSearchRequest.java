package com.inmobiliaria.services.model.request;

public class VentaSearchRequest {
	private String fechaIni;
	private String fechaFin;
	private int idCliente;
	private int idEstadoVenta;
	private int idProyecto;
	public int getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}
	public String getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdEstadoVenta() {
		return idEstadoVenta;
	}
	public void setIdEstadoVenta(int idEstadoVenta) {
		this.idEstadoVenta = idEstadoVenta;
	}
}
