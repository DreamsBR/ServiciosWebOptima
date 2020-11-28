package com.inmobiliaria.services.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobiliaria.services.model.GerenciaProyecto;
import com.inmobiliaria.services.model.Periodo;
import com.inmobiliaria.services.model.PeriodoProyecto;
import com.inmobiliaria.services.model.Venta;
import com.inmobiliaria.services.model.response.ConsolidadoVentaResponse;
import com.inmobiliaria.services.repository.GerenciaProyectoRepository;
import com.inmobiliaria.services.repository.PeriodoProyectoRepository;
import com.inmobiliaria.services.repository.PeriodoRepository;
import com.inmobiliaria.services.repository.VentaRepository;


@Service
public class ReporteService {
	@Autowired
	private PeriodoProyectoRepository periodoProyectoRepository;
	@Autowired
	private VentaRepository ventaRepository;
	@Autowired
	private PeriodoRepository periodoRepository;
	@Autowired
	private GerenciaProyectoRepository gerenciaProyectoRepository;
	public List<ConsolidadoVentaResponse> consolidadoVenta(Integer idGerencia, Integer idPeriodo) {
		List<ConsolidadoVentaResponse> listResponse = new ArrayList<>();
		List<PeriodoProyecto> list = periodoProyectoRepository.findByIdPeriodo(idPeriodo);
		List<GerenciaProyecto> listGerenciaProyecto = gerenciaProyectoRepository.findByIdGerencia(idGerencia);
		List<PeriodoProyecto> listPeriodoProyecto = filtarporGerencia(listGerenciaProyecto, list);
		
		Periodo periodo = periodoRepository.findById(idPeriodo).get();
		
		for (PeriodoProyecto periodoProyecto : listPeriodoProyecto) {
			ConsolidadoVentaResponse res = new ConsolidadoVentaResponse();
			res.setProyecto(periodoProyecto.getProyecto());
			res.setMeta(periodoProyecto.getMeta());
			
			List<Venta> listVentas = ventaRepository.findByIdProyecto(periodoProyecto.getProyecto().getIdProyecto());
			List<Venta> listVentasResult = listVentas.stream().filter(v -> v.getFechaRegistro().getTime() >= periodo.getFechaInicio().getTime() && v.getFechaRegistro().getTime() <= periodo.getFechaFin().getTime() ).collect(Collectors.toList());
			double suma = listVentasResult.stream()
		      .mapToDouble(o -> o.getPagos().stream().mapToDouble(p -> p.getMonto().doubleValue()).sum())
		      .sum();
			res.setAvance(suma);
			
			List<Venta> spVenta = listVentasResult.stream().filter(v -> v.getEstadoVenta().getIdEstadoVenta() == 1).collect(Collectors.toList());
			res.setSp(spVenta.size());

			List<Venta> minutaVenta = listVentasResult.stream().filter(v -> v.getEstadoVenta().getIdEstadoVenta() == 5).collect(Collectors.toList());
			res.setMinuta(minutaVenta.size());
			
			List<Venta> ciVenta = listVentasResult.stream().filter(v -> v.getEstadoVenta().getIdEstadoVenta() == 4).collect(Collectors.toList());
			res.setCi(ciVenta.size());
			
			List<Venta> preVenta = listVentasResult.stream().filter(v -> v.getEstadoVenta().getIdEstadoVenta() == 2).collect(Collectors.toList());
			res.setPreca(preVenta.size());
			
			List<Venta> evVenta = listVentasResult.stream().filter(v -> v.getEstadoVenta().getIdEstadoVenta() == 3).collect(Collectors.toList());
			res.setEv(evVenta.size());
			
			List<Venta> caidaVenta = listVentasResult.stream().filter(v -> v.getEstadoVenta().getIdEstadoVenta() == 14).collect(Collectors.toList());
			res.setCaida(caidaVenta.size());
			
			listResponse.add(res);
		}
		return listResponse;
	}
	private List<PeriodoProyecto> filtarporGerencia(List<GerenciaProyecto> listGerenciaProyecto, List<PeriodoProyecto> listPeriodoProyecto){
		List<PeriodoProyecto> list = new ArrayList<>();
		for (PeriodoProyecto periodoProyecto : listPeriodoProyecto) {
			List<GerenciaProyecto> listfind = listGerenciaProyecto.stream().filter(x -> x.getIdProyecto() == periodoProyecto.getProyecto().getIdProyecto()).collect(Collectors.toList());
			if( listfind.size() > 0 ) {
				list.add(periodoProyecto);
			}
		}
		return list;
	}
}
