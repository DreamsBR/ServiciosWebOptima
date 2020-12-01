package com.inmobiliaria.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmobiliaria.services.model.response.ConsolidadoColaboradorPeriodoResponse;
import com.inmobiliaria.services.model.response.ConsolidadoGerenciaResponse;
import com.inmobiliaria.services.model.response.ConsolidadoProyectoPeriodoResponse;
import com.inmobiliaria.services.model.response.ConsolidadoProyectoResponse;
import com.inmobiliaria.services.model.response.ConsolidadoVentaResponse;
import com.inmobiliaria.services.services.ReporteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1/reporte")
@Api(value = "reporte", produces = "application/json", tags = { "Controlador Reporte" })
public class ReporteController {
	@Autowired
	private ReporteService service;

	@GetMapping("/consolidadoventas/{idGerencia}/{idPeriodo}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Reporte" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = ConsolidadoVentaResponse.class)
	})
	public List<ConsolidadoVentaResponse> consolidadoVenta(@PathVariable Integer idGerencia, @PathVariable Integer idPeriodo) {
		return this.service.consolidadoVenta(idGerencia, idPeriodo);
	}
	@GetMapping("/consolidadogerencia/{idGerencia}/{idPeriodo}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Reporte" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = ConsolidadoGerenciaResponse.class)
	})
	public List<ConsolidadoGerenciaResponse> consolidadogerencia(@PathVariable Integer idGerencia, @PathVariable Integer idPeriodo) {
		return this.service.consolidadogerencia(idGerencia, idPeriodo);
	}
	@GetMapping("/consolidadovendedor/{idColaborador}/{idPeriodo}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Reporte" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = ConsolidadoVentaResponse.class)
	})
	public List<ConsolidadoVentaResponse> consolidadovendedor(@PathVariable Integer idColaborador, @PathVariable Integer idPeriodo) {
		return this.service.consolidadovendedor(idColaborador, idPeriodo);
	}
	@GetMapping("/consolidadoproyecto/{idProyecto}/{idPeriodo}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Reporte" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = ConsolidadoProyectoResponse.class)
	})
	public List<ConsolidadoProyectoResponse> consolidadoProyecto(@PathVariable Integer idProyecto, @PathVariable Integer idPeriodo) {
		return this.service.consolidadoProyecto(idProyecto, idPeriodo);
	}
	@GetMapping("/consolidadoproyectoperiodo/{idProyecto}/{idPeriodo}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Reporte" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = ConsolidadoProyectoPeriodoResponse.class)
	})
	public List<ConsolidadoProyectoPeriodoResponse> consolidadoProyectoPeriodo(@PathVariable Integer idProyecto, @PathVariable Integer idPeriodo) {
		return this.service.consolidadoProyectoPeriodo(idProyecto, idPeriodo);
	}
	@GetMapping("/consolidadocolaboradorperiodo/{idColaborador}/{idPeriodo}")
	@ApiOperation(value = "Listar registros", tags = { "Controlador Reporte" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = ConsolidadoColaboradorPeriodoResponse.class)
	})
	public List<ConsolidadoColaboradorPeriodoResponse> consolidadoColaboradorPeriodo(@PathVariable Integer idColaborador, @PathVariable Integer idPeriodo) {
		return this.service.consolidadoColaboradorPeriodo(idColaborador, idPeriodo);
	}
}
