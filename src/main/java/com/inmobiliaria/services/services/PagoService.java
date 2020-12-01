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

import com.inmobiliaria.services.repository.PagoRepository;
import com.inmobiliaria.services.repository.VentaRepository;
import com.inmobiliaria.services.model.Pago;
import com.inmobiliaria.services.model.request.PagoRequest;

@Service
@Transactional(readOnly=true)
public class PagoService {
	@Autowired
	private PagoRepository reporsitory;
	@Autowired
	private VentaRepository ventaRepository;
	@Transactional
	public Pago registrar(PagoRequest reg) {
		Pago pago = mapperPago(reg);
		return reporsitory.save(pago);
	}
	@Transactional
	public void delete(Pago reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Pago update(PagoRequest reg) {
		Pago pago = mapperPago(reg);
		return reporsitory.save(pago);
	}
	private Pago mapperPago(PagoRequest reg) {
		Pago pago = new Pago();
		pago.setEnable(reg.getEnable());
		pago.setFecha(reg.getFecha());
		pago.setIdPago(reg.getIdPago());
		pago.setMonto(reg.getMonto());
		pago.setNumeroOperacion(reg.getNumeroOperacion());
		pago.setPagado(reg.getPagado());
		pago.setPorcentaje(reg.getPorcentaje());
		pago.setVenta(ventaRepository.findById(reg.getIdVenta()).get());
		return pago;
	}
	public Pago findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Pago> findAll() {
		return reporsitory.findAll();
	}
	public Page<Pago> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public List<Pago> findByIdVenta(Integer idVenta) {
		return reporsitory.findByIdVenta(idVenta);
	}
}