package com.inmobiliaria.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@ApiOperation(value = "Listar registros", tags = { "Controlador Proyecto" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = ConsolidadoVentaResponse.class)
	})
	public List<ConsolidadoVentaResponse> consolidadoVenta(@PathVariable Integer idGerencia, @PathVariable Integer idPeriodo) {
		return this.service.consolidadoVenta(idGerencia, idPeriodo);
	}
}
