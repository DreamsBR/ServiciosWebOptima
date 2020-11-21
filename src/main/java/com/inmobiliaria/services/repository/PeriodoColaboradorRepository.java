package com.inmobiliaria.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.PeriodoColaborador;
@Repository
public interface PeriodoColaboradorRepository extends JpaRepository<PeriodoColaborador, Integer>{

}
