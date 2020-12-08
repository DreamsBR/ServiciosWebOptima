package com.inmobiliaria.services.model.request;

import java.math.BigDecimal;
import java.util.Date;

public class PagoRequest {
	private int idPago;

	private byte enable;

	private Date fecha;

	private int idVenta;

	private BigDecimal monto;
	
	private String numeroOperacion;

	private byte pagado;

	private String porcentaje;

	private String fileRuta;
	
	public String getFileRuta() {
		return fileRuta;
	}

	public void setFileRuta(String fileRuta) {
		this.fileRuta = fileRuta;
	}

	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public byte getEnable() {
		return enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getNumeroOperacion() {
		return numeroOperacion;
	}

	public void setNumeroOperacion(String numeroOperacion) {
		this.numeroOperacion = numeroOperacion;
	}

	public byte getPagado() {
		return pagado;
	}

	public void setPagado(byte pagado) {
		this.pagado = pagado;
	}

	public String getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}
}
