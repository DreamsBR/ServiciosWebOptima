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

import com.inmobiliaria.services.repository.BancoRepository; 
import com.inmobiliaria.services.model.Banco;

@Service
@Transactional(readOnly=true)
public class BancoService {
	@Autowired
	private BancoRepository reporsitory;
	@Transactional
	public Banco registrar(Banco entity) {
		return reporsitory.save(entity);
	}
	@Transactional
	public void delete(Banco reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Banco update(Banco entity) {
		Banco nuevo =  reporsitory.save(entity);
		return nuevo;
	}
	public Banco findById(Integer id) {
		return reporsitory.getOne(id);
	}
	public List<Banco> findAll() {
		return reporsitory.findAll();
	}
	public Page<Banco> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}