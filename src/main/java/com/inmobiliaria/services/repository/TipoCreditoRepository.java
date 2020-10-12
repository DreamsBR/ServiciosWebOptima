/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inmobiliaria.services.model.TipoCredito;

public interface TipoCreditoRepository extends JpaRepository<TipoCredito, Integer> { 
}