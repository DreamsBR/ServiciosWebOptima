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

import com.inmobiliaria.services.repository.TipoCreditoRepository; 
import com.inmobiliaria.services.model.TipoCredito;

@Service
@Transactional(readOnly=true)
public class TipoCreditoService {
	@Autowired
	private TipoCreditoRepository reporsitory;
	@Transactional
	public TipoCredito registrar(TipoCredito reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(TipoCredito reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public TipoCredito update(TipoCredito reg) {
		return reporsitory.save(reg);
	}
	public TipoCredito findById(Integer id) {
		return reporsitory.getOne(id);
	}
	public List<TipoCredito> findAll() {
		return reporsitory.findAll();
	}
	public Page<TipoCredito> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}