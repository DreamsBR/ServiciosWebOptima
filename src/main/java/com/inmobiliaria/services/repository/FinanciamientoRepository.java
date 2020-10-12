/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inmobiliaria.services.model.Financiamiento;

public interface FinanciamientoRepository extends JpaRepository<Financiamiento, Integer> { 
}