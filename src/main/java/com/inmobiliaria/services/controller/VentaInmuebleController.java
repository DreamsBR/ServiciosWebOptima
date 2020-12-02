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

import com.inmobiliaria.services.services.VentaInmuebleService;
import com.inmobiliaria.services.model.VentaInmueble;
import com.inmobiliaria.services.model.request.VentaInmuebleRequest;

@RestController
@RequestMapping(value = "/v1/ventainmueble")
@Api(value = "VentaInmueble", produces = "application/json", tags = { "Controlador VentaInmueble" })
@PreAuthorize("isAuthenticated()") 
public class VentaInmuebleController {
	@Autowired
	private VentaInmuebleService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador VentaInmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaInmueble.class)
	})
	public ResponseEntity<VentaInmueble> registrar(@RequestBody VentaInmuebleRequest reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador VentaInmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaInmueble.class)
	})
	public ResponseEntity<VentaInmueble> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador VentaInmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaInmueble.class)
	})
	public ResponseEntity<VentaInmueble> modificar(@RequestBody VentaInmuebleRequest reg, @PathVariable Integer id) {
		VentaInmueble entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdVentaInmueble(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador VentaInmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaInmueble.class)
	})
	public ResponseEntity<VentaInmueble> eliminar(@PathVariable Integer id) {
		VentaInmueble entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador VentaInmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaInmueble.class)
	})
	public List<VentaInmueble> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador VentaInmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaInmueble.class)
	})
	public Page<VentaInmueble> findAll(@PathVariable Integer page) {
		Pageable paginacion = PageRequest.of(page, 5);
		return this.service.findAll(paginacion);
	}
	
	@GetMapping("/venta/{idVenta}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador VentaInmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaInmueble.class)
	})
	public List<VentaInmueble> findByVenta(@PathVariable Integer idVenta) {
		return this.service.findByVenta(idVenta);
	}

}