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

import com.inmobiliaria.services.repository.EstadoFinanciamientoRepository; 
import com.inmobiliaria.services.model.EstadoFinanciamiento;

@Service
@Transactional(readOnly=true)
public class EstadoFinanciamientoService {
	@Autowired
	private EstadoFinanciamientoRepository reporsitory;
	@Transactional
	public EstadoFinanciamiento registrar(EstadoFinanciamiento reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(EstadoFinanciamiento reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public EstadoFinanciamiento update(EstadoFinanciamiento reg) {
		return reporsitory.save(reg);
	}
	public EstadoFinanciamiento findById(Integer id) {
		return reporsitory.getOne(id);
	}
	public List<EstadoFinanciamiento> findAll() {
		return reporsitory.findAll();
	}
	public Page<EstadoFinanciamiento> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}