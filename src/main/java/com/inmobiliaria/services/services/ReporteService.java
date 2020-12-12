package com.inmobiliaria.services.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmobiliaria.services.model.GerenciaProyecto;
import com.inmobiliaria.services.model.JefaturaProyecto;
import com.inmobiliaria.services.model.Periodo;
import com.inmobiliaria.services.model.PeriodoColaborador;
import com.inmobiliaria.services.model.PeriodoGerencia;
import com.inmobiliaria.services.model.PeriodoProyecto;
import com.inmobiliaria.services.model.Vendedor;
import com.inmobiliaria.services.model.Venta;
import com.inmobiliaria.services.model.response.ConsolidadoColaboradorPeriodoResponse;
import com.inmobiliaria.services.model.response.ConsolidadoGerenciaResponse;
import com.inmobiliaria.services.model.response.ConsolidadoProyectoPeriodoResponse;
import com.inmobiliaria.services.model.response.ConsolidadoProyectoResponse;
import com.inmobiliaria.services.model.response.ConsolidadoVentaResponse;
import com.inmobiliaria.services.repository.GerenciaProyectoRepository;
import com.inmobiliaria.services.repository.JefaturaProyectoRepository;
import com.inmobiliaria.services.repository.PagoRepository;
import com.inmobiliaria.services.repository.PeriodoColaboradorRepository;
import com.inmobiliaria.services.repository.PeriodoGerenciaRepository;
import com.inmobiliaria.services.repository.PeriodoProyectoRepository;
import com.inmobiliaria.services.repository.PeriodoRepository;
import com.inmobiliaria.services.repository.VendedorRepository;
import com.inmobiliaria.services.repository.VentaRepository;


