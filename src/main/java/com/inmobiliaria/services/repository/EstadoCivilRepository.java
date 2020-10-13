/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobiliaria.services.model.EstadoCivil;

public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Integer> { 
}