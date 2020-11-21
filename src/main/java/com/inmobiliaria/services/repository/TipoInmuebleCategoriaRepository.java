package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.TipoInmuebleCategoria;
@Repository
public interface TipoInmuebleCategoriaRepository extends JpaRepository<TipoInmuebleCategoria, Integer> {

	List<TipoInmuebleCategoria> findByIdTipoInmueble(Integer idTipoInmueble);

}
