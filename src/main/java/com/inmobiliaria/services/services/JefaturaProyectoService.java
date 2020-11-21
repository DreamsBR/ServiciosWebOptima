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

import com.inmobiliaria.services.repository.JefaturaProyectoRepository; 
import com.inmobiliaria.services.model.JefaturaProyecto;

@Service
@Transactional(readOnly=true)
public class JefaturaProyectoService {
	@Autowired
	private JefaturaProyectoRepository reporsitory;
	@Transactional
	public JefaturaProyecto registrar(JefaturaProyecto reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(JefaturaProyecto reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public JefaturaProyecto update(JefaturaProyecto reg) {
		return reporsitory.save(reg);
	}
	public JefaturaProyecto findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<JefaturaProyecto> findAll() {
		return reporsitory.findAll();
	}
	public Page<JefaturaProyecto> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}