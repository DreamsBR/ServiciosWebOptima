/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inmobiliaria.services.model.Inmueble;

public interface InmuebleRepository extends JpaRepository<Inmueble, Integer> { 
}