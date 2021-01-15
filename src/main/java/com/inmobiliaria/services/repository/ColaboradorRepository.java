package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inmobiliaria.services.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>{
	List<Colaborador> findByNumeroDocumento(String numeroDocumento);

	@Query("select a from Colaborador a where a.enable = 1")
	Page<Colaborador> findAllEnable(Pageable paginacion);
}
