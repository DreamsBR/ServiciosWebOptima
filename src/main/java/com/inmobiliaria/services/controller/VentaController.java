/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.inmobiliaria.services.services.VentaService;
import com.inmobiliaria.services.model.Venta;
import com.inmobiliaria.services.model.request.VentaRequest;

@RestController
@RequestMapping(value = "/v1/venta")
@Api(value = "Venta", produces = "application/json", tags = { "Controlador Venta" })
public class VentaController {
	@Autowired
	private VentaService service;

	@PostMapping
	@ApiOperation(value = "servicio para registrar", tags = { "Controlador Venta" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Venta.class)
	})
	public ResponseEntity<Venta> registrar(@RequestBody VentaRequest reg) {
		return new ResponseEntity<>(this.service.registrar(reg), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "obtener registro", tags = { "Controlador Venta" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Venta.class)
	})
	public ResponseEntity<Venta> obtener(@PathVariable Integer id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "modificar registro", tags = { "Controlador Venta" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Venta.class)
	})
	public ResponseEntity<Venta> modificar(@RequestBody VentaRequest reg, @PathVariable Integer id) {
		Venta entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			reg.setIdVenta(id);
			return new ResponseEntity<>(this.service.update(reg), HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "eliminar registro", tags = { "Controlador Venta" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Venta.class)
	})
	public ResponseEntity<Venta> eliminar(@PathVariable Integer id) {
		Venta entity = this.service.findById(id);
		if ( entity == null ) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			this.service.delete(entity);
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@GetMapping("/")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Venta" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Venta.class)
	})
	public List<Venta> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/page/{page}")
	@ApiOperation(value = "Paginar registros", tags = { "Controlador Venta" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Venta.class)
	})
	public Page<Venta> findAll(@PathVariable Integer page) {
		Pageable paginacion = PageRequest.of(page, 5);
		return this.service.findAll(paginacion);
	}
	
	@GetMapping("/byproyecto/{idProyecto}/{page}")
	@ApiOperation(value = "Listar ventas por proyecto", tags = { "Controlador Venta" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Venta.class)
	})
	public Page<Venta> findByIdProyecto(@PathVariable Integer idProyecto, @PathVariable Integer page ) {
		Pageable paginacion = PageRequest.of(page, 5);
		return this.service.findByIdProyecto(idProyecto, paginacion);
	}
	@GetMapping("/byproyectoandestado/{idProyecto}/{idEstadoVenta}")
	@ApiOperation(value = "Listar ventas por proyecto", tags = { "Controlador Venta" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Venta.class)
	})
	public List<Venta> findByProyectoAndEstadoVenta(@PathVariable Integer idProyecto, @PathVariable Integer idEstadoVenta) {
		return this.service.findByProyectoAndIdEstadoVenta(idProyecto, idEstadoVenta);
	}
	@GetMapping("/byproyectoandestadorange/{idProyecto}/{idEstadoVenta}/{fechaini}/{fechafin}")
	@ApiOperation(value = "Listar ventas por proyecto, estado y rango de fechas", tags = { "Controlador Venta" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Venta.class)
	})
	public List<Venta> findByProyectoAndIdEstadoVenta(@PathVariable Integer idProyecto, @PathVariable Integer idEstadoVenta, @PathVariable String fechaini, @PathVariable String fechafin) {
		SimpleDateFormat ddmmyy=new SimpleDateFormat("yyyy-MM-dd");
		Date ini;
		Date fin;
		try {
			ini = ddmmyy.parse(fechaini);
			fin = ddmmyy.parse(fechafin);
			return this.service.findByIdProyectoAndIdEstadoVenta(idProyecto, idEstadoVenta, ini, fin);
		} catch (ParseException e) {
			return new ArrayList<Venta>();
		}
	}
	@GetMapping("/bycliente/{idCiente}/{page}")
	@ApiOperation(value = "Listar ventas por cliente", tags = { "Controlador Venta" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = Venta.class)
	})
	public Page<Venta> findByIdCliente(@PathVariable Integer idCiente, @PathVariable Integer page ) {
		Pageable paginacion = PageRequest.of(page, 5);
		return this.service.findByIdCliente(idCiente, paginacion);
	}
}