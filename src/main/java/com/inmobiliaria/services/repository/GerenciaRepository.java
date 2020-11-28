/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inmobiliaria.services.model.Gerencia;
import com.inmobiliaria.services.model.response.ListGerenciaResponse;
@Repository
public interface GerenciaRepository extends JpaRepository<Gerencia, Integer> { 
	@Query(
			  value = "SELECT "
			  		+ "g.id_gerencia	idGerencia, "
			  		+ "g.nombre, "
			  		+ "g.id_gerente	idGerente, "
			  		+ "c.nombres nombreGerente, "
			  		+ "c.apellidos apellidosGerente, "
			  		+ "g.fecha_ingreso fechaIngreso, "
			  		+ "g.enable"
			  		+ "FROM gerencia g "
			  		+ "INNER JOIN colaborador c "
			  		+ "ON c.id_colaborador = g.id_gerente ", 
			  nativeQuery = true)
	List<ListGerenciaResponse> listGerencia();
}