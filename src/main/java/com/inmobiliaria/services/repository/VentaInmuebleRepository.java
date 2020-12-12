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
@Repository
public interface VentaInmuebleRepository extends JpaRepository<VentaInmueble, Integer> {
	
	List<VentaInmueble> findByIdVenta(Integer idVenta);

	@Query("select v from VentaInmueble v INNER JOIN v.inmueble e where e.idInmueble = ?1")
	List<VentaInmueble> findByIdInmueble(Integer idInmueble);

}