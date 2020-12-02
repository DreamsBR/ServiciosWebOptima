/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.inmobiliaria.services.services.ProyectoService;
import com.inmobiliaria.services.model.Proyecto;
import com.inmobiliaria.services.model.response.ProyectoResponse;

@RestController
@RequestMapping(value = "/v1/proyecto")
@Api(value = "Proyecto", produces = "application/json", tags = { "Controlador Proyecto" })
@PreAuthorize("isAuthenticated()") 
public class ProyectoController {
	@Autowired
	private ProyectoService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Proyecto.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Proyecto> registrar(@RequestBody Proyecto reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = ProyectoResponse.class)
	})
	public ResponseEntity<ProyectoResponse> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findInfoProyecto(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Proyecto.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Proyecto> modificar(@RequestBody Proyecto reg, @PathVariable Integer id) {
		Proyecto entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdProyecto(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Proyecto.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Proyecto> eliminar(@PathVariable Integer id) {
		Proyecto entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Proyecto.class)
	})
	public List<Proyecto> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}/{count}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Proyecto.class)
	})
	public Page<Proyecto> findAll(@PathVariable Integer page, @PathVariable Integer count) {
		Pageable paginacion = PageRequest.of(page, count);
		return this.service.findAll(paginacion);
	}
	
	@GetMapping("/porGerencia/{idGerencia}")
	@ApiOperation(value = "Listar por gerencia", tags = { "Controlador Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Proyecto.class)
	})
	public List<Proyecto> findByIdGerencia(@PathVariable Integer idGerencia) {
		return this.service.findByIdGerencia(idGerencia);
	}
	
	
}