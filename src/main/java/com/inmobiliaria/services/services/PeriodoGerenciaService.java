package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.PeriodoGerencia;
import com.inmobiliaria.services.repository.PeriodoGerenciaRepository;
@Service
@Transactional(readOnly=true)
public class PeriodoGerenciaService {
	@Autowired
	private PeriodoGerenciaRepository reporsitory;
	@Transactional
	public PeriodoGerencia registrar(PeriodoGerencia reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(PeriodoGerencia reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public PeriodoGerencia update(PeriodoGerencia reg) {
		return reporsitory.save(reg);
	}
	public PeriodoGerencia findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<PeriodoGerencia> findAll() {
		return reporsitory.findAll();
	}
	public Page<PeriodoGerencia> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}
