/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.repository.CanalRepository;
import com.inmobiliaria.services.repository.CategoriaRepository;
import com.inmobiliaria.services.repository.ClienteRepository;
import com.inmobiliaria.services.repository.EstadoVentaRepository;
import com.inmobiliaria.services.repository.FinanciamientoRepository;
import com.inmobiliaria.services.repository.MotivoRepository;
import com.inmobiliaria.services.repository.VendedorRepository;
import com.inmobiliaria.services.repository.VentaRepository; 
import com.inmobiliaria.services.model.Venta;
import com.inmobiliaria.services.model.request.VentaRequest;
import com.inmobiliaria.services.model.response.VentaInmuebleProyectoResponse;

@Service
@Transactional(readOnly=true)
public class VentaService {
	@Autowired
	private VentaRepository reporsitory;
	@Autowired
	private CanalRepository canalRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EstadoVentaRepository estadoVentaRepository;
	@Autowired
	private FinanciamientoRepository financiamientoRepository;
	@Autowired
	private MotivoRepository motivoRepository;
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	EntityManager em;
	
	@Transactional
	public Venta registrar(VentaRequest reg) {
		Venta venta = mapperVenta(reg);
		venta.setFechaRegistro(new Date());
		return reporsitory.save(venta);
	}
	@Transactional
	public void delete(Venta reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Venta update(VentaRequest reg) {
		Venta venta = mapperVenta(reg);
		return reporsitory.save(venta);
	}
	public Venta findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Venta> findAll() {
		return reporsitory.findAll();
	}
	public Page<Venta> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public Page<Venta> findByIdProyecto(Integer idProyecto, Pageable pageable) {
		return reporsitory.findByIdProyecto(idProyecto, pageable);
	}

	public List<Venta> findByIdProyectoAndIdEstadoVenta(Integer idProyecto, Integer idEstadoVenta, Date fechaIni, Date fechaFin) {
		List<Venta> lst = reporsitory.findByIdProyectoAndIdEstadoVenta(idProyecto, idEstadoVenta);
		List<Venta> filterlst;
		switch (idEstadoVenta) {
		case 1:
			filterlst = lst.stream().filter(str -> str.getFechaSeparacion().getTime() >= fechaIni.getTime() && str.getFechaSeparacion().getTime() <= fechaFin.getTime()).collect(Collectors.toList());
			break;
		case 12:
			filterlst = lst.stream().filter(str -> str.getFechaDesembolso().getTime() >= fechaIni.getTime() && str.getFechaDesembolso().getTime() <= fechaFin.getTime()).collect(Collectors.toList());
			break;
		case 13:
			filterlst = lst.stream().filter(str -> str.getFechaEpp().getTime() >= fechaIni.getTime() && str.getFechaEpp().getTime() <= fechaFin.getTime()).collect(Collectors.toList());
			break;
		case 14:
			filterlst = lst.stream().filter(str -> str.getFechaCaida().getTime() >= fechaIni.getTime() && str.getFechaCaida().getTime() <= fechaFin.getTime()).collect(Collectors.toList());
			break;
		case 5:
			filterlst = lst.stream().filter(str -> str.getFechaMinuta().getTime() >= fechaIni.getTime() && str.getFechaMinuta().getTime() <= fechaFin.getTime()).collect(Collectors.toList());
			break;
		default:
			filterlst = lst;
			break;
		}
		return filterlst;
	}
	public List<Venta> findByProyectoAndIdEstadoVenta(Integer idProyecto, Integer idEstadoVenta){
		return reporsitory.findByIdProyectoAndIdEstadoVenta(idProyecto, idEstadoVenta);
	}
	public List<VentaInmuebleProyectoResponse> findByProyectoAndEstadoVenta(Integer idProyecto, Integer idEstadoVenta) {
		
		List<VentaInmuebleProyectoResponse> response = new ArrayList<>();
		String nativeQuery = "SELECT "
		  		+ "	c.id_cliente		idCliente, " 
		  		+ "	c.nombres, "
		  		+ "	c.apellidos, "
		  		+ "	td.nombre		tipoDocumento,"
		  		+ "	c.nro_documento		nroDocumento,"
		  		+ "	v.id_venta		idVenta, "
		  		+ "	v.importe, "
		  		+ " v.fecha_separacion	fechaSeparacion, "
		  		+ " v.fecha_minuta		fechaMinuta, "
		  		+ " v.fecha_desembolso	fechaDesembolso, "
		  		+ " v.fecha_epp			fechaEpp, "
		  		+ " v.fecha_caida		fechaCaida, "
		  		+ "	ev.nombre		estado "
	  		+ " FROM venta v "
	  		+ " INNER JOIN cliente c ON c.id_cliente = v.id_cliente "
	  		+ "	INNER JOIN estado_venta ev ON ev.id_estado_venta = v.id_estado_venta "
	  		+ "	INNER JOIN tipo_documento td ON td.id_tipo_documento = c.id_tipo_documento "
	  		+ " WHERE v.id_proyecto = ? and ev.id_estado_venta = ? AND v.enable = 1";
		
	    Query query = em.createNativeQuery(nativeQuery);
	    query.setParameter(1, idProyecto);
	    query.setParameter(2, idEstadoVenta);
		
	    List<Object[]> list= query.getResultList();
	    for (Object[] objects : list) {
	    	response.add(mapperVentaInmuebleProyectoResponse(objects));
		}

	    return response;

	}
	
	private VentaInmuebleProyectoResponse mapperVentaInmuebleProyectoResponse(Object[] object) {
		VentaInmuebleProyectoResponse response = new VentaInmuebleProyectoResponse();
		response.setIdCliente(Integer.parseInt(object[0].toString()));
		response.setNombres(object[1].toString());
		response.setApellidos(object[2].toString());
		response.setTipoDocumento(object[3].toString());
		response.setNroDocumento(object[4].toString());
		response.setIdVenta(Integer.parseInt(object[5].toString()));
		response.setImporte(new BigDecimal(Double.parseDouble(object[6].toString())));
		response.setFechaSeparacion(object[7].toString());
		response.setFechaMinuta(object[8].toString());
		response.setFechaDesembolso(object[9].toString());
		response.setFechaEpp(object[10].toString());
		response.setFechaCaida(object[11].toString());
		response.setEstado(object[12].toString());
		return response;
	}
	private Venta mapperVenta(VentaRequest request) {
		Venta venta = new Venta();
		venta.setAyudaInicial(request.getAyudaInicial());
		venta.setCanal(canalRepository.findById(request.getIdCanal()).get());
		venta.setCategoria(categoriaRepository.findById(request.getIdCategoria()).get());
		venta.setCliente(clienteRepository.findById(request.getIdCliente()).get());
		venta.setDescuento(request.getDescuento());
		venta.setEnable(request.getEnable());
		venta.setEstadoVenta(estadoVentaRepository.findById(request.getIdEstadoVenta()).get());
		venta.setFechaCaida(request.getFechaCaida());
		venta.setFechaDesembolso(request.getFechaDesembolso());
		venta.setFechaEpp(request.getFechaEpp());
		venta.setFechaMinuta(request.getFechaMinuta());
		venta.setFechaSeparacion(request.getFechaSeparacion());
		venta.setFinanciamiento(financiamientoRepository.findById(request.getIdFinanciamiento()).get());
		venta.setIdProyecto(request.getIdProyecto());
		venta.setIdVenta(request.getIdVenta());
		venta.setImporte(request.getImporte());
		venta.setMotivo(motivoRepository.findById(request.getIdMotivo()).get());
		venta.setTotal(request.getTotal());
		venta.setVendedor(vendedorRepository.findById(request.getIdVendedor()).get());
		venta.setFechaRegistro(request.getFechaRegistro());
		return venta;
	}
	public Page<Venta> findByIdCliente(Integer idCiente, Pageable paginacion) {
		return reporsitory.findByCliente(idCiente, paginacion);
	}
}