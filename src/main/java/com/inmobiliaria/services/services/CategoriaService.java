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

import com.inmobiliaria.services.repository.CategoriaRepository; 
import com.inmobiliaria.services.model.Categoria;

@Service
@Transactional(readOnly=true)
public class CategoriaService {
	@Autowired
	private CategoriaRepository reporsitory;
	@Transactional
	public Categoria registrar(Categoria reg) {
		reg.setEnable((byte) 1);
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Categoria reg) {
		reg.setEnable((byte) 0);
		reporsitory.save(reg);
	}
	@Transactional
	public Categoria update(Categoria reg) {
		return reporsitory.save(reg);
	}
	public Categoria findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Categoria> findAll() {
		return reporsitory.findAll();
	}
	public Page<Categoria> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}