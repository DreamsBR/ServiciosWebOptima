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

import com.inmobiliaria.services.repository.FinanciamientoRepository; 
import com.inmobiliaria.services.model.Financiamiento;

@Service
@Transactional(readOnly=true)
public class FinanciamientoService {
	@Autowired
	private FinanciamientoRepository reporsitory;
	@Transactional
	public Financiamiento registrar(Financiamiento reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Financiamiento reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Financiamiento update(Financiamiento reg) {
		return reporsitory.save(reg);
	}
	public Financiamiento findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Financiamiento> findAll() {
		return reporsitory.findAll();
	}
	public Page<Financiamiento> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}