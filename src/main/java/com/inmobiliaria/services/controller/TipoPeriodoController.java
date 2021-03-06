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

import com.inmobiliaria.services.model.TipoPeriodo;
import com.inmobiliaria.services.services.TipoPeriodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value = "/v1/tipoperiodo")
@Api(value = "TipoPeriodo", produces = "application/json", tags = { "Controlador Tipo Periodo" })
@PreAuthorize("isAuthenticated()") 
public class TipoPeriodoController {
	@Autowired
	private TipoPeriodoService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Tipo Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoPeriodo.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<TipoPeriodo> registrar(@RequestBody TipoPeriodo reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Tipo Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoPeriodo.class)
	})
	public ResponseEntity<TipoPeriodo> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Tipo Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoPeriodo.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<TipoPeriodo> modificar(@RequestBody TipoPeriodo reg, @PathVariable Integer id) {
		TipoPeriodo entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdTipoPeriodo(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Tipo Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoPeriodo.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<TipoPeriodo> eliminar(@PathVariable Integer id) {
		TipoPeriodo entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Tipo Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoPeriodo.class)
	})
	public List<TipoPeriodo> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}/{count}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Tipo Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoPeriodo.class)
	})
	public Page<TipoPeriodo> findAll(@PathVariable Integer page, @PathVariable Integer count) {
		Pageable paginacion = PageRequest.of(page, count);
		return this.service.findAll(paginacion);
	}

}