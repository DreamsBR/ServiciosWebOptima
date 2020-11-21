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

import com.inmobiliaria.services.repository.ColaboradorRepository;
import com.inmobiliaria.services.model.Colaborador;

@Service
@Transactional(readOnly=true)
public class ColaboradorService {
	@Autowired
	private ColaboradorRepository reporsitory;
	@Transactional
	public Colaborador registrar(Colaborador reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Colaborador reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Colaborador update(Colaborador reg) {
		return reporsitory.save(reg);
	}
	public Colaborador findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Colaborador> findAll() {
		return reporsitory.findAll();
	}
	public Page<Colaborador> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}