package com.inmobiliaria.services.model.response;

import java.util.List;

import com.inmobiliaria.services.model.Colaborador;
import com.inmobiliaria.services.model.Gerencia;
import com.inmobiliaria.services.model.Jefatura;
import com.inmobiliaria.services.model.Proyecto;

public class GerenciaResponse {
	private Gerencia gerencia;
	private Colaborador gerente;
	private List<Jefatura> listJefatura;
	private List<Proyecto> listProyecto;
	public Gerencia getGerencia() {
		return gerencia;
	}
	public void setGerencia(Gerencia gerencia) {
		this.gerencia = gerencia;
	}
	public Colaborador getGerente() {
		return gerente;
	}
	public void setGerente(Colaborador gerente) {
		this.gerente = gerente;
	}
	public List<Jefatura> getListJefatura() {
		return listJefatura;
	}
	public void setListJefatura(List<Jefatura> listJefatura) {
		this.listJefatura = listJefatura;
	}
	public List<Proyecto> getListProyecto() {
		return listProyecto;
	}
	public void setListProyecto(List<Proyecto> listProyecto) {
		this.listProyecto = listProyecto;
	}
}
