package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobiliaria.services.model.GerenciaProyecto;

public interface GerenciaProyectoRepository extends JpaRepository<GerenciaProyecto, Integer> {

	List<GerenciaProyecto> findByIdProyecto(Integer idProyecto);

	List<GerenciaProyecto> findByIdGerencia(Integer idGerencia);
}
