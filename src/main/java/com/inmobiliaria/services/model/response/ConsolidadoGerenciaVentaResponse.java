package com.inmobiliaria.services.model.response;

import com.inmobiliaria.services.model.Gerencia;

public class ConsolidadoGerenciaVentaResponse {
	private Gerencia gerencia;
	private double meta;
	private double avance;
	private int minuta;
	private int ci;
	private int preca;
	private int ev;
	private int sp;
	private int caida;
	public Gerencia getGerencia() {
		return gerencia;
	}
	public void setGerencia(Gerencia gerencia) {
		this.gerencia = gerencia;
	}
	public double getMeta() {
		return meta;
	}
	public void setMeta(double meta) {
		this.meta = meta;
	}
	public double getAvance() {
		return avance;
	}
	public void setAvance(double avance) {
		this.avance = avance;
	}
	public int getMinuta() {
		return minuta;
	}
	public void setMinuta(int minuta) {
		this.minuta = minuta;
	}
	public int getCi() {
		return ci;
	}
	public void setCi(int ci) {
		this.ci = ci;
	}
	public int getPreca() {
		return preca;
	}
	public void setPreca(int preca) {
		this.preca = preca;
	}
	public int getEv() {
		return ev;
	}
	public void setEv(int ev) {
		this.ev = ev;
	}
	public int getSp() {
		return sp;
	}
	public void setSp(int sp) {
		this.sp = sp;
	}
	public int getCaida() {
		return caida;
	}
	public void setCaida(int caida) {
		this.caida = caida;
	}

}
