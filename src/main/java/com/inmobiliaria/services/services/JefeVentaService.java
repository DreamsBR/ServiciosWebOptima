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

import com.inmobiliaria.services.repository.JefeVentaRepository; 
import com.inmobiliaria.services.model.JefeVenta;

@Service
@Transactional(readOnly=true)
public class JefeVentaService {
	@Autowired
	private JefeVentaRepository reporsitory;
	@Transactional
	public JefeVenta registrar(JefeVenta reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(JefeVenta reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public JefeVenta update(JefeVenta reg) {
		return reporsitory.save(reg);
	}
	public JefeVenta findById(Integer id) {
		return reporsitory.getOne(id);
	}
	public List<JefeVenta> findAll() {
		return reporsitory.findAll();
	}
	public Page<JefeVenta> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}