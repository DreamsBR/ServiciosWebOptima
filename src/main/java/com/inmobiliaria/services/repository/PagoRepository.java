/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.Pago;
@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
	
	@Query("select v from Pago v INNER JOIN v.venta e where e.idVenta = ?1")
	List<Pago> findByIdVenta(Integer idVenta);
}