package com.inmobiliaria.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.PeriodoProyecto;
@Repository
public interface PeriodoProyectoRepository extends JpaRepository<PeriodoProyecto, Integer> {

}
