package com.inmobiliaria.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmobiliaria.services.model.GerenciaProyecto;
import com.inmobiliaria.services.model.request.GerenciaProyectoRequest;
import com.inmobiliaria.services.services.GerenciaProyectoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping(value = "/v1/gerenciaproyecto")
@Api(value = "GerenciaProyecto", produces = "application/json", tags = { "Controlador GerenciaProyecto" })
@PreAuthorize("isAuthenticated()") 
public class GerenciaProyectoController {
	@Autowired
	private GerenciaProyectoService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador GerenciaProyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = GerenciaProyecto.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<GerenciaProyecto> registrar(@RequestBody GerenciaProyectoRequest reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador GerenciaProyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = GerenciaProyecto.class)
	})
	public ResponseEntity<GerenciaProyecto> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador GerenciaProyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = GerenciaProyecto.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<GerenciaProyecto> modificar(@RequestBody GerenciaProyectoRequest reg, @PathVariable Integer id) {
		GerenciaProyecto entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdGerenciaProyecto(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador GerenciaProyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = GerenciaProyecto.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<GerenciaProyecto> eliminar(@PathVariable Integer id) {
		GerenciaProyecto entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador GerenciaProyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = GerenciaProyecto.class)
	})
	public List<GerenciaProyecto> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}/{count}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador GerenciaProyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = GerenciaProyecto.class)
	})
	public Page<GerenciaProyecto> findAll(@PathVariable Integer page, @PathVariable Integer count) {
		Pageable paginacion = PageRequest.of(page, count);
		return this.service.findAll(paginacion);
	}
	@GetMapping("/listarproyectos/{idGerencia}")
	@ApiOperation(value = "Listar registros por gerencia", tags = { "Controlador GerenciaProyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = GerenciaProyecto.class)
	})
	public List<GerenciaProyecto> listarproyectos(@PathVariable Integer idGerencia) {
		return this.service.findByIdGerencia(idGerencia);
	}
}
