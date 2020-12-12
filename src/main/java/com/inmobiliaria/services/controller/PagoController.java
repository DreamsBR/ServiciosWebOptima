/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.inmobiliaria.services.services.PagoService;
import com.inmobiliaria.services.model.Pago;
import com.inmobiliaria.services.model.request.PagoRequest;

@RestController
@RequestMapping(value = "/v1/pago")
@Api(value = "Pago", produces = "application/json", tags = { "Controlador Pago" })
@PreAuthorize("isAuthenticated()") 
public class PagoController {
	@Autowired
	private PagoService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Pago" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Pago.class)
	})
	public ResponseEntity<Pago> registrar(@RequestBody PagoRequest reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Pago" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Pago.class)
	})
	public ResponseEntity<Pago> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Pago" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Pago.class)
	})
	public ResponseEntity<Pago> modificar(@RequestBody PagoRequest reg, @PathVariable Integer id) {
		Pago entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdPago(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Pago" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Pago.class)
	})
	public ResponseEntity<Pago> eliminar(@PathVariable Integer id) {
		Pago entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Pago" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Pago.class)
	})
	public List<Pago> findAll() {
		return this.service.findAll().stream().filter(x -> x.getEnable() == 1).collect(Collectors.toList());
	}

	@GetMapping("/venta/{idVenta}")
	@ApiOperation(value = "Listar registros por venta", tags = { "Controlador Pago" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Pago.class)
	})
	public List<Pago> findByIdVenta(@PathVariable Integer idVenta) {
		return this.service.findByIdVenta(idVenta).stream().filter(x -> x.getEnable() == 1).collect(Collectors.toList());
	}
	
	@GetMapping("/page/{page}/{count}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Pago" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Pago.class)
	})
	public Page<Pago> findAll(@PathVariable Integer page, @PathVariable Integer count) {
		Pageable paginacion = PageRequest.of(page, count);
		return this.service.findAll(paginacion);
	}

}