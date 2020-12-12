package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmobiliaria.services.model.VentaFiles;

public interface VentaFilesRepository extends JpaRepository<VentaFiles, Integer>{

	List<VentaFiles> findByIdVenta(Integer idVenta);

}
