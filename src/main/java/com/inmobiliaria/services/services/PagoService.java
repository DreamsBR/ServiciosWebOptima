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
import com.inmobiliaria.services.model.Pago;

@Service
@Transactional(readOnly=true)
public class PagoService {
	@Autowired
	private PagoRepository reporsitory;
	@Transactional
	public Pago registrar(Pago reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Pago reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Pago update(Pago reg) {
		return reporsitory.save(reg);
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