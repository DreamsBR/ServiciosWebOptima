/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.Inmueble;
@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble, Integer> {

	Inmueble findByIdProyectoAndIdTipoInmuebleAndNumero(Integer idProyecto, Integer idTipoInmueble, String numero);

	List<Inmueble> findByIdProyectoAndIdTipoInmuebleAndIdTipoInmuebleCategoria(Integer idProyecto,
			Integer idTipoInmueble, Integer idTipoInmuebleCategoria);

	List<Inmueble> findByIdProyecto(Integer idProyecto); 
}