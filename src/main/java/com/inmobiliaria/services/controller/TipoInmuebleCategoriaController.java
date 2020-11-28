package com.inmobiliaria.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmobiliaria.services.model.TipoInmuebleCategoria;
import com.inmobiliaria.services.services.TipoInmuebleCategoriaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping(value = "/v1/tipoinmueblecategoria")
@Api(value = "TipoInmuebleCategoria", produces = "application/json", tags = { "Controlador Tipo Inmueble Categoria" })
public class TipoInmuebleCategoriaController {
	@Autowired
	private TipoInmuebleCategoriaService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Periodo Colaborador" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoInmuebleCategoria.class)
	})
	public ResponseEntity<TipoInmuebleCategoria> registrar(@RequestBody TipoInmuebleCategoria reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Periodo Colaborador" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoInmuebleCategoria.class)
	})
	public ResponseEntity<TipoInmuebleCategoria> obtener(@PathVariable Integer id) {
		return new ResponseEntity<TipoInmuebleCategoria>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Periodo Colaborador" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoInmuebleCategoria.class)
	})
	public ResponseEntity<TipoInmuebleCategoria> modificar(@RequestBody TipoInmuebleCategoria reg, @PathVariable Integer id) {
		TipoInmuebleCategoria entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdTipoInmuebleCategoria(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Periodo Colaborador" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoInmuebleCategoria.class)
	})
	public ResponseEntity<TipoInmuebleCategoria> eliminar(@PathVariable Integer id) {
		TipoInmuebleCategoria entity = this.service.findById(id);
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
		@ApiResponse(code = 200, message = "OK", response = TipoInmuebleCategoria.class)
	})
	public List<TipoInmuebleCategoria> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/tipoInmueble/{idTipoInmueble}")
	@ApiOperation(value = "Listar registros por tipo inmieble", tags = { "Controlador Periodo Colaborador" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoInmuebleCategoria.class)
	})
	public List<TipoInmuebleCategoria> findTipoInmueble(@PathVariable Integer idTipoInmueble) {
		return this.service.findTipoInmueble(idTipoInmueble);
	}

	@GetMapping("/page/{page}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Periodo Colaborador" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoInmuebleCategoria.class)
	})
	public Page<TipoInmuebleCategoria> findAll(@PathVariable Integer page) {
		Pageable paginacion = PageRequest.of(page, 5);
		return this.service.findAll(paginacion);
	}
}
