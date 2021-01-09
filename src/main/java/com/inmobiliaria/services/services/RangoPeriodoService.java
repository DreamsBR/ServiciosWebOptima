package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.RangoPeriodo;
import com.inmobiliaria.services.repository.RangoPeriodoRepository;

@Service
@Transactional(readOnly=true)
public class RangoPeriodoService {
	@Autowired
	private RangoPeriodoRepository reporsitory;
	@Transactional
	public RangoPeriodo registrar(RangoPeriodo reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(RangoPeriodo reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public RangoPeriodo update(RangoPeriodo reg) {
		return reporsitory.save(reg);
	}
	public RangoPeriodo findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<RangoPeriodo> findAll() {
		return reporsitory.findAll();
	}
	public Page<RangoPeriodo> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public List<RangoPeriodo> findByIdRango(Integer idRango) {
		return reporsitory.findByIdRango(idRango);
	}
}