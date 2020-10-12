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

import com.inmobiliaria.services.services.VendedorService;
import com.inmobiliaria.services.model.Vendedor;

@RestController
@RequestMapping(value = "/v1/vendedor")
@Api(value = "Vendedor", produces = "application/json", tags = { "Controlador Vendedor" })
public class VendedorController {
	@Autowired
	private VendedorService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Vendedor" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Vendedor.class)
	})
	public ResponseEntity<Vendedor> registrar(@RequestBody Vendedor reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Vendedor" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Vendedor.class)
	})
	public ResponseEntity<Vendedor> obtener(@PathVariable Integer id) {
		return new ResponseEntity<Vendedor>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Vendedor" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Vendedor.class)
	})
	public ResponseEntity<Vendedor> modificar(@RequestBody Vendedor reg, @PathVariable Integer id) {
		Vendedor entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdVendedor(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Vendedor" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Vendedor.class)
	})
	public ResponseEntity<Vendedor> eliminar(@PathVariable Integer id) {
		Vendedor entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Vendedor" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Vendedor.class)
	})
	public List<Vendedor> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Vendedor" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Vendedor.class)
	})
	public Page<Vendedor> findAll(@PathVariable Integer page) {
		Pageable paginacion = PageRequest.of(page, 5);
		return this.service.findAll(paginacion);
	}

}