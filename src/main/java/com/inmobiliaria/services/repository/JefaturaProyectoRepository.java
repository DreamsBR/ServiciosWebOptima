/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.JefaturaProyecto;
@Repository
public interface JefaturaProyectoRepository extends JpaRepository<JefaturaProyecto, Integer> {

	@Query("select a from JefaturaProyecto a INNER JOIN a.proyecto b where b.idProyecto = ?1")
	List<JefaturaProyecto> findByIdProyecto(Integer idProyecto);

	@Query("select a from JefaturaProyecto a INNER JOIN a.jefatura b where b.idJefatura = ?1")
	List<JefaturaProyecto> findByIdJefatura(Integer idJefatura);
}