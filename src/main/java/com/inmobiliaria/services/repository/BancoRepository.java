package com.inmobiliaria.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.Banco;
@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {

}
