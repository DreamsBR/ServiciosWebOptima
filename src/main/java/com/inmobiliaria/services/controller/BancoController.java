package com.inmobiliaria.services.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.inmobiliaria.services.model.Banco;
import com.inmobiliaria.services.service.BancoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value = "/v1/banco")
@Api(value = "banco", produces = "application/json",  tags = { "Controlador Banco" })
public class BancoController {
	@Autowired
	private BancoService service;
   
    @GetMapping("/")
    @ApiOperation(value = "listado de Banco ", tags = { "Controlador Banco" })
    @ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Ok", response = Banco.class),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Error en el servidor", response = Exception.class)})
    public List<Banco> getAll() {
    	return service.getAll();
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar Banco ", tags = { "Controlador Banco" })
    @ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Ok", response = Banco.class),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Error en el servidor", response = Exception.class)})
    public Optional<Banco> findById(@PathVariable Integer id) {
    	return service.findById(id);
    }
    @PostMapping("/")
    @ApiOperation(value = "Insert de Banco ", tags = { "Controlador Banco" })
    @ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Ok", response = Banco.class),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Error en el servidor", response = Exception.class)})
    public Banco save(@RequestBody Banco entity) {
    	return service.save(entity);
    }
    @PutMapping("/{id}")
    @ApiOperation(value = "Buscar Banco ", tags = { "Controlador Banco" })
    @ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Ok", response = Banco.class),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Error en el servidor", response = Exception.class)})
    public Banco update(@PathVariable Integer id, @RequestBody Banco entity) {
    	return service.update(id, entity);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar Banco ", tags = { "Controlador Banco" })
    @ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Ok", response = void.class),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Error en el servidor", response = Exception.class)})
    public ResponseEntity<?> delete(@PathVariable Integer id) {
    	service.delete(id);
    	return  new ResponseEntity<>(HttpStatus.OK);
    }
}
