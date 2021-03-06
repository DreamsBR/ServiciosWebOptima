/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.Jefatura;
@Repository
public interface JefaturaRepository extends JpaRepository<Jefatura, Integer> { 
	List<Jefatura> findByIdGerencia(Integer idGerencia);
}