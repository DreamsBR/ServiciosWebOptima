package com.inmobiliaria.services.model.response;

import com.inmobiliaria.services.model.PeriodoColaborador;

public class ConsolidadoColaboradorPeriodoResponse {
	private PeriodoColaborador periodoColaborador;
	private double venta;
	public PeriodoColaborador getPeriodoColaborador() {
		return periodoColaborador;
	}
	public void setPeriodoColaborador(PeriodoColaborador periodoColaborador) {
		this.periodoColaborador = periodoColaborador;
	}
	public double getVenta() {
		return venta;
	}
	public void setVenta(double venta) {
		this.venta = venta;
	}
}
