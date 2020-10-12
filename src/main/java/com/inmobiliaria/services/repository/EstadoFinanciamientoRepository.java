/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobiliaria.services.modelv1.EstadoFinanciamiento;

public interface EstadoFinanciamientoRepository extends JpaRepository<EstadoFinanciamiento, Integer> { 
}