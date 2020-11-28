/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.Inmueble;
@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble, Integer> {

	@Query("select v from Inmueble v INNER JOIN v.tipoInmueble ti where v.idProyecto = ?1 and ti.idTipoInmueble = ?2 and v.numero = ?3")
	Inmueble findByIdProyectoAndIdTipoInmuebleAndNumero(Integer idProyecto, Integer idTipoInmueble, String numero);

	@Query("select v from Inmueble v INNER JOIN v.tipoInmueble ti INNER JOIN v.tipoInmuebleCategoria tic where v.idProyecto = ?1 and ti.idTipoInmueble = ?2 and  tic.idTipoInmuebleCategoria = ?3")
	List<Inmueble> findByIdProyectoAndIdTipoInmuebleAndIdTipoInmuebleCategoria(Integer idProyecto,
			Integer idTipoInmueble, Integer idTipoInmuebleCategoria);

	List<Inmueble> findByIdProyecto(Integer idProyecto); 
	
}