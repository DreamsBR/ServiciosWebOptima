/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.repository.VentaRepository; 
import com.inmobiliaria.services.model.Venta;
import com.inmobiliaria.services.model.response.VentaInmuebleProyectoResponse;

@Service
@Transactional(readOnly=true)
public class VentaService {
	@Autowired
	private VentaRepository reporsitory;
	
	@Autowired
	EntityManager em;
	
	@Transactional
	public Venta registrar(Venta reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Venta reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Venta update(Venta reg) {
		return reporsitory.save(reg);
	}
	public Venta findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Venta> findAll() {
		return reporsitory.findAll();
	}
	public Page<Venta> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public List<VentaInmuebleProyectoResponse> findByProyecto(Integer idProyecto) {
		List<VentaInmuebleProyectoResponse> response = new ArrayList<>();
		String nativeQuery = "SELECT "
		  		+ "	c.id_cliente		idCliente, " 
		  		+ "	c.nombres, "
		  		+ "	c.apellidos, "
		  		+ "	td.nombre		tipoDocumento,"
		  		+ "	c.nro_documento		nroDocumento,"
		  		+ "	v.id_venta		idVenta, "
		  		+ "	v.importe, "
		  		+ " v.fecha_separacion	fechaSeparacion, "
		  		+ " v.fecha_minuta		fechaMinuta, "
		  		+ " v.fecha_desembolso	fechaDesembolso, "
		  		+ " v.fecha_epp			fechaEpp, "
		  		+ " v.fecha_caida		fechaCaida, "
		  		+ "	ev.nombre		estado "
	  		+ " FROM venta v "
	  		+ " INNER JOIN cliente c ON c.id_cliente = v.id_cliente "
	  		+ "	INNER JOIN estado_venta ev ON ev.id_estado_venta = v.id_estado_venta"
	  		+ "	INNER JOIN tipo_documento td ON td.id_tipo_documento = c.id_tipo_documento "
	  		+ " WHERE v.id_proyecto = ? AND v.enable = 1";
	    Query query = em.createNativeQuery(nativeQuery);
	    query.setParameter(1, idProyecto);
		
	    List<Object[]> list= query.getResultList();
	    for (Object[] objects : list) {
	    	response.add(mapperVentaInmuebleProyectoResponse(objects));
		}

	    return response;
	}
	public List<VentaInmuebleProyectoResponse> findByProyectoAndEstadoVenta(Integer idProyecto, Integer idEstadoVenta) {
		
		List<VentaInmuebleProyectoResponse> response = new ArrayList<>();
		String nativeQuery = "SELECT "
		  		+ "	c.id_cliente		idCliente, " 
		  		+ "	c.nombres, "
		  		+ "	c.apellidos, "
		  		+ "	td.nombre		tipoDocumento,"
		  		+ "	c.nro_documento		nroDocumento,"
		  		+ "	v.id_venta		idVenta, "
		  		+ "	v.importe, "
		  		+ " v.fecha_separacion	fechaSeparacion, "
		  		+ " v.fecha_minuta		fechaMinuta, "
		  		+ " v.fecha_desembolso	fechaDesembolso, "
		  		+ " v.fecha_epp			fechaEpp, "
		  		+ " v.fecha_caida		fechaCaida, "
		  		+ "	ev.nombre		estado "
	  		+ " FROM venta v "
	  		+ " INNER JOIN cliente c ON c.id_cliente = v.id_cliente "
	  		+ "	INNER JOIN estado_venta ev ON ev.id_estado_venta = v.id_estado_venta "
	  		+ "	INNER JOIN tipo_documento td ON td.id_tipo_documento = c.id_tipo_documento "
	  		+ " WHERE v.id_proyecto = ? and ev.id_estado_venta = ? AND v.enable = 1";
		
	    Query query = em.createNativeQuery(nativeQuery);
	    query.setParameter(1, idProyecto);
	    query.setParameter(2, idEstadoVenta);
		
	    List<Object[]> list= query.getResultList();
	    for (Object[] objects : list) {
	    	response.add(mapperVentaInmuebleProyectoResponse(objects));
		}

	    return response;

	}
	
	private VentaInmuebleProyectoResponse mapperVentaInmuebleProyectoResponse(Object[] object) {
		VentaInmuebleProyectoResponse response = new VentaInmuebleProyectoResponse();
		response.setIdCliente(Integer.parseInt(object[0].toString()));
		response.setNombres(object[1].toString());
		response.setApellidos(object[2].toString());
		response.setTipoDocumento(object[3].toString());
		response.setNroDocumento(object[4].toString());
		response.setIdVenta(Integer.parseInt(object[5].toString()));
		response.setImporte(new BigDecimal(Integer.parseInt(object[6].toString())));
		response.setFechaSeparacion(object[7].toString());
		response.setFechaMinuta(object[8].toString());
		response.setFechaDesembolso(object[9].toString());
		response.setFechaEpp(object[10].toString());
		response.setFechaCaida(object[11].toString());
		response.setEstado(object[12].toString());
		return response;
	}
	
}