@Service
public class ReporteService {
	@Autowired
	private PeriodoGerenciaRepository periodoGerenciaRepository;
	@Autowired
	private PeriodoProyectoRepository periodoProyectoRepository;
	@Autowired
	private PeriodoColaboradorRepository periodoColaboradorRepository;
	@Autowired
	private VentaRepository ventaRepository;
	@Autowired
	private PeriodoRepository periodoRepository;
	@Autowired
	private PagoRepository pagoRepository;
	@Autowired
	private VendedorRepository vendedorRepository;
	@Autowired
	private JefaturaProyectoRepository jefaturaProyectoRepository;
	@Autowired
	private GerenciaProyectoRepository gerenciaProyectoRepository;
	public List<ConsolidadoVentaResponse> consolidadoVenta(Integer idGerencia, Integer idPeriodo) {
		List<ConsolidadoVentaResponse> listResponse = new ArrayList<>();
		List<PeriodoProyecto> list = periodoProyectoRepository.findByIdPeriodo(idPeriodo)				
				.stream()
				.filter(x -> x.getEnable() == 1 && x.getPeriodo().getEnable() == 1 && x.getProyecto().getEnable() == 1)
				.collect(Collectors.toList());
		List<GerenciaProyecto> listGerenciaProyecto = gerenciaProyectoRepository.findByIdGerencia(idGerencia)
				.stream()
				.filter(x -> x.getEnable() == 1 && x.getProyecto().getEnable() == 1)
				.collect(Collectors.toList());
		List<PeriodoProyecto> listPeriodoProyecto = filtarporGerencia(listGerenciaProyecto, list);
		
		Periodo periodo = periodoRepository.findById(idPeriodo).get();
		
		for (PeriodoProyecto periodoProyecto : listPeriodoProyecto) {
			ConsolidadoVentaResponse res = new ConsolidadoVentaResponse();
			res.setProyecto(periodoProyecto.getProyecto());
			res.setMeta(periodoProyecto.getMeta());
			
			List<Venta> listVentas = ventaRepository.findByIdProyecto(periodoProyecto.getProyecto().getIdProyecto())
					.stream()
					.filter(x -> x.getEnable() == 1 )
					.collect(Collectors.toList());
			List<Venta> listVentasResult = listVentas.stream().filter(v -> v.getFechaRegistro().getTime() >= periodo.getFechaInicio().getTime() && v.getFechaRegistro().getTime() <= periodo.getFechaFin().getTime() ).collect(Collectors.toList());
			
			List<Venta> listVentasResultpago = listVentasResult
					.stream()
					.filter(v -> 
						v.getEstadoVenta().getIdEstadoVenta() != 14 &&
						v.getFechaMinuta() != null )
					.collect(Collectors.toList());
					
			double suma = listVentasResultpago.stream()
		      .mapToDouble(o -> 
		      		o.getTotal().doubleValue()
		    	  //pagoRepository.findByIdVenta(o.getIdVenta()).stream().mapToDouble(p -> p.getMonto().doubleValue()).sum()
		    ).sum();
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
			List<GerenciaProyecto> listfind = listGerenciaProyecto.stream().filter(x -> x.getProyecto().getIdProyecto() == periodoProyecto.getProyecto().getIdProyecto()).collect(Collectors.toList());
			if( listfind.size() > 0 ) {
				list.add(periodoProyecto);
			}
		}
		return list;
	}
	public List<ConsolidadoGerenciaResponse> consolidadogerencia(Integer idGerencia, Integer idPeriodo) {
		List<ConsolidadoGerenciaResponse> listConsolidadoGerenciaResponse = new ArrayList<>();
		List<PeriodoGerencia> listPeriodoGerencia = periodoGerenciaRepository.findByIdGerencia(idGerencia)
				.stream()
				.filter(x -> x.getEnable() == 1 && x.getPeriodo().getEnable() == 1 )
				.collect(Collectors.toList());
		List<GerenciaProyecto> listGerenciaProyecto = gerenciaProyectoRepository.findByIdGerencia(idGerencia)
				.stream()
				.filter(x -> x.getEnable() == 1  && x.getProyecto().getEnable() == 1)
				.collect(Collectors.toList());
		listPeriodoGerencia = ordenarListPeriodoGerencia(listPeriodoGerencia, idPeriodo);
		for (PeriodoGerencia periodoGerencia : listPeriodoGerencia) {
			ConsolidadoGerenciaResponse item = new ConsolidadoGerenciaResponse();
			item.setPeriodoGerencia(periodoGerencia);
			double avancemeta=0; 
			for (GerenciaProyecto gerenciaProyecto : listGerenciaProyecto) {
				List<Venta> listVentas = ventaRepository.findByIdProyecto(gerenciaProyecto.getProyecto().getIdProyecto())
						.stream()
						.filter(x -> x.getEnable() == 1 )
						.collect(Collectors.toList());
				List<Venta> listVentasResult = listVentas
						.stream()
						.filter(v -> 
							v.getFechaRegistro().getTime() >= periodoGerencia.getPeriodo().getFechaInicio().getTime() && 
							v.getFechaRegistro().getTime() <= periodoGerencia.getPeriodo().getFechaFin().getTime() &&
							v.getEstadoVenta().getIdEstadoVenta() != 14 &&
							v.getFechaMinuta() != null )
						.collect(Collectors.toList());

				
				double suma = listVentasResult.stream()
			      .mapToDouble(o -> 
			      		o.getTotal().doubleValue()
			    ).sum();
				
				avancemeta = avancemeta + suma;
			}
			item.setVenta(avancemeta);
			listConsolidadoGerenciaResponse.add(item);
		}
		return listConsolidadoGerenciaResponse;
	}
	private List<PeriodoGerencia> ordenarListPeriodoGerencia(List<PeriodoGerencia> listPeriodoGerencia, Integer idPeriodo) {
		List<PeriodoGerencia> listPeriodoGerencianew = new ArrayList<>();
		Collections.sort(listPeriodoGerencia, (d1, d2) -> {
			return d2.getPeriodo().getIdPeriodo() - d1.getPeriodo().getIdPeriodo();
		});
		for (PeriodoGerencia periodoGerencia : listPeriodoGerencia) {
			if (periodoGerencia.getPeriodo().getIdPeriodo() <= idPeriodo )
				listPeriodoGerencianew.add(periodoGerencia);
		}

		return listPeriodoGerencianew;
	}
	public List<ConsolidadoProyectoPeriodoResponse> consolidadoProyectoPeriodo(Integer idProyecto, Integer idPeriodo) {
		List<ConsolidadoProyectoPeriodoResponse> listConsolidadoProyectoPeriodoResponse = new ArrayList<>();
		List<PeriodoProyecto> listPeriodoProyecto = periodoProyectoRepository.findByIdProyecto(idProyecto)
				.stream()
				.filter(x -> x.getEnable() == 1 && x.getPeriodo().getEnable() == 1 && x.getProyecto().getEnable() == 1)
				.collect(Collectors.toList());
		Collections.sort(listPeriodoProyecto, (d1, d2) -> {
			return (int) (d2.getPeriodo().getFechaInicio().getTime() - d1.getPeriodo().getFechaInicio().getTime());
		});
		for (PeriodoProyecto periodoProyecto : listPeriodoProyecto) {
			ConsolidadoProyectoPeriodoResponse item = new ConsolidadoProyectoPeriodoResponse();
			item.setPeriodoProyecto(periodoProyecto);
			List<Venta> listVentas = ventaRepository.findByIdProyecto(periodoProyecto.getProyecto().getIdProyecto())
					.stream()
					.filter(x -> x.getEnable() == 1 )
					.collect(Collectors.toList());
			List<Venta> listVentasResult = listVentas
					.stream()
					.filter(v -> v.getFechaRegistro().getTime() >= periodoProyecto.getPeriodo().getFechaInicio().getTime() && v.getFechaRegistro().getTime() <= periodoProyecto.getPeriodo().getFechaFin().getTime() &&
					v.getEstadoVenta().getIdEstadoVenta() != 14 &&
					v.getFechaMinuta() != null )
					.collect(Collectors.toList());
			double suma = listVentasResult.stream().mapToDouble(o -> 
						  o.getTotal().doubleValue()
					      //pagoRepository.findByIdVenta(o.getIdVenta()).stream().mapToDouble(p -> p.getMonto().doubleValue()).sum())
					      ).sum();
			item.setVenta(suma);
			listConsolidadoProyectoPeriodoResponse.add(item);
		}
		return listConsolidadoProyectoPeriodoResponse;
	}
	public List<ConsolidadoColaboradorPeriodoResponse> consolidadoColaboradorPeriodo(Integer idColaborador, Integer idPeriodo) {
		List<ConsolidadoColaboradorPeriodoResponse> listConsolidadoColaboradorPeriodoResponse = new ArrayList<>();
		List<PeriodoColaborador> listPeriodoColaborador = periodoColaboradorRepository.findByIdColaborador(idColaborador)
				.stream()
				.filter(x -> x.getEnable() == 1 && x.getPeriodo().getEnable() == 1 )
				.collect(Collectors.toList());
		Vendedor vendedor = vendedorRepository.findByIdColaborador(idColaborador).get(0);
		for (PeriodoColaborador periodoColaborador : listPeriodoColaborador) {
			ConsolidadoColaboradorPeriodoResponse item = new ConsolidadoColaboradorPeriodoResponse();
			item.setPeriodoColaborador(periodoColaborador);
			List<Venta> listVentas = ventaRepository.findByIdVendedor(vendedor.getIdVendedor())
					.stream()
					.filter(x -> x.getEnable() == 1 )
					.collect(Collectors.toList());
			List<Venta> listVentasResult = listVentas
					.stream()
					.filter(v -> v.getFechaRegistro().getTime() >= periodoColaborador.getPeriodo().getFechaInicio().getTime() && v.getFechaRegistro().getTime() <= periodoColaborador.getPeriodo().getFechaFin().getTime() 
					&& v.getEstadoVenta().getIdEstadoVenta() != 14 &&
					v.getFechaMinuta() != null 
					).collect(Collectors.toList());
			double suma = listVentasResult.stream().mapToDouble(o -> 
				o.getTotal().doubleValue()
				//pagoRepository.findByIdVenta(o.getIdVenta()).stream().mapToDouble(p -> p.getMonto().doubleValue()).sum())
				).sum();
			item.setVenta(suma);
			listConsolidadoColaboradorPeriodoResponse.add(item);
		}
		return listConsolidadoColaboradorPeriodoResponse;
	}
	public List<ConsolidadoVentaResponse> consolidadovendedor(Integer idColaborador, Integer idPeriodo) {
		List<ConsolidadoVentaResponse> listResponse = new ArrayList<>();
		Vendedor vendedor = vendedorRepository.findByIdColaborador(idColaborador).get(0);
		List<JefaturaProyecto> jp = jefaturaProyectoRepository.findByIdJefatura(vendedor.getIdJefatura())
				.stream()
				.filter(x -> x.getEnable() == 1 && x.getJefatura().getEnable() == 1 && x.getProyecto().getEnable() == 1)
				.collect(Collectors.toList());
		List<PeriodoProyecto> list = periodoProyectoRepository.findByIdPeriodo(idPeriodo)
				.stream()
				.filter(x -> x.getEnable() == 1 && x.getPeriodo().getEnable() == 1 && x.getProyecto().getEnable() == 1)
				.collect(Collectors.toList());
		
		List<PeriodoProyecto> listJefaturaProyecto = filtarporJefatura(jp, list);


		Periodo periodo = periodoRepository.findById(idPeriodo).get();
		
		for (PeriodoProyecto periodoProyecto : listJefaturaProyecto) {
			ConsolidadoVentaResponse res = new ConsolidadoVentaResponse();
			res.setProyecto(periodoProyecto.getProyecto());
			res.setMeta(periodoProyecto.getMeta());
			
			List<Venta> listVentas = ventaRepository.findByIdProyecto(periodoProyecto.getProyecto().getIdProyecto())
					.stream()
					.filter(x -> x.getEnable() == 1 )
					.collect(Collectors.toList());
			List<Venta> listVentasResult = listVentas.stream().filter(v -> v.getFechaRegistro().getTime() >= periodo.getFechaInicio().getTime() && v.getFechaRegistro().getTime() <= periodo.getFechaFin().getTime() && v.getVendedor().getIdColaborador() == idColaborador ).collect(Collectors.toList());
			
			List<Venta> listVentasResultPago = listVentas.stream().filter(v ->
				v.getFechaMinuta() != null && v.getEstadoVenta().getIdEstadoVenta() != 14
			).collect(Collectors.toList());
			
			double suma = listVentasResultPago.stream()
		      .mapToDouble(o -> o.getTotal().doubleValue()
		    	  //pagoRepository.findByIdVenta(o.getIdVenta()).stream().mapToDouble(p -> p.getMonto().doubleValue()).sum()
		    ).sum();
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
	private List<PeriodoProyecto> filtarporJefatura(List<JefaturaProyecto> listJefaturaProyecto, List<PeriodoProyecto> listPeriodoProyecto){
		List<PeriodoProyecto> list = new ArrayList<>();
		for (PeriodoProyecto periodoProyecto : listPeriodoProyecto) {
			List<JefaturaProyecto> listfind = listJefaturaProyecto.stream().filter(x -> x.getProyecto().getIdProyecto() == periodoProyecto.getProyecto().getIdProyecto()).collect(Collectors.toList());
			if( listfind.size() > 0 ) {
				list.add(periodoProyecto);
			}
		}
		return list;
	}
	public List<ConsolidadoProyectoResponse> consolidadoProyecto(Integer idProyecto, Integer idPeriodo) {
		List<ConsolidadoProyectoResponse> listResponse = new ArrayList<>();
		List<JefaturaProyecto> listJefaturaProyecto = jefaturaProyectoRepository.findByIdProyecto(idProyecto)
				.stream()
				.filter(x -> x.getEnable() == 1 && x.getJefatura().getEnable() == 1 && x.getProyecto().getEnable() == 1)
				.collect(Collectors.toList());

		
		Periodo periodo = periodoRepository.findById(idPeriodo).get();
		
		for (JefaturaProyecto jefaturaProyecto : listJefaturaProyecto) {
			List<Vendedor> listVendedor = vendedorRepository.findByIdJefatura(jefaturaProyecto.getJefatura().getIdJefatura())
					.stream()
					.filter(x -> x.getEnable() == 1 )
					.collect(Collectors.toList());
			
			for (Vendedor vendedor : listVendedor) {
				ConsolidadoProyectoResponse res = new ConsolidadoProyectoResponse();
				res.setVendedor(vendedor);
				List<PeriodoColaborador> listPeriodoColaborador = periodoColaboradorRepository.findByIdColaborador(vendedor.getIdColaborador())
						.stream()
						.filter(x -> x.getEnable() == 1 && x.getPeriodo().getEnable() == 1 )
						.collect(Collectors.toList());
				List<PeriodoColaborador> listPeriodoColaborador1 = listPeriodoColaborador.stream().filter(p -> p.getPeriodo().getIdPeriodo() == idPeriodo).collect(Collectors.toList());
				if ( listPeriodoColaborador1.size() > 0) {
					res.setMeta(listPeriodoColaborador1.get(0).getMeta());
				}
				
				List<Venta> listVentas = ventaRepository.findByIdVendedor(vendedor.getIdVendedor())
						.stream()
						.filter(x -> x.getEnable() == 1 )
						.collect(Collectors.toList());
				
				List<Venta> listVentasResult = listVentas.stream().filter(v -> v.getFechaRegistro().getTime() >= periodo.getFechaInicio().getTime() && v.getFechaRegistro().getTime() <= periodo.getFechaFin().getTime() ).collect(Collectors.toList());
				
				List<Venta> listVentasResultPago = listVentas.stream().filter(v ->
				v.getFechaMinuta() != null && v.getEstadoVenta().getIdEstadoVenta() != 14
						).collect(Collectors.toList());
				
				double suma = listVentasResultPago.stream()
			      .mapToDouble(o -> o.getTotal().doubleValue()
			    	  //pagoRepository.findByIdVenta(o.getIdVenta()).stream().mapToDouble(p -> p.getMonto().doubleValue()).sum()
			    ).sum();
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
			
		}
		return listResponse;
	}
	

}
