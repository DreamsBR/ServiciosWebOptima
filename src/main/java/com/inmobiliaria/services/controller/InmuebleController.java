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

import com.inmobiliaria.services.services.InmuebleService;
import com.inmobiliaria.services.model.Inmueble;
import com.inmobiliaria.services.model.request.InmuebleRequest;

@RestController
@RequestMapping(value = "/v1/inmueble")
@Api(value = "Inmueble", produces = "application/json", tags = { "Controlador Inmueble" })
public class InmuebleController {
	@Autowired
	private InmuebleService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Inmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = InmuebleRequest.class)
	})
	public ResponseEntity<Inmueble> registrar(@RequestBody InmuebleRequest reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Inmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Inmueble.class)
	})
	public ResponseEntity<Inmueble> obtener(@PathVariable Integer id) {
		return new ResponseEntity<Inmueble>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Inmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Inmueble.class)
	})
	public ResponseEntity<Inmueble> modificar(@RequestBody InmuebleRequest reg, @PathVariable Integer id) {
		Inmueble entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdInmueble(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Inmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Inmueble.class)
	})
	public ResponseEntity<Inmueble> eliminar(@PathVariable Integer id) {
		Inmueble entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Inmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Inmueble.class)
	})
	public List<Inmueble> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Inmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Inmueble.class)
	})
	public Page<Inmueble> findAll(@PathVariable Integer page) {
		Pageable paginacion = PageRequest.of(page, 5);
		return this.service.findAll(paginacion);
	}
	@GetMapping("/listarporproyecto/{idProyecto}")
	@ApiOperation(value = "Listar registros por proyecto", tags = { "Controlador Inmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Inmueble.class)
	})
	public List<Inmueble> searchByProyecto(@PathVariable Integer idProyecto) {
		return this.service.searchByProyecto(idProyecto);
	}
	@GetMapping("/listarporcategoria/{idProyecto}/{idTipoInmueble}/{idTipoInmuebleCategoria}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Inmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Inmueble.class)
	})
	public List<Inmueble> searchByCategoria(@PathVariable Integer idProyecto, @PathVariable Integer idTipoInmueble, @PathVariable Integer idTipoInmuebleCategoria) {
		return this.service.searchByCategoria(idProyecto, idTipoInmueble, idTipoInmuebleCategoria);
	}
	
	@GetMapping("/searchByNumero/{idProyecto}/{idTipoInmueble}/{numero}")
	@ApiOperation(value = "buscar registro", tags = { "Controlador Inmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Inmueble.class)
	})
	public ResponseEntity<Inmueble> searchByNumero(@PathVariable Integer idProyecto, @PathVariable Integer idTipoInmueble, @PathVariable String numero) {
		return new ResponseEntity<Inmueble>(this.service.searchByNumero(idProyecto, idTipoInmueble, numero), HttpStatus.OK);
	}

	@GetMapping("/disponibles/{idProyecto}/{idTipoInmueble}/{idTipoInmuebleCategoria}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Inmueble" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Inmueble.class)
	})
	public List<Inmueble> searchdisponibles(@PathVariable Integer idProyecto, @PathVariable Integer idTipoInmueble, @PathVariable Integer idTipoInmuebleCategoria) {
		return this.service.searchDisponibles(idProyecto, idTipoInmueble, idTipoInmuebleCategoria);
	}
}