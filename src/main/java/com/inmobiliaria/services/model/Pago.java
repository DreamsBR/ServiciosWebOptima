package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pago database table.
 * 
 */
@Entity
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pago")
	private int idPago;

	private byte enable;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@ManyToOne
	@JoinColumn(name="id_venta")
	private Venta venta;
	
	private BigDecimal monto;
	
	@Column(name="numero_operacion")
	private String numeroOperacion;

	private byte pagado;

	private String porcentaje;

	@Column(name="file_ruta")
	private String fileRuta;
	
	public int getIdPago() {
		return this.idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getNumeroOperacion() {
		return this.numeroOperacion;
	}

	public void setNumeroOperacion(String numeroOperacion) {
		this.numeroOperacion = numeroOperacion;
	}

	public byte getPagado() {
		return this.pagado;
	}

	public void setPagado(byte pagado) {
		this.pagado = pagado;
	}

	public String getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getFileRuta() {
		return fileRuta;
	}

	public void setFileRuta(String fileRuta) {
		this.fileRuta = fileRuta;
	}

}