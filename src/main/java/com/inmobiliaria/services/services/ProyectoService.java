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

import com.inmobiliaria.services.repository.ProyectoRepository; 
import com.inmobiliaria.services.model.Proyecto;

@Service
@Transactional(readOnly=true)
public class ProyectoService {
	@Autowired
	private ProyectoRepository reporsitory;
	@Transactional
	public Proyecto registrar(Proyecto reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Proyecto reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Proyecto update(Proyecto reg) {
		return reporsitory.save(reg);
	}
	public Proyecto findById(Integer id) {
		return reporsitory.getOne(id);
	}
	public List<Proyecto> findAll() {
		return reporsitory.findAll();
	}
	public Page<Proyecto> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}