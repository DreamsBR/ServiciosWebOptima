/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.inmobiliaria.services.services.MotivoService;
import com.inmobiliaria.services.model.Motivo;

@RestController
@RequestMapping(value = "/v1/motivo")
@Api(value = "Motivo", produces = "application/json", tags = { "Controlador Motivo" })
public class MotivoController {
	@Autowired
	private MotivoService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Motivo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Motivo.class)
	})
	public ResponseEntity<Motivo> registrar(@RequestBody Motivo reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Motivo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Motivo.class)
	})
	public ResponseEntity<Motivo> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Motivo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Motivo.class)
	})
	public ResponseEntity<Motivo> modificar(@RequestBody Motivo reg, @PathVariable Integer id) {
		Motivo entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdMotivo(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Motivo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Motivo.class)
	})
	public ResponseEntity<Motivo> eliminar(@PathVariable Integer id) {
		Motivo entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Motivo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Motivo.class)
	})
	public List<Motivo> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Motivo" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Motivo.class)
	})
	public Page<Motivo> findAll(@PathVariable Integer page) {
		Pageable paginacion = PageRequest.of(page, 5);
		return this.service.findAll(paginacion);
	}

}