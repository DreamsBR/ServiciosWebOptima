package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inmobiliaria.services.model.RangoPeriodo;

public interface RangoPeriodoRepository extends JpaRepository<RangoPeriodo, Integer> {
	@Query("select a from RangoPeriodo a INNER JOIN a.rango b where b.idRango = ?1")
	List<RangoPeriodo> findByIdRango(Integer idRango);

}
