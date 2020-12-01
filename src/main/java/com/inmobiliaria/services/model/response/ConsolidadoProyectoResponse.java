package com.inmobiliaria.services.model.response;

import java.math.BigDecimal;

import com.inmobiliaria.services.model.Vendedor;

public class ConsolidadoProyectoResponse {
	private Vendedor vendedor;
	private BigDecimal meta;
	private double avance;
	private int minuta;
	private int ci;
	private int preca;
	private int ev;
	private int sp;
	private int caida;
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public BigDecimal getMeta() {
		return meta;
	}
	public void setMeta(BigDecimal meta) {
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
