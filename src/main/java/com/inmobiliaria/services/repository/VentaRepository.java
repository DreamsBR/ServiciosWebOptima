/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.Venta;
import com.inmobiliaria.services.model.response.VentaInmuebleProyectoResponse;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {


	@Query(
			  value = "SELECT "
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
			  		+ " WHERE v.id_proyecto = ?1 AND v.enable = 1", 
			  nativeQuery = true)
	Page<VentaInmuebleProyectoResponse> findByProyecto(Integer idProyecto, Pageable pageable);
	
	
	@Query(
			  value = "SELECT "
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
			  		+ " WHERE v.id_proyecto = ?1 and ev.id_estado_venta = ?2 AND v.enable = 1", 
			  nativeQuery = true)
	List<VentaInmuebleProyectoResponse> findByProyectoAndEstado(Integer idProyecto, Integer idEstadoVenta);


	Page<Venta> findByIdProyecto(Integer idProyecto, Pageable pageable);
	
}