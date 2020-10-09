package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcliente;

	private String asesor;

	private String conyuge;

	private String direccion;

	private String distrito;

	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechanacimiento;

	private int idestadocivilconyuge;

	private BigDecimal ingresos;

	private String lugartrabajo;

	private String nombre;

	private String nrodocconyuge;

	private String nrodocumento;

	private String ocupacion;

	private String ocupacionconyuge;

	private String provincia;

	private String sexo;

	private String telefono;

	private int tipodocconyuge;

	//bi-directional many-to-one association to Tipodocumento
	@ManyToOne
	@JoinColumn(name="idtipodocumento")
	private Tipodocumento tipodocumento;

	//bi-directional many-to-one association to Pai
	@ManyToOne
	@JoinColumn(name="idpais")
	private Pai pai;

	//bi-directional many-to-one association to Estadocivil
	@ManyToOne
	@JoinColumn(name="idestadocivil")
	private Estadocivil estadocivil;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="cliente1")
	private List<Venta> ventas1;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="cliente2")
	private List<Venta> ventas2;

	public Cliente() {
	}

	public int getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getAsesor() {
		return this.asesor;
	}

	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	public String getConyuge() {
		return this.conyuge;
	}

	public void setConyuge(String conyuge) {
		this.conyuge = conyuge;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public int getIdestadocivilconyuge() {
		return this.idestadocivilconyuge;
	}

	public void setIdestadocivilconyuge(int idestadocivilconyuge) {
		this.idestadocivilconyuge = idestadocivilconyuge;
	}

	public BigDecimal getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(BigDecimal ingresos) {
		this.ingresos = ingresos;
	}

	public String getLugartrabajo() {
		return this.lugartrabajo;
	}

	public void setLugartrabajo(String lugartrabajo) {
		this.lugartrabajo = lugartrabajo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNrodocconyuge() {
		return this.nrodocconyuge;
	}

	public void setNrodocconyuge(String nrodocconyuge) {
		this.nrodocconyuge = nrodocconyuge;
	}

	public String getNrodocumento() {
		return this.nrodocumento;
	}

	public void setNrodocumento(String nrodocumento) {
		this.nrodocumento = nrodocumento;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getOcupacionconyuge() {
		return this.ocupacionconyuge;
	}

	public void setOcupacionconyuge(String ocupacionconyuge) {
		this.ocupacionconyuge = ocupacionconyuge;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getTipodocconyuge() {
		return this.tipodocconyuge;
	}

	public void setTipodocconyuge(int tipodocconyuge) {
		this.tipodocconyuge = tipodocconyuge;
	}

	public Tipodocumento getTipodocumento() {
		return this.tipodocumento;
	}

	public void setTipodocumento(Tipodocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public Pai getPai() {
		return this.pai;
	}

	public void setPai(Pai pai) {
		this.pai = pai;
	}

	public Estadocivil getEstadocivil() {
		return this.estadocivil;
	}

	public void setEstadocivil(Estadocivil estadocivil) {
		this.estadocivil = estadocivil;
	}

	public List<Venta> getVentas1() {
		return this.ventas1;
	}

	public void setVentas1(List<Venta> ventas1) {
		this.ventas1 = ventas1;
	}

	public Venta addVentas1(Venta ventas1) {
		getVentas1().add(ventas1);
		ventas1.setCliente1(this);

		return ventas1;
	}

	public Venta removeVentas1(Venta ventas1) {
		getVentas1().remove(ventas1);
		ventas1.setCliente1(null);

		return ventas1;
	}

	public List<Venta> getVentas2() {
		return this.ventas2;
	}

	public void setVentas2(List<Venta> ventas2) {
		this.ventas2 = ventas2;
	}

	public Venta addVentas2(Venta ventas2) {
		getVentas2().add(ventas2);
		ventas2.setCliente2(this);

		return ventas2;
	}

	public Venta removeVentas2(Venta ventas2) {
		getVentas2().remove(ventas2);
		ventas2.setCliente2(null);

		return ventas2;
	}

}