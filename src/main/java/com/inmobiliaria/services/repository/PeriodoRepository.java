package com.inmobiliaria.services.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.Periodo;
@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Integer>{

	Collection<Periodo> findByIdTipoPeriodo(Integer idTipoPeriodo);

	@Query("select a from Periodo a where a.enable = 1")
	Page<Periodo> findAllEnable(Pageable paginacion);

}
