/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.Vendedor;
@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

	List<Vendedor> findByIdJefatura(Integer idJefatura);

	List<Vendedor> findByIdColaborador(Integer idColaborador); 
}