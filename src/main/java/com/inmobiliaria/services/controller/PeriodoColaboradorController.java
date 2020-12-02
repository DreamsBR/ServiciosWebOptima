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

import com.inmobiliaria.services.model.PeriodoColaborador;
import com.inmobiliaria.services.model.request.PeriodoColaboradorRequest;
import com.inmobiliaria.services.services.PeriodoColaboradorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping(value = "/v1/periodocolaborador")
@Api(value = "PeriodoColaborador", produces = "application/json", tags = { "Controlador Periodo Colaborador" })
@PreAuthorize("isAuthenticated()") 
public class PeriodoColaboradorController {
	@Autowired
	private PeriodoColaboradorService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Periodo Colaborador" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoColaborador.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<PeriodoColaborador> registrar(@RequestBody PeriodoColaboradorRequest reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Periodo Colaborador" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoColaborador.class)
	})
	public ResponseEntity<PeriodoColaborador> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Periodo Colaborador" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoColaborador.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<PeriodoColaborador> modificar(@RequestBody PeriodoColaboradorRequest reg, @PathVariable Integer id) {
		PeriodoColaborador entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdPeriodoColaborador(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Periodo Colaborador" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoColaborador.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<PeriodoColaborador> eliminar(@PathVariable Integer id) {
		PeriodoColaborador entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Periodo Colaborador" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoColaborador.class)
	})
	public List<PeriodoColaborador> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Periodo Colaborador" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoColaborador.class)
	})
	public Page<PeriodoColaborador> findAll(@PathVariable Integer page) {
		Pageable paginacion = PageRequest.of(page, 5);
		return this.service.findAll(paginacion);
	}
	
	@GetMapping("/listarperido/{idColaborador}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Periodo Colaborador" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoColaborador.class)
	})
	public List<PeriodoColaborador> listarperido(@PathVariable Integer idColaborador) {
		return this.service.findByIdColaborador(idColaborador);
	}
}
