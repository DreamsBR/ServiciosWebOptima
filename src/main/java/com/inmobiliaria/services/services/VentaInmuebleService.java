/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.repository.InmuebleRepository;
import com.inmobiliaria.services.repository.VentaInmuebleRepository; 
import com.inmobiliaria.services.model.VentaInmueble;
import com.inmobiliaria.services.model.request.VentaInmuebleRequest;

@Service
@Transactional(readOnly=true)
public class VentaInmuebleService {
	@Autowired
	private VentaInmuebleRepository reporsitory;
	@Autowired
	private InmuebleRepository inmuebleRepository;
	
	@Transactional
	public VentaInmueble registrar(VentaInmuebleRequest reg) {
		reg.setEnable((byte) 1);
		VentaInmueble ventaInmueble = mapperVentaInmueble(reg);
		return reporsitory.save(ventaInmueble);
	}
	@Transactional
	public void delete(VentaInmueble reg) {
		reg.setEnable((byte) 0);
		reporsitory.save(reg);
	}
	@Transactional
	public VentaInmueble update(VentaInmuebleRequest reg) {
		VentaInmueble ventaInmueble = mapperVentaInmueble(reg);
		return reporsitory.save(ventaInmueble);
	}
	public VentaInmueble findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<VentaInmueble> findAll() {
		return reporsitory.findAll();
	}
	public Page<VentaInmueble> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public List<VentaInmueble> findByVenta(Integer idVenta) {
		return reporsitory.findByIdVenta(idVenta);
	}
	private VentaInmueble mapperVentaInmueble(VentaInmuebleRequest req) {
		VentaInmueble ventaInmueble = new VentaInmueble();
		ventaInmueble.setAreaLibre(req.getAreaLibre());
		ventaInmueble.setAreaTechada(req.getAreaTechada());
		ventaInmueble.setAreaTotal(req.getAreaTotal());
		ventaInmueble.setAyudainicial(req.getAyudainicial());
		ventaInmueble.setDescuento(req.getDescuento());
		ventaInmueble.setDormitorios(req.getDormitorios());
		ventaInmueble.setEnable(req.getEnable());
		ventaInmueble.setIdVenta(req.getIdVenta());
		ventaInmueble.setIdVentaInmueble(req.getIdVentaInmueble());
		ventaInmueble.setImporte(req.getImporte());
		ventaInmueble.setInmueble(inmuebleRepository.findById(req.getIdInmueble()).get());
		ventaInmueble.setPrecio(req.getPrecio());
		ventaInmueble.setVista(req.getVista());
		return ventaInmueble;
	}
}