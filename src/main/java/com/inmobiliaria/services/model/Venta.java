package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the venta database table.
 * 
 */
@Entity
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idventa;

	private BigDecimal ayudainicial;

	private BigDecimal descuento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechadesembolso;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaminuta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaseparacion;

	private BigDecimal importe;

	private BigDecimal total;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="venta")
	private List<Pago> pagos;

	//bi-directional many-to-one association to Canal
	@ManyToOne
	@JoinColumn(name="idcanal")
	private Canal canal;

	//bi-directional many-to-one association to Motivo
	@ManyToOne
	@JoinColumn(name="idmotivo")
	private Motivo motivo;

	//bi-directional many-to-one association to Vendedor
	@ManyToOne
	@JoinColumn(name="idvendedor")
	private Vendedor vendedor;

	//bi-directional many-to-one association to Estadoventa
	@ManyToOne
	@JoinColumn(name="idestadoventa")
	private Estadoventa estadoventa;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="idcategoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente1;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idcopropietario")
	private Cliente cliente2;

	//bi-directional many-to-one association to Financiamiento
	@ManyToOne
	@JoinColumn(name="idfinanciamiento")
	private Financiamiento financiamiento;

	//bi-directional many-to-one association to VentaInmueble
	@OneToMany(mappedBy="venta")
	private List<VentaInmueble> ventaInmuebles;

	public Venta() {
	}

	public int getIdventa() {
		return this.idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}

	public BigDecimal getAyudainicial() {
		return this.ayudainicial;
	}

	public void setAyudainicial(BigDecimal ayudainicial) {
		this.ayudainicial = ayudainicial;
	}

	public BigDecimal getDescuento() {
		return this.descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public Date getFechadesembolso() {
		return this.fechadesembolso;
	}

	public void setFechadesembolso(Date fechadesembolso) {
		this.fechadesembolso = fechadesembolso;
	}

	public Date getFechaminuta() {
		return this.fechaminuta;
	}

	public void setFechaminuta(Date fechaminuta) {
		this.fechaminuta = fechaminuta;
	}

	public Date getFechaseparacion() {
		return this.fechaseparacion;
	}

	public void setFechaseparacion(Date fechaseparacion) {
		this.fechaseparacion = fechaseparacion;
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

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setVenta(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setVenta(null);

		return pago;
	}

	public Canal getCanal() {
		return this.canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public Motivo getMotivo() {
		return this.motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Estadoventa getEstadoventa() {
		return this.estadoventa;
	}

	public void setEstadoventa(Estadoventa estadoventa) {
		this.estadoventa = estadoventa;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Cliente getCliente1() {
		return this.cliente1;
	}

	public void setCliente1(Cliente cliente1) {
		this.cliente1 = cliente1;
	}

	public Cliente getCliente2() {
		return this.cliente2;
	}

	public void setCliente2(Cliente cliente2) {
		this.cliente2 = cliente2;
	}

	public Financiamiento getFinanciamiento() {
		return this.financiamiento;
	}

	public void setFinanciamiento(Financiamiento financiamiento) {
		this.financiamiento = financiamiento;
	}

	public List<VentaInmueble> getVentaInmuebles() {
		return this.ventaInmuebles;
	}

	public void setVentaInmuebles(List<VentaInmueble> ventaInmuebles) {
		this.ventaInmuebles = ventaInmuebles;
	}

	public VentaInmueble addVentaInmueble(VentaInmueble ventaInmueble) {
		getVentaInmuebles().add(ventaInmueble);
		ventaInmueble.setVenta(this);

		return ventaInmueble;
	}

	public VentaInmueble removeVentaInmueble(VentaInmueble ventaInmueble) {
		getVentaInmuebles().remove(ventaInmueble);
		ventaInmueble.setVenta(null);

		return ventaInmueble;
	}

}