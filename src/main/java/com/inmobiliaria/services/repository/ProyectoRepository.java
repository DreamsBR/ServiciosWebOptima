/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.Proyecto;
import com.inmobiliaria.services.model.response.VentaInmuebleProyectoResponse;
@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> { 
	@Query(
			  value = "SELECT p.* "
			  		+ "FROM proyecto p "
			  		+ "INNER JOIN jefatura_proyecto jp "
			  		+ "ON jp.id_proyecto = j.id_proyecto "
			  		+ "WHERE jp.id_jefatura = ?1", 
			  nativeQuery = true)
	List<Proyecto> findByJefatura(Integer idJefatura);

	@Query(
			  value = "SELECT p.* "
			  		+ "FROM proyecto p "
			  		+ "INNER JOIN gerencia_proyecto jp "
			  		+ "ON jp.id_proyecto = j.id_proyecto "
			  		+ "WHERE jp.id_gerencia = ?1", 
			  nativeQuery = true)
	List<Proyecto> findByIdGerencia(Integer idGerencia);

	@Query(
			  value = "SELECT" + 
			  		"	c.id_cliente		idCliente, " + 
			  		"	c.nombres, " + 
			  		"	c.apellidos, " + 
			  		"	td.nombre		tipoDocumento," + 
			  		"	c.nro_documento		nroDocumento," + 
			  		"	v.id_venta		idVenta, " + 
			  		"	vi.importe, " + 
			  		"	ev.nombre		estado," + 
			  		"	i.id_inmueble		idInmueble, " + 
			  		"	ti.nombre		tipoInmueble, " + 
			  		"	i.numero		" + 
			  		"FROM inmueble i" + 
			  		"	INNER JOIN tipo_inmueble ti ON ti.id_tipo_inmueble = i.id_tipo_inmueble" + 
			  		"	INNER JOIN venta_inmueble vi ON i.id_inmueble = vi.id_inmueble" + 
			  		"	INNER JOIN venta v ON vi.id_venta = v.id_venta" + 
			  		"	INNER JOIN cliente c ON v.id_cliente = c.id_cliente" + 
			  		"	INNER JOIN estado_venta ev ON ev.id_estado_venta = v.id_estado_venta" + 
			  		"	INNER JOIN tipo_documento td ON td.id_tipo_documento = c.id_tipo_documento " + 
			  		"WHERE i.id_proyecto = ?1", 
			  nativeQuery = true)
	List<VentaInmuebleProyectoResponse> findVentasByIdProyecto(Integer idProyecto);
}