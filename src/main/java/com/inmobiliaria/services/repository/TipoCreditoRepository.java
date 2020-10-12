/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobiliaria.services.modelv1.TipoCredito;

public interface TipoCreditoRepository extends JpaRepository<TipoCredito, Integer> { 
}