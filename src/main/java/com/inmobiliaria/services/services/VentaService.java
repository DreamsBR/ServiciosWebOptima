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

import com.inmobiliaria.services.repository.VentaRepository; 
import com.inmobiliaria.services.model.Venta;

@Service
@Transactional(readOnly=true)
public class VentaService {
	@Autowired
	private VentaRepository reporsitory;
	@Transactional
	public Venta registrar(Venta reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Venta reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Venta update(Venta reg) {
		return reporsitory.save(reg);
	}
	public Venta findById(Integer id) {
		return reporsitory.getOne(id);
	}
	public List<Venta> findAll() {
		return reporsitory.findAll();
	}
	public Page<Venta> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}