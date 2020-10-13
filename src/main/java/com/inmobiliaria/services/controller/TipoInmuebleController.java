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

import com.inmobiliaria.services.model.TipoInmueble;
import com.inmobiliaria.services.services.TipoInmuebleService;

@RestController
@RequestMapping(value = "/v1/tipoinmueble")
@Api(value = "TipoInmueble", produces = "application/json", tags = { "Controlador TipoInmueble" })
public class TipoInmuebleController {
	@Autowired
	private TipoInmuebleService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador TipoInmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoInmueble.class)
	})
	public ResponseEntity<TipoInmueble> registrar(@RequestBody TipoInmueble reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador TipoInmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoInmueble.class)
	})
	public ResponseEntity<TipoInmueble> obtener(@PathVariable Integer id) {
		return new ResponseEntity<TipoInmueble>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador TipoInmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoInmueble.class)
	})
	public ResponseEntity<TipoInmueble> modificar(@RequestBody TipoInmueble reg, @PathVariable Integer id) {
		TipoInmueble entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdTipoInmueble(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador TipoInmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoInmueble.class)
	})
	public ResponseEntity<TipoInmueble> eliminar(@PathVariable Integer id) {
		TipoInmueble entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador TipoInmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoInmueble.class)
	})
	public List<TipoInmueble> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador TipoInmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = TipoInmueble.class)
	})
	public Page<TipoInmueble> findAll(@PathVariable Integer page) {
		Pageable paginacion = PageRequest.of(page, 5);
		return this.service.findAll(paginacion);
	}

}