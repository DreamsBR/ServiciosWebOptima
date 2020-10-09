package com.inmobiliaria.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobiliaria.services.model.Banco;

public interface BancoRepository extends JpaRepository<Banco, Integer> {

}
