package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobiliaria.services.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>{
	List<Colaborador> findByNumeroDocumento(String numeroDocumento);
}
