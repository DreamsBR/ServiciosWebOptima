/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobiliaria.services.modelv1.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> { 
}