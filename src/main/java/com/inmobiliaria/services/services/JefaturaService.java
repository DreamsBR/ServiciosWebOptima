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

import com.inmobiliaria.services.repository.JefaturaRepository; 
import com.inmobiliaria.services.model.Jefatura;

@Service
@Transactional(readOnly=true)
public class JefaturaService {
	@Autowired
	private JefaturaRepository reporsitory;
	@Transactional
	public Jefatura registrar(Jefatura reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Jefatura reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Jefatura update(Jefatura reg) {
		return reporsitory.save(reg);
	}
	public Jefatura findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Jefatura> findAll() {
		return reporsitory.findAll();
	}
	public Page<Jefatura> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public List<Jefatura> findByIdGerencia(Integer idGerencia) {
		return reporsitory.findByIdGerencia(idGerencia);
	}
}