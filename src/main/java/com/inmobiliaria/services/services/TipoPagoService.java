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

import com.inmobiliaria.services.model.TipoPago;
import com.inmobiliaria.services.repository.TipoPagoRepository;

@Service
@Transactional(readOnly=true)
public class TipoPagoService {
	@Autowired
	private TipoPagoRepository reporsitory;
	@Transactional
	public TipoPago registrar(TipoPago reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(TipoPago reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public TipoPago update(TipoPago reg) {
		return reporsitory.save(reg);
	}
	public TipoPago findById(Integer id) {
		return reporsitory.getOne(id);
	}
	public List<TipoPago> findAll() {
		return reporsitory.findAll();
	}
	public Page<TipoPago> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}