/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.Gerencia;
@Repository
public interface GerenciaRepository extends JpaRepository<Gerencia, Integer> {
	
	@Query("select a from Gerencia a INNER JOIN a.colaborador b where b.idColaborador = ?1")
	List<Gerencia> findByIdColaborador(Integer idColaborador);

	@Query("select a from Gerencia a where a.enable = 1")
	Page<Gerencia> findAllEnable(Pageable paginacion); 

}