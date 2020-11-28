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
@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

	Page<Venta> findByIdProyecto(Integer idProyecto, Pageable pageable);
	List<Venta> findByIdProyecto(Integer idProyecto);
	
	@Query("select v from Venta v INNER JOIN v.estadoVenta e where v.idProyecto = ?1 and e.idEstadoVenta = ?2")
	List<Venta> findByIdProyectoAndIdEstadoVenta(Integer idProyecto, Integer idEstadoVenta);
	
	@Query("select v from Venta v INNER JOIN v.cliente e where e.idCliente = ?1")
	Page<Venta> findByCliente(Integer idCliente, Pageable pageable);

}