package com.inmobiliaria.services.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cliente")
	private int idCliente;

	private String asesor;

	private String conyuge;

	private String direccion;

	private String distrito;

	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="id_estado_civil")
	private int idEstadoCivil;

	@Column(name="id_pais")
	private int idPais;

	@Column(name="id_tipo_documento")
	private int idTipoDocumento;

	private int idestadocivilconyuge;

	private BigDecimal ingresos;

	@Column(name="lugar_trabajo")
	private String lugarTrabajo;

	private String nombre;

	@Column(name="nro_doc_conyuge")
	private String nroDocConyuge;

	@Column(name="nro_documento")
	private String nroDocumento;

	private String ocupacion;

	@Column(name="ocupacion_conyuge")
	private String ocupacionConyuge;

	private String provincia;

	private String sexo;

	private String telefono;

	@Column(name="tipo_doc_conyuge")
	private int tipoDocConyuge;

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getIdEstadoCivil() {
		return this.idEstadoCivil;
	}

	public void setIdEstadoCivil(int idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}

	public int getIdPais() {
		return this.idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public int getIdTipoDocumento() {
		return this.idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
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

	public String getLugarTrabajo() {
		return this.lugarTrabajo;
	}

	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNroDocConyuge() {
		return this.nroDocConyuge;
	}

	public void setNroDocConyuge(String nroDocConyuge) {
		this.nroDocConyuge = nroDocConyuge;
	}

	public String getNroDocumento() {
		return this.nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getOcupacionConyuge() {
		return this.ocupacionConyuge;
	}

	public void setOcupacionConyuge(String ocupacionConyuge) {
		this.ocupacionConyuge = ocupacionConyuge;
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

	public int getTipoDocConyuge() {
		return this.tipoDocConyuge;
	}

	public void setTipoDocConyuge(int tipoDocConyuge) {
		this.tipoDocConyuge = tipoDocConyuge;
	}

}