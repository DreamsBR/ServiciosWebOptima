package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobiliaria.services.model.VentaAttached;

public interface VentaAttachedRepository extends JpaRepository<VentaAttached, Integer> {
	List<VentaAttached> findByIdVenta(Integer idVenta);
}
