package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.PeriodoProyecto;
@Repository
public interface PeriodoProyectoRepository extends JpaRepository<PeriodoProyecto, Integer> {
	
	@Query("select v from PeriodoProyecto v INNER JOIN v.periodo e where e.idPeriodo = ?1")
	List<PeriodoProyecto> findByIdPeriodo(Integer idPeriodo);

	@Query("select v from PeriodoProyecto v INNER JOIN v.proyecto e where e.idProyecto = ?1")
	List<PeriodoProyecto> findByIdProyecto(Integer idProyecto);

}
