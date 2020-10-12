/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobiliaria.services.modelv1.TipoVista;

public interface TipoVistaRepository extends JpaRepository<TipoVista, Integer> { 
}