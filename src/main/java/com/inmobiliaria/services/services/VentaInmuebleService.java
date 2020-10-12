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

import com.inmobiliaria.services.repository.VentaInmuebleRepository; 
import com.inmobiliaria.services.model.VentaInmueble;

@Service
@Transactional(readOnly=true)
public class VentaInmuebleService {
	@Autowired
	private VentaInmuebleRepository reporsitory;
	@Transactional
	public VentaInmueble registrar(VentaInmueble reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(VentaInmueble reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public VentaInmueble update(VentaInmueble reg) {
		return reporsitory.save(reg);
	}
	public VentaInmueble findById(Integer id) {
		return reporsitory.getOne(id);
	}
	public List<VentaInmueble> findAll() {
		return reporsitory.findAll();
	}
	public Page<VentaInmueble> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}