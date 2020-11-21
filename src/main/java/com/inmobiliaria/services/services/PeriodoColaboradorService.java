package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.PeriodoColaborador;
import com.inmobiliaria.services.repository.PeriodoColaboradorRepository;
@Service
@Transactional(readOnly=true)
public class PeriodoColaboradorService {
	@Autowired
	private PeriodoColaboradorRepository reporsitory;
	@Transactional
	public PeriodoColaborador registrar(PeriodoColaborador reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(PeriodoColaborador reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public PeriodoColaborador update(PeriodoColaborador reg) {
		return reporsitory.save(reg);
	}
	public PeriodoColaborador findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<PeriodoColaborador> findAll() {
		return reporsitory.findAll();
	}
	public Page<PeriodoColaborador> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}
