/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
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
		reg.setEnable((byte) 1);
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
	public List<Venta> byrange(Integer idProyecto, Date ini, Date fin) {
		return reporsitory.findByFechaRegistroRange(idProyecto, ini, fin);
	}
	public List<Venta> findByIdVendedor(Integer idVendedor) {
		return reporsitory.findByIdVendedor(idVendedor);
	}
}