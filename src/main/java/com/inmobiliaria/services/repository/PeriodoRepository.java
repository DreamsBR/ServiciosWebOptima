package com.inmobiliaria.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.Periodo;
@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Integer>{

}
