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

import com.inmobiliaria.services.model.PeriodoGerencia;
import com.inmobiliaria.services.model.request.PeriodoGerenciaRequest;
import com.inmobiliaria.services.services.PeriodoGerenciaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping(value = "/v1/periodogerencia")
@Api(value = "PeriodoGerencia", produces = "application/json", tags = { "Controlador Periodo Gerencia" })
@PreAuthorize("isAuthenticated()") 
public class PeriodoGerenciaController {
	@Autowired
	private PeriodoGerenciaService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Periodo Gerencia" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoGerenciaRequest.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<PeriodoGerencia> registrar(@RequestBody PeriodoGerenciaRequest reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Periodo Gerencia" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoGerencia.class)
	})
	public ResponseEntity<PeriodoGerencia> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Periodo Gerencia" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoGerenciaRequest.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<PeriodoGerencia> modificar(@RequestBody PeriodoGerenciaRequest reg, @PathVariable Integer id) {
		PeriodoGerencia entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdPeriodoGerencia(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Periodo Gerencia" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoGerencia.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<PeriodoGerencia> eliminar(@PathVariable Integer id) {
		PeriodoGerencia entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Periodo Gerencia" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoGerencia.class)
	})
	public List<PeriodoGerencia> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Periodo Gerencia" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoGerencia.class)
	})
	public Page<PeriodoGerencia> findAll(@PathVariable Integer page) {
		Pageable paginacion = PageRequest.of(page, 5);
		return this.service.findAll(paginacion);
	}
	
	@GetMapping("/listarperiodos/{idGerencia}")
	@ApiOperation(value = "Listar periodos", tags = { "Controlador Gerencia" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = PeriodoGerencia.class)
	})
	public List<PeriodoGerencia> findByIdGerencia(@PathVariable Integer idGerencia) {
		return this.service.findByIdGerencia(idGerencia);
	}
}
