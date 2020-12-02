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

import com.inmobiliaria.services.services.ClienteService;
import com.inmobiliaria.services.model.Cliente;
import com.inmobiliaria.services.model.request.ClienteRequest;

@RestController
@RequestMapping(value = "/v1/cliente")
@Api(value = "Cliente", produces = "application/json", tags = { "Controlador Cliente" })
@PreAuthorize("isAuthenticated()") 
public class ClienteController {
	@Autowired
	private ClienteService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Cliente" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Cliente.class)
	})
	public ResponseEntity<Cliente> registrar(@RequestBody ClienteRequest reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Cliente" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Cliente.class)
	})
	public ResponseEntity<Cliente> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Cliente" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Cliente.class)
	})
	public ResponseEntity<Cliente> modificar(@RequestBody ClienteRequest reg, @PathVariable Integer id) {
		Cliente entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdCliente(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Cliente" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Cliente.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Cliente> eliminar(@PathVariable Integer id) {
		Cliente entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Cliente" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Cliente.class)
	})
	public List<Cliente> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}/{count}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Cliente" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Cliente.class)
	})
	public Page<Cliente> findAll(@PathVariable Integer page, @PathVariable Integer count) {
		Pageable paginacion = PageRequest.of(page, count);
		return this.service.findAll(paginacion);
	}

	@GetMapping("/nroDocumento/{nroDocumento}")
	@ApiOperation(value = "Listar registros por nro documento", tags = { "Controlador Cliente" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Cliente.class)
	})
	public List<Cliente> findByNroDocumento(@PathVariable String nroDocumento) {
		return this.service.findByNroDocumento(nroDocumento);
	}
	@GetMapping("/bynombresandapellidos/{nombres}/{apellidos}")
	@ApiOperation(value = "Listar registros por cliente", tags = { "Controlador Cliente" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Cliente.class)
	})
	public List<Cliente> bynombresandapellidos(@PathVariable String nombres, @PathVariable String apellidos) {
		return this.service.findByNombresAndApellidos(nombres, apellidos);
	}
}