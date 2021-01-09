package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inmobiliaria.services.model.Rango;

public interface RangoRepository extends JpaRepository<Rango, Integer> {
	@Query("select a from Rango a INNER JOIN a.tipoPeriodo b where b.idTipoPeriodo = ?1")
	List<Rango> findByIdTipoPeriodo(Integer idTipoPeriodo);

	List<Rango> findByAnio(Integer anio);

	@Query("select a from Rango a INNER JOIN a.tipoPeriodo b where a.anio =?1 and b.idTipoPeriodo = ?2 ")
	List<Rango> findByAnioAndIdTipoPeriodo(Integer anio, Integer idTipoPeriodo);

}
