package com.inmobiliaria.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.inmobiliaria.services.model.VentaFiles;
import com.inmobiliaria.services.model.request.VentaFilesRequest;
import com.inmobiliaria.services.services.VentaFilesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1/ventafiles")
@Api(value = "VentaFiles", produces = "application/json", tags = { "Controlador Venta files" })
@PreAuthorize("isAuthenticated()") 
public class VentaFilesController {
	@Autowired
	private VentaFilesService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Venta files" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaFiles.class)
	})
	public ResponseEntity<VentaFiles> registrar(@RequestBody VentaFilesRequest reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Venta files" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaFiles.class)
	})
	public ResponseEntity<VentaFiles> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Venta files" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaFiles.class)
	})
	public ResponseEntity<VentaFiles> modificar(@RequestBody VentaFilesRequest reg, @PathVariable Integer id) {
		VentaFiles entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdVentaFiles(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Venta files" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaFiles.class)
	})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<VentaFiles> eliminar(@PathVariable Integer id) {
		VentaFiles entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/venta/{idVenta}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Venta files" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaFiles.class)
	})
	public List<VentaFiles> findByIdVenta(@PathVariable Integer idVenta) {
		return this.service.findByIdVenta(idVenta);
	}

	@GetMapping("/page/{page}/{count}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Venta files" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = VentaFiles.class)
	})
	public Page<VentaFiles> findAll(@PathVariable Integer page, @PathVariable Integer count) {
		Pageable paginacion = PageRequest.of(page, count);
		return this.service.findAll(paginacion);
	}
}
