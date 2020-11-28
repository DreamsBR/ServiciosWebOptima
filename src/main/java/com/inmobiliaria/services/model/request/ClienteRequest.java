package com.inmobiliaria.services.model.request;

import java.math.BigDecimal;
import java.util.Date;

public class ClienteRequest {
	private int idCliente;

	private String apellidos;

	private String asesor;

	private String conyuge;

	private String direccion;

	private String distrito;

	private String email;

	private Date fechaNacimiento;

	private int idEstadoCivil;

	private int idEstadoCivilConyuge;

	private int idPais;

	private int idTipoDocumento;

	private BigDecimal ingresos;

	private String lugarTrabajo;

	private String nombres;

	private String nroDocumentoConyuge;

	private String nroDocumento;

	private String ocupacion;

	private String ocupacionConyuge;

	private String provincia;

	private String sexo;

	private String telefono;

	private int idTipoDocumentoConyuge;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getAsesor() {
		return asesor;
	}

	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	public String getConyuge() {
		return conyuge;
	}

	public void setConyuge(String conyuge) {
		this.conyuge = conyuge;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getIdEstadoCivil() {
		return idEstadoCivil;
	}

	public void setIdEstadoCivil(int idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}

	public int getIdEstadoCivilConyuge() {
		return idEstadoCivilConyuge;
	}

	public void setIdEstadoCivilConyuge(int idEstadoCivilConyuge) {
		this.idEstadoCivilConyuge = idEstadoCivilConyuge;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public BigDecimal getIngresos() {
		return ingresos;
	}

	public void setIngresos(BigDecimal ingresos) {
		this.ingresos = ingresos;
	}

	public String getLugarTrabajo() {
		return lugarTrabajo;
	}

	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNroDocumentoConyuge() {
		return nroDocumentoConyuge;
	}

	public void setNroDocumentoConyuge(String nroDocumentoConyuge) {
		this.nroDocumentoConyuge = nroDocumentoConyuge;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getOcupacionConyuge() {
		return ocupacionConyuge;
	}

	public void setOcupacionConyuge(String ocupacionConyuge) {
		this.ocupacionConyuge = ocupacionConyuge;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getIdTipoDocumentoConyuge() {
		return idTipoDocumentoConyuge;
	}

	public void setIdTipoDocumentoConyuge(int idTipoDocumentoConyuge) {
		this.idTipoDocumentoConyuge = idTipoDocumentoConyuge;
	}
}
