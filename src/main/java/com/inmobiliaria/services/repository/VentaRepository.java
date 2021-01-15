/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;


import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
	@Query("select v from Venta v where v.idProyecto = ?1 and v.enable = 1")
	Page<Venta> findByIdProyecto(Integer idProyecto, Pageable pageable);
	
	@Query("select v from Venta v where v.idProyecto = ?1 and v.enable = 1")
	List<Venta> findByIdProyecto(Integer idProyecto);
	
	@Query("select v from Venta v INNER JOIN v.estadoVenta e where v.idProyecto = ?1 and v.enable =1 and e.idEstadoVenta = ?2")
	List<Venta> findByIdProyectoAndIdEstadoVenta(Integer idProyecto, Integer idEstadoVenta);
	
	@Query("select v from Venta v INNER JOIN v.cliente e where e.idCliente = ?1 and v.enable =1")
	Page<Venta> findByCliente(Integer idCliente, Pageable pageable);
	
	@Query("select v from Venta v INNER JOIN v.vendedor e where e.idVendedor = ?1 and v.enable = 1")
	List<Venta> findByIdVendedor(Integer idVendedor);

	@Query("select v from Venta v where v.idProyecto = :idProyecto and v.enable = 1 AND v.fechaRegistro BETWEEN :startDate AND :endDate")
	List<Venta> findByFechaRegistroRange(@Param("idProyecto") Integer idProyecto, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	@Query("select v from Venta v "
			+ "INNER JOIN v.cliente e "
			+ "INNER JOIN v.estadoVenta ev "
			+ "WHERE v.idProyecto = :idProyecto and v.enable = 1 AND "
			+ "e.idCliente = :idCliente AND "
			+ "ev.idEstadoVenta = :idEstadoVenta AND "
			+ "v.fechaRegistro BETWEEN :startDate AND :endDate")
	List<Venta> search(
			@Param("idProyecto") Integer idProyecto, 
			@Param("idCliente") Integer idCliente, 
			@Param("idEstadoVenta") Integer idEstadoVenta, 
			@Param("startDate") Date startDate, 
			@Param("endDate") Date endDate);
	
	@Query("select v from Venta v INNER JOIN v.cliente e where e.idCliente = ?1 and v.enable = 1")
	Collection<Venta> findByCliente(Integer idCiente);
	
	@Query("select v from Venta v "
			+ "INNER JOIN v.cliente e "
			+ "WHERE v.idProyecto = :idProyecto and v.enable = 1 AND "
			+ "e.idCliente = :idCliente AND "
			+ "v.fechaRegistro BETWEEN :startDate AND :endDate")
	List<Venta> findByProyectoAndClienteAndRangeFechas(
			@Param("idProyecto") Integer idProyecto, 
			@Param("idCliente") Integer idCliente, 
			@Param("startDate") Date startDate, 
			@Param("endDate") Date endDate);
	
	@Query("select v from Venta v "
			+ "INNER JOIN v.cliente e "
			+ "WHERE v.idProyecto = :idProyecto and v.enable = 1  AND"
			+ "e.idCliente = :idCliente ")
	List<Venta> findByProyectoAndCliente(
			@Param("idProyecto") Integer idProyecto, 
			@Param("idCliente") Integer idCliente);
	
	@Query("select v from Venta v "
			+ "INNER JOIN v.cliente e "
			+ "INNER JOIN v.estadoVenta ev "
			+ "WHERE v.idProyecto = :idProyecto and v.enable = 1 AND "
			+ "ev.idEstadoVenta = :idEstadoVenta AND "
			+ "e.idCliente = :idCliente ")
	List<Venta> findByProyectoAndClienteAndEstado(
			@Param("idProyecto") Integer idProyecto, 
			@Param("idCliente") Integer idCliente, 
			@Param("idEstadoVenta") Integer idEstadoVenta);
	
	@Query("select v from Venta v "
			+ "INNER JOIN v.estadoVenta ev "
			+ "WHERE v.idProyecto = :idProyecto and v.enable = 1 AND "
			+ "ev.idEstadoVenta = :idEstadoVenta AND "
			+ "v.fechaRegistro BETWEEN :startDate AND :endDate")
	List<Venta> findByProyectoAndEstadoAndFechas(
			@Param("idProyecto") Integer idProyecto, 
			@Param("idEstadoVenta") Integer idEstadoVenta, 
			@Param("startDate") Date startDate, 
			@Param("endDate") Date endDate);
	
	@Query("select v from Venta v "
			+ "INNER JOIN v.estadoVenta ev "
			+ "WHERE v.idProyecto = :idProyecto and v.enable = 1 AND "
			+ "ev.idEstadoVenta = :idEstadoVenta ")
	List<Venta> findByProyectoAndEstado(
			@Param("idProyecto") Integer idProyecto, 
			@Param("idEstadoVenta") Integer idEstadoVenta);

}