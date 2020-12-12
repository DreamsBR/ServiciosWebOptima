package com.inmobiliaria.services.model.response;

import com.inmobiliaria.services.model.PeriodoGerencia;

public class ConsolidadoGerenciaResponse {
	private PeriodoGerencia periodoGerencia;
	private double venta;
	public PeriodoGerencia getPeriodoGerencia() {
		return periodoGerencia;
	}
	public void setPeriodoGerencia(PeriodoGerencia periodoGerencia) {
		this.periodoGerencia = periodoGerencia;
	}
	public double getVenta() {
		return venta;
	}
	public void setVenta(double venta) {
		this.venta = venta;
	}
}
