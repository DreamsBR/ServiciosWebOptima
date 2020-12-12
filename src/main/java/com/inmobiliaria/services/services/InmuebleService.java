/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.repository.InmuebleRepository;
import com.inmobiliaria.services.repository.TipoInmuebleCategoriaRepository;
import com.inmobiliaria.services.repository.TipoInmuebleRepository;
import com.inmobiliaria.services.repository.TipoVistaRepository;
import com.inmobiliaria.services.repository.VentaInmuebleRepository;
import com.inmobiliaria.services.repository.VentaRepository;
import com.inmobiliaria.services.model.Inmueble;
import com.inmobiliaria.services.model.Venta;
import com.inmobiliaria.services.model.VentaInmueble;
import com.inmobiliaria.services.model.request.InmuebleRequest;

@Service
@Transactional(readOnly=true)
public class InmuebleService {
	@Autowired
	private InmuebleRepository reporsitory;
	@Autowired
	private TipoInmuebleRepository tipoInmuebleRepository;
	@Autowired
	private TipoInmuebleCategoriaRepository tipoInmuebleCategoriaRepository;
	@Autowired
	private TipoVistaRepository tipoVistaRepository;
	@Autowired
	private VentaInmuebleRepository ventaInmuebleRepository;
	@Autowired
	private VentaRepository ventaRepository;
	@Transactional
	public Inmueble registrar(InmuebleRequest reg) {
		reg.setEnable((byte) 1);
		Inmueble inmueble = mapperInmueble(reg);
		return reporsitory.save(inmueble);
	}
	@Transactional
	public void delete(Inmueble reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Inmueble update(InmuebleRequest reg) {
		Inmueble inmueble = mapperInmueble(reg);
		return reporsitory.save(inmueble);
	}
	private Inmueble mapperInmueble(InmuebleRequest reg) {
		Inmueble inmueble = new Inmueble();
		inmueble.setAreaLibre(reg.getAreaLibre());
		inmueble.setAreaTechada(reg.getAreaTechada());
		inmueble.setAreaTotal(reg.getAreaTotal());
		inmueble.setCantidadDormitorio(reg.getCantidadDormitorio());
		inmueble.setEnable(reg.getEnable());
		inmueble.setIdInmueble(reg.getIdInmueble());
		inmueble.setIdProyecto(reg.getIdProyecto());
		inmueble.setNumero(reg.getNumero());
		inmueble.setPrecio(reg.getPrecio());
		inmueble.setTipoInmueble(tipoInmuebleRepository.findById(reg.getIdTipoInmueble()).get());
		inmueble.setTipoInmuebleCategoria(tipoInmuebleCategoriaRepository.findById(reg.getIdTipoInmuebleCategoria()).get());
		inmueble.setTipoVista(tipoVistaRepository.findById(reg.getIdTipoVista()).get());
		return inmueble;
	}
	public Inmueble findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Inmueble> findAll() {
		return reporsitory.findAll();
	}
	public Page<Inmueble> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public Inmueble searchByNumero(Integer idProyecto, Integer idTipoInmueble, String numero) {
		return reporsitory.findByIdProyectoAndIdTipoInmuebleAndNumero(idProyecto, idTipoInmueble, numero);
	}
	public List<Inmueble> searchByCategoria(Integer idProyecto, Integer idTipoInmueble, Integer idTipoInmuebleCategoria) {
		return reporsitory.findByIdProyectoAndIdTipoInmuebleAndIdTipoInmuebleCategoria(idProyecto, idTipoInmueble, idTipoInmuebleCategoria);
	}
	public List<Inmueble> searchDisponibles(Integer idProyecto, Integer idTipoInmueble, Integer idTipoInmuebleCategoria) {
		List<Inmueble> listNew = new ArrayList<>();
		boolean permitir;
		List<Inmueble> list = reporsitory.findByIdProyectoAndIdTipoInmuebleAndIdTipoInmuebleCategoria(idProyecto, idTipoInmueble, idTipoInmuebleCategoria);
		for (Inmueble inmueble : list) {
			
			List<VentaInmueble> ventas = ventaInmuebleRepository.findByIdInmueble(inmueble.getIdInmueble());

			if (ventas.size() == 0 ) {
				listNew.add(inmueble);
			}else {
				permitir = true;
				for (VentaInmueble ventaInmueble : ventas) {
					Venta venta = ventaRepository.findById(ventaInmueble.getIdVenta()).get();
					if (venta.getEstadoVenta().getIdEstadoVenta() != 14) {
						permitir = false;
					}
				}
				if ( permitir ) {
					listNew.add(inmueble);
				}
			}
		}
		return listNew;
	
	}
	public List<Inmueble> searchByProyecto(Integer idProyecto) {
		return reporsitory.findByIdProyecto(idProyecto);
	}
}