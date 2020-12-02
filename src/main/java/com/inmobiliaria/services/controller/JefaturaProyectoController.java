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

import com.inmobiliaria.services.services.JefaturaProyectoService;
import com.inmobiliaria.services.model.JefaturaProyecto;
import com.inmobiliaria.services.model.request.JefaturaProyectoRequest;

@RestController
@RequestMapping(value = "/v1/jefaturaproyecto")
@Api(value = "JefaturaProyecto", produces = "application/json", tags = { "Controlador JefaturaProyecto" })
@PreAuthorize("isAuthenticated()") 
public class JefaturaProyectoController {
	@Autowired
	private JefaturaProyectoService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador JefaturaProyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = JefaturaProyecto.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<JefaturaProyecto> registrar(@RequestBody JefaturaProyectoRequest reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador JefaturaProyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = JefaturaProyecto.class)
	})
	public ResponseEntity<JefaturaProyecto> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador JefaturaProyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = JefaturaProyecto.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<JefaturaProyecto> modificar(@RequestBody JefaturaProyectoRequest reg, @PathVariable Integer id) {
		JefaturaProyecto entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdJefaturaProyecto(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador JefaturaProyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = JefaturaProyecto.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<JefaturaProyecto> eliminar(@PathVariable Integer id) {
		JefaturaProyecto entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador JefaturaProyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = JefaturaProyecto.class)
	})
	public List<JefaturaProyecto> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}/{count}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador JefaturaProyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = JefaturaProyecto.class)
	})
	public Page<JefaturaProyecto> findAll(@PathVariable Integer page, @PathVariable Integer count) {
		Pageable paginacion = PageRequest.of(page, count);
		return this.service.findAll(paginacion);
	}

	@GetMapping("/porProyecto/{idProyecto}")
	@ApiOperation(value = "Listar registros por proyecto", tags = { "Controlador JefaturaProyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = JefaturaProyecto.class)
	})
	public List<JefaturaProyecto> porProyecto(@PathVariable Integer idProyecto) {
		return this.service.findByProyecto(idProyecto);
	}
	@GetMapping("/porJefatura/{idJefatura}")
	@ApiOperation(value = "Listar registros por jefatura", tags = { "Controlador JefaturaProyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = JefaturaProyecto.class)
	})
	public List<JefaturaProyecto> porjefatura(@PathVariable Integer idJefatura) {
		return this.service.findByProyecto(idJefatura);
	}
}