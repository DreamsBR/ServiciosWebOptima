package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inmobiliaria.services.model.GerenciaProyecto;

public interface GerenciaProyectoRepository extends JpaRepository<GerenciaProyecto, Integer> {

	@Query("select a from GerenciaProyecto a INNER JOIN a.proyecto b where b.idProyecto = ?1")
	List<GerenciaProyecto> findByIdProyecto(Integer idProyecto);

	@Query("select a from GerenciaProyecto a INNER JOIN a.gerencia b where b.idGerencia = ?1")
	List<GerenciaProyecto> findByIdGerencia(Integer idGerencia);
}
