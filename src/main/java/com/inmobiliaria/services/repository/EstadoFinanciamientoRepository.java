/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.EstadoFinanciamiento;
@Repository
public interface EstadoFinanciamientoRepository extends JpaRepository<EstadoFinanciamiento, Integer> { 
}