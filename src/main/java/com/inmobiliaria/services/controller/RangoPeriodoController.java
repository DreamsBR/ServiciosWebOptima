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

import com.inmobiliaria.services.model.RangoPeriodo;
import com.inmobiliaria.services.services.RangoPeriodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1/rangoperiodo")
@Api(value = "RangoPeriodo", produces = "application/json", tags = { "Controlador Rango Periodo" })
@PreAuthorize("isAuthenticated()") 
public class RangoPeriodoController {
	@Autowired
	private RangoPeriodoService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Rango Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = RangoPeriodo.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<RangoPeriodo> registrar(@RequestBody RangoPeriodo reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Rango Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = RangoPeriodo.class)
	})
	public ResponseEntity<RangoPeriodo> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Rango Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = RangoPeriodo.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<RangoPeriodo> modificar(@RequestBody RangoPeriodo reg, @PathVariable Integer id) {
		RangoPeriodo entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdRangoPeriodo(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Rango Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = RangoPeriodo.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<RangoPeriodo> eliminar(@PathVariable Integer id) {
		RangoPeriodo entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Rango Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = RangoPeriodo.class)
	})
	public List<RangoPeriodo> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}/{count}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Rango Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = RangoPeriodo.class)
	})
	public Page<RangoPeriodo> findAll(@PathVariable Integer page, @PathVariable Integer count) {
		Pageable paginacion = PageRequest.of(page, count);
		return this.service.findAll(paginacion);
	}
	@GetMapping("/byrango/{idRango}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Rango Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = RangoPeriodo.class)
	})
	public List<RangoPeriodo> byrango(@PathVariable Integer idRango) {
		return this.service.findByIdRango(idRango);
	}

}