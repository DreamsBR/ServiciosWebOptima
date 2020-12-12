package com.inmobiliaria.services.model.request;


public class VentaFilesRequest {
	private int idVentaFiles;
	
	private int idVenta;
	
	private int idEstadoVenta;
	
	private String fileRuta;

	public int getIdVentaFiles() {
		return idVentaFiles;
	}

	public void setIdVentaFiles(int idVentaFiles) {
		this.idVentaFiles = idVentaFiles;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getIdEstadoVenta() {
		return idEstadoVenta;
	}

	public void setIdEstadoVenta(int idEstadoVenta) {
		this.idEstadoVenta = idEstadoVenta;
	}

	public String getFileRuta() {
		return fileRuta;
	}

	public void setFileRuta(String fileRuta) {
		this.fileRuta = fileRuta;
	}
	
}
