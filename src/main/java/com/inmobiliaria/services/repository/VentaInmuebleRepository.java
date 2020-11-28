/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.VentaInmueble;
import com.inmobiliaria.services.model.response.VentaInmuebleProyectoDetalleResponse;
@Repository
public interface VentaInmuebleRepository extends JpaRepository<VentaInmueble, Integer> {
	@Query(
			  value = "SELECT "
						+ "	v.id_venta_inmueble		idVentaInmueble, "
						+ "	tic.nombre				tipo, "
						+ " i.idInmueble, "
						+ "	i.numero, "
						+ "	v.area_techada		areaTechada,"
						+ "	v.area_libre		areaLibre,"
						+ "	v.area_total		areaTotal, "
						+ "	v.vista, "
						+ "	v.precio, "
						+ "	v.dormitorios	"
			  		+ "FROM venta_inmueble v "
			  		+ " INNER JOIN inmueble i ON i.id_inmueble = v.id_inmueble "
			  		+ "	INNER JOIN tipo_inmueble ti ON ti.id_tipo_inmueble = i.id_tipo_inmueble"
			  		+ "	LEFT JOIN tipo_inmueble_categoria tic ON ti.id_tipo_inmueble_categoria = tic.id_tipo_inmueble_categoria"
			  		+ "WHERE v.id_venta = ?1", 
			  nativeQuery = true)
	List<VentaInmuebleProyectoDetalleResponse> findByVenta(Integer idVenta); 
	
	List<VentaInmueble> findByIdVenta(Integer idVenta);

	@Query("select v from VentaInmueble v INNER JOIN v.inmueble e where e.idInmueble = ?1")
	List<VentaInmueble> findByIdInmueble(Integer idInmueble);

}