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

import com.inmobiliaria.services.model.EstadoCivil;
import com.inmobiliaria.services.repository.EstadoCivilRepository;

@Service
@Transactional(readOnly=true)
public class EstadoCivilService {
	@Autowired
	private EstadoCivilRepository reporsitory;
	@Transactional
	public EstadoCivil registrar(EstadoCivil reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(EstadoCivil reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public EstadoCivil update(EstadoCivil reg) {
		return reporsitory.save(reg);
	}
	public EstadoCivil findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<EstadoCivil> findAll() {
		return reporsitory.findAll();
	}
	public Page<EstadoCivil> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}