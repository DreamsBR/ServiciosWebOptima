/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
	@Query(
			  value = "SELECT p.* "
			  		+ "FROM proyecto p "
			  		+ "INNER JOIN gerencia_proyecto jp "
			  		+ "ON jp.id_proyecto = j.id_proyecto "
			  		+ "WHERE jp.id_gerencia = ?1", 
			  nativeQuery = true)
	List<Venta> findByIdProyecto(Integer idProyecto);
}