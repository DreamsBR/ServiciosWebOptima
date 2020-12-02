/**

KELVI * @author Walter Canchan
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

import com.inmobiliaria.services.services.PaisService;
import com.inmobiliaria.services.model.Pais;

@RestController
@RequestMapping(value = "/v1/pais")
@Api(value = "Pais", produces = "application/json", tags = { "Controlador Pais" })
@PreAuthorize("isAuthenticated()") 
public class PaisController {
	@Autowired
	private PaisService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Pais" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Pais.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Pais> registrar(@RequestBody Pais reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Pais" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Pais.class)
	})
	public ResponseEntity<Pais> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Pais" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Pais.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Pais> modificar(@RequestBody Pais reg, @PathVariable Integer id) {
		Pais entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdPais(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Pais" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Pais.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Pais> eliminar(@PathVariable Integer id) {
		Pais entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Pais" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Pais.class)
	})
	public List<Pais> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}/{count}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Pais" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Pais.class)
	})
	public Page<Pais> findAll(@PathVariable Integer page, @PathVariable Integer count) {
		Pageable paginacion = PageRequest.of(page, count);
		return this.service.findAll(paginacion);
	}

}