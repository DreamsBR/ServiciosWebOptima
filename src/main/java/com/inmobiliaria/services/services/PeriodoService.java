package com.inmobiliaria.services.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.Periodo;
import com.inmobiliaria.services.repository.PeriodoRepository;

@Service
@Transactional(readOnly=true)
public class PeriodoService {
	@Autowired
	private PeriodoRepository reporsitory;
	@Transactional
	public Periodo registrar(Periodo reg) {
		reg.setEnable((byte) 1);
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Periodo reg) {
		reg.setEnable((byte) 0);
		reporsitory.save(reg);
	}
	@Transactional
	public Periodo update(Periodo reg) {
		return reporsitory.save(reg);
	}
	public Periodo findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Periodo> findAll() {
		return reporsitory.findAll();
	}
	public Page<Periodo> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public Collection<Periodo> findByIdTipoPeriodo(Integer idTipoPeriodo) {
		return reporsitory.findByIdTipoPeriodo(idTipoPeriodo);
	}
	public Page<Periodo> findAllEnable(Pageable paginacion) {
		return reporsitory.findAllEnable(paginacion);
	}
}
