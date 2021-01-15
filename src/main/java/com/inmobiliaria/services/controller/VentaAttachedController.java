package com.inmobiliaria.services.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.inmobiliaria.services.model.VentaAttached;
import com.inmobiliaria.services.services.VentaAttachedService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value = "/v1/ventaattached")
@Api(value = "VentaAttached", produces = "application/json", tags = { "Controlador VentaAttached" })
@PreAuthorize("isAuthenticated()") 
public class VentaAttachedController {
	@Autowired
	private VentaAttachedService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador VentaAttached" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaAttached.class)
	})
	public ResponseEntity<VentaAttached> registrar(@RequestBody VentaAttached reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador VentaAttached" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaAttached.class)
	})
	public ResponseEntity<VentaAttached> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador VentaAttached" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaAttached.class)
	})
	public ResponseEntity<VentaAttached> modificar(@RequestBody VentaAttached reg, @PathVariable Integer id) {
		VentaAttached entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdVentaAttached(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador VentaAttached" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaAttached.class)
	})
	public ResponseEntity<VentaAttached> eliminar(@PathVariable Integer id) {
		VentaAttached entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/byidventa/{idVenta}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador VentaAttached" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaAttached.class)
	})
	public List<VentaAttached> findByIdVenta(@PathVariable Integer idVenta) {
		return this.service.findByIdVenta(idVenta);
	}
	

}