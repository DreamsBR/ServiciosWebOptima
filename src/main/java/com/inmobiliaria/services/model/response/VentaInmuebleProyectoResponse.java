package com.inmobiliaria.services.model.response;

import java.math.BigDecimal;

public class VentaInmuebleProyectoResponse {
	private Integer idCliente;
	private String nombres;
	private String apellidos;
	private String tipoDocumento;
	private String nroDocumento;
	private Integer idVenta;
	private BigDecimal importe;
	private String estado;
	private String fechaSeparacion;
	private String fechaMinuta;
	private String fechaDesembolso;
	private String fechaEpp;
	private String fechaCaida;
	
	public String getFechaSeparacion() {
		return fechaSeparacion;
	}
	public void setFechaSeparacion(String fechaSeparacion) {
		this.fechaSeparacion = fechaSeparacion;
	}
	public String getFechaMinuta() {
		return fechaMinuta;
	}
	public void setFechaMinuta(String fechaMinuta) {
		this.fechaMinuta = fechaMinuta;
	}
	public String getFechaDesembolso() {
		return fechaDesembolso;
	}
	public void setFechaDesembolso(String fechaDesembolso) {
		this.fechaDesembolso = fechaDesembolso;
	}
	public String getFechaEpp() {
		return fechaEpp;
	}
	public void setFechaEpp(String fechaEpp) {
		this.fechaEpp = fechaEpp;
	}
	public String getFechaCaida() {
		return fechaCaida;
	}
	public void setFechaCaida(String fechaCaida) {
		this.fechaCaida = fechaCaida;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public Integer getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
