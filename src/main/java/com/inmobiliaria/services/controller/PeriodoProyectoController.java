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

import com.inmobiliaria.services.model.PeriodoProyecto;
import com.inmobiliaria.services.model.request.PeriodoProyectoRequest;
import com.inmobiliaria.services.services.PeriodoProyectoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping(value = "/v1/periodoproyecto")
@Api(value = "PeriodoProyecto", produces = "application/json", tags = { "Controlador Periodo Proyecto" })
@PreAuthorize("isAuthenticated()") 
public class PeriodoProyectoController {
	@Autowired
	private PeriodoProyectoService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Periodo Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoProyecto.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<PeriodoProyecto> registrar(@RequestBody PeriodoProyectoRequest reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Periodo Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoProyecto.class)
	})
	public ResponseEntity<PeriodoProyecto> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Periodo Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoProyecto.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<PeriodoProyecto> modificar(@RequestBody PeriodoProyectoRequest reg, @PathVariable Integer id) {
		PeriodoProyecto entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdPeriodoProyecto(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Periodo Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoProyecto.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<PeriodoProyecto> eliminar(@PathVariable Integer id) {
		PeriodoProyecto entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Periodo Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoProyecto.class)
	})
	public List<PeriodoProyecto> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Periodo Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoProyecto.class)
	})
	public Page<PeriodoProyecto> findAll(@PathVariable Integer page) {
		Pageable paginacion = PageRequest.of(page, 5);
		return this.service.findAll(paginacion);
	}
	
	@GetMapping("/porProyecto/{idProyecto}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Periodo Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoProyecto.class)
	})
	public List<PeriodoProyecto> porProyecto(@PathVariable Integer idProyecto) {
		return this.service.findByIdProyecto(idProyecto);
	}
	@GetMapping("/porPeriodo/{idPeriodo}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Periodo Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoProyecto.class)
	})
	public List<PeriodoProyecto> porPeriodo(@PathVariable Integer idPeriodo) {
		return this.service.findByIdPeriodo(idPeriodo);
	}
	
}
