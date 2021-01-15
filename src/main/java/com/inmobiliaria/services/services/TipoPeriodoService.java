package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.TipoPeriodo;
import com.inmobiliaria.services.repository.TipoPeriodoRepository;


@Service
@Transactional(readOnly=true)
public class TipoPeriodoService {
	@Autowired
	private TipoPeriodoRepository reporsitory;
	@Transactional
	public TipoPeriodo registrar(TipoPeriodo reg) {
		reg.setEnable((byte) 1);
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(TipoPeriodo reg) {
		reg.setEnable((byte) 0);
		reporsitory.save(reg);
	}
	@Transactional
	public TipoPeriodo update(TipoPeriodo reg) {
		return reporsitory.save(reg);
	}
	public TipoPeriodo findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<TipoPeriodo> findAll() {
		return reporsitory.findAll();
	}
	public Page<TipoPeriodo> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}