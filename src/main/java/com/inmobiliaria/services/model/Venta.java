package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the venta database table.
 * 
 */
@Entity
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_venta")
	private int idVenta;

	@Column(name="ayuda_inicial")
	private BigDecimal ayudaInicial;

	private BigDecimal descuento;

	private boolean enable;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_desembolso")
	private Date fechaDesembolso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_minuta")
	private Date fechaMinuta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_separacion")
	private Date fechaSeparacion;

	@Column(name="id_canal")
	private int idCanal;

	@Column(name="id_categoria")
	private int idCategoria;

	@Column(name="id_cliente")
	private int idCliente;

	@Column(name="id_copropietario")
	private int idCopropietario;

	@Column(name="id_estado_venta")
	private int idEstadoVenta;

	@Column(name="id_financiamiento")
	private int idFinanciamiento;

	@Column(name="id_motivo")
	private int idMotivo;

	@Column(name="id_vendedor")
	private int idVendedor;

	private BigDecimal importe;

	private BigDecimal total;

	public Venta() {
	}

	public int getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public BigDecimal getAyudaInicial() {
		return this.ayudaInicial;
	}

	public void setAyudaInicial(BigDecimal ayudaInicial) {
		this.ayudaInicial = ayudaInicial;
	}

	public BigDecimal getDescuento() {
		return this.descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public boolean getEnable() {
		return this.enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Date getFechaDesembolso() {
		return this.fechaDesembolso;
	}

	public void setFechaDesembolso(Date fechaDesembolso) {
		this.fechaDesembolso = fechaDesembolso;
	}

	public Date getFechaMinuta() {
		return this.fechaMinuta;
	}

	public void setFechaMinuta(Date fechaMinuta) {
		this.fechaMinuta = fechaMinuta;
	}

	public Date getFechaSeparacion() {
		return this.fechaSeparacion;
	}

	public void setFechaSeparacion(Date fechaSeparacion) {
		this.fechaSeparacion = fechaSeparacion;
	}

	public int getIdCanal() {
		return this.idCanal;
	}

	public void setIdCanal(int idCanal) {
		this.idCanal = idCanal;
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdCopropietario() {
		return this.idCopropietario;
	}

	public void setIdCopropietario(int idCopropietario) {
		this.idCopropietario = idCopropietario;
	}

	public int getIdEstadoVenta() {
		return this.idEstadoVenta;
	}

	public void setIdEstadoVenta(int idEstadoVenta) {
		this.idEstadoVenta = idEstadoVenta;
	}

	public int getIdFinanciamiento() {
		return this.idFinanciamiento;
	}

	public void setIdFinanciamiento(int idFinanciamiento) {
		this.idFinanciamiento = idFinanciamiento;
	}

	public int getIdMotivo() {
		return this.idMotivo;
	}

	public void setIdMotivo(int idMotivo) {
		this.idMotivo = idMotivo;
	}

	public int getIdVendedor() {
		return this.idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}