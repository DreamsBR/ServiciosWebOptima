package com.inmobiliaria.services.model.response;

import com.inmobiliaria.services.model.Gerencia;
import com.inmobiliaria.services.model.Proyecto;

public class ProyectoResponse {
	private Proyecto proyecto;
	private Gerencia gerencia;
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public Gerencia getGerencia() {
		return gerencia;
	}
	public void setGerencia(Gerencia gerencia) {
		this.gerencia = gerencia;
	}
}
