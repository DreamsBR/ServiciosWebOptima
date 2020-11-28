package com.inmobiliaria.services.model.request;

import java.math.BigDecimal;
import java.util.Date;

public class VentaRequest {
	private int idVenta;

	private BigDecimal ayudaInicial;

	private BigDecimal descuento;

	private byte enable;

	private Date fechaDesembolso;

	private Date fechaMinuta;

	private Date fechaSeparacion;

	private Date fechaEpp;

	private Date fechaCaida;
	
	private int idCanal;

	private int idCategoria;

	private int idCliente;

	private int idEstadoVenta;

	private int idFinanciamiento;

	private int idMotivo;

	private int idVendedor;

	private int idProyecto;
	
	private BigDecimal importe;

	private BigDecimal total;
	
	private Date fechaRegistro;
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public BigDecimal getAyudaInicial() {
		return ayudaInicial;
	}

	public void setAyudaInicial(BigDecimal ayudaInicial) {
		this.ayudaInicial = ayudaInicial;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public byte getEnable() {
		return enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public Date getFechaDesembolso() {
		return fechaDesembolso;
	}

	public void setFechaDesembolso(Date fechaDesembolso) {
		this.fechaDesembolso = fechaDesembolso;
	}

	public Date getFechaMinuta() {
		return fechaMinuta;
	}

	public void setFechaMinuta(Date fechaMinuta) {
		this.fechaMinuta = fechaMinuta;
	}

	public Date getFechaSeparacion() {
		return fechaSeparacion;
	}

	public void setFechaSeparacion(Date fechaSeparacion) {
		this.fechaSeparacion = fechaSeparacion;
	}

	public Date getFechaEpp() {
		return fechaEpp;
	}

	public void setFechaEpp(Date fechaEpp) {
		this.fechaEpp = fechaEpp;
	}

	public Date getFechaCaida() {
		return fechaCaida;
	}

	public void setFechaCaida(Date fechaCaida) {
		this.fechaCaida = fechaCaida;
	}

	public int getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(int idCanal) {
		this.idCanal = idCanal;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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

	public int getIdFinanciamiento() {
		return idFinanciamiento;
	}

	public void setIdFinanciamiento(int idFinanciamiento) {
		this.idFinanciamiento = idFinanciamiento;
	}

	public int getIdMotivo() {
		return idMotivo;
	}

	public void setIdMotivo(int idMotivo) {
		this.idMotivo = idMotivo;
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
}