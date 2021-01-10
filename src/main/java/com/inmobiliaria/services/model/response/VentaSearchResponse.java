package com.inmobiliaria.services.model.response;

import java.util.List;

import com.inmobiliaria.services.model.Pago;
import com.inmobiliaria.services.model.Venta;
import com.inmobiliaria.services.model.VentaInmueble;

public class VentaSearchResponse {
	private Venta venta; 
	private List<VentaInmueble> listVentaInmueble;
	private List<Pago> listPagos;
	public VentaSearchResponse(Venta venta, List<VentaInmueble> listVentaInmueble, List<Pago> listPagos) {
		this.venta = venta;
		this.listVentaInmueble = listVentaInmueble;
		this.listPagos = listPagos;
	}
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public List<VentaInmueble> getListVentaInmueble() {
		return listVentaInmueble;
	}
	public void setListVentaInmueble(List<VentaInmueble> listVentaInmueble) {
		this.listVentaInmueble = listVentaInmueble;
	}
	public List<Pago> getListPagos() {
		return listPagos;
	}
	public void setListPagos(List<Pago> listPagos) {
		this.listPagos = listPagos;
	}

}
