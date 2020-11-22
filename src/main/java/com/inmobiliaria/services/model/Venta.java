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

	private byte enable;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_desembolso")
	private Date fechaDesembolso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_minuta")
	private Date fechaMinuta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_separacion")
	private Date fechaSeparacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_epp")
	private Date fechaEpp;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_caida")
	private Date fechaCaida;
	
	//bi-directional many-to-one association to Canal
	@ManyToOne
	@JoinColumn(name="id_canal")
	private Canal canal;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to EstadoVenta
	@ManyToOne
	@JoinColumn(name="id_estado_venta")
	private EstadoVenta estadoVenta;

	//bi-directional many-to-one association to Financiamiento
	@ManyToOne
	@JoinColumn(name="id_financiamiento")
	private Financiamiento financiamiento;

	//bi-directional many-to-one association to Motivo
	@ManyToOne
	@JoinColumn(name="id_motivo")
	private Motivo motivo;

	//bi-directional many-to-one association to Vendedor
	@ManyToOne
	@JoinColumn(name="id_vendedor")
	private Vendedor vendedor;

	@Column(name="id_proyecto")
	private int idProyecto;
	
	private BigDecimal importe;

	private BigDecimal total;

	public Venta() {
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public int getIdVenta() {
		return this.idVenta;
	}

	public Date getFechaEpp() {
		return fechaEpp;
	}

	public void setFechaEpp(Date fechaEpp) {
		this.fechaEpp = fechaEpp;
	}

	public Date getFechaCaida() {
		return fechaCaida;
	}

	public void setFechaCaida(Date fechaCaida) {
		this.fechaCaida = fechaCaida;
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

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
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

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EstadoVenta getEstadoVenta() {
		return estadoVenta;
	}

	public void setEstadoVenta(EstadoVenta estadoVenta) {
		this.estadoVenta = estadoVenta;
	}

	public Financiamiento getFinanciamiento() {
		return financiamiento;
	}

	public void setFinanciamiento(Financiamiento financiamiento) {
		this.financiamiento = financiamiento;
	}

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}