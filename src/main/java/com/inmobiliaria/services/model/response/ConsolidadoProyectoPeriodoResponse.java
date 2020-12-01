package com.inmobiliaria.services.model.response;

import com.inmobiliaria.services.model.PeriodoProyecto;

public class ConsolidadoProyectoPeriodoResponse {
	private PeriodoProyecto periodoProyecto;
	private double venta;
	public PeriodoProyecto getPeriodoProyecto() {
		return periodoProyecto;
	}
	public void setPeriodoProyecto(PeriodoProyecto periodoProyecto) {
		this.periodoProyecto = periodoProyecto;
	}
	public double getVenta() {
		return venta;
	}
	public void setVenta(double venta) {
		this.venta = venta;
	}
}
