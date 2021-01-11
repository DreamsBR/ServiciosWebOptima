package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.PeriodoGerencia;
@Repository
public interface PeriodoGerenciaRepository extends JpaRepository<PeriodoGerencia, Integer> {
	
	List<PeriodoGerencia> findByIdGerencia(Integer idGerencia);
	
	@Query("select a from PeriodoGerencia a INNER JOIN a.periodo b where b.idPeriodo = ?1")
	List<PeriodoGerencia> findByIdPeriodo(Integer idPeriodo);
}
