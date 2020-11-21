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

import com.inmobiliaria.services.repository.MotivoRepository; 
import com.inmobiliaria.services.model.Motivo;

@Service
@Transactional(readOnly=true)
public class MotivoService {
	@Autowired
	private MotivoRepository reporsitory;
	@Transactional
	public Motivo registrar(Motivo reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Motivo reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Motivo update(Motivo reg) {
		return reporsitory.save(reg);
	}
	public Motivo findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Motivo> findAll() {
		return reporsitory.findAll();
	}
	public Page<Motivo> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}