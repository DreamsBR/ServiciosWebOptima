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

import com.inmobiliaria.services.repository.GerenteRepository; 
import com.inmobiliaria.services.model.Gerente;

@Service
@Transactional(readOnly=true)
public class GerenteService {
	@Autowired
	private GerenteRepository reporsitory;
	@Transactional
	public Gerente registrar(Gerente reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Gerente reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Gerente update(Gerente reg) {
		return reporsitory.save(reg);
	}
	public Gerente findById(Integer id) {
		return reporsitory.getOne(id);
	}
	public List<Gerente> findAll() {
		return reporsitory.findAll();
	}
	public Page<Gerente> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}