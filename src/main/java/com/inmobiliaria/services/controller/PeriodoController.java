package com.inmobiliaria.services.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.inmobiliaria.services.model.Periodo;
import com.inmobiliaria.services.services.PeriodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1/periodo")
@Api(value = "Periodo", produces = "application/json", tags = { "Controlador Periodo" })
@PreAuthorize("isAuthenticated()") 
public class PeriodoController {
	@Autowired
	private PeriodoService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Periodo.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Periodo> registrar(@RequestBody Periodo reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Periodo.class)
	})
	public ResponseEntity<Periodo> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Periodo.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Periodo> modificar(@RequestBody Periodo reg, @PathVariable Integer id) {
		Periodo entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdPeriodo(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Periodo.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Periodo> eliminar(@PathVariable Integer id) {
		Periodo entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Periodo.class)
	})
	public List<Periodo> findAll() {
		return this.service.findAll().stream().filter(x -> x.getEnable() == 1).collect(Collectors.toList());
	}

	@GetMapping("/page/{page}/{count}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Periodo.class)
	})
	public Page<Periodo> findAll(@PathVariable Integer page, @PathVariable Integer count) {
		Pageable paginacion = PageRequest.of(page, count);
		return this.service.findAll(paginacion);
	}
	@GetMapping("/byanio/{anio}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Periodo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Periodo.class)
	})
	public List<Periodo> byanio(@PathVariable Integer anio) {
		return this.service.findByAnio(anio).stream().filter(x -> x.getEnable() == 1).collect(Collectors.toList());
	}
}
