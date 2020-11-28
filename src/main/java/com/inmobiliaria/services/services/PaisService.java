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

import com.inmobiliaria.services.repository.PaisRepository; 
import com.inmobiliaria.services.model.Pais;

@Service
@Transactional(readOnly=true)
public class PaisService {
	@Autowired
	private PaisRepository reporsitory;
	@Transactional
	public Pais registrar(Pais reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Pais reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Pais update(Pais reg) {
		return reporsitory.save(reg);
	}
	public Pais findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Pais> findAll() {
		return reporsitory.findAll();
	}
	public Page<Pais> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}