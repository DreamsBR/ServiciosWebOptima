package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.PeriodoProyecto;
import com.inmobiliaria.services.repository.PeriodoProyectoRepository;
@Service
@Transactional(readOnly=true)
public class PeriodoProyectoService {
	@Autowired
	private PeriodoProyectoRepository reporsitory;
	@Transactional
	public PeriodoProyecto registrar(PeriodoProyecto reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(PeriodoProyecto reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public PeriodoProyecto update(PeriodoProyecto reg) {
		return reporsitory.save(reg);
	}
	public PeriodoProyecto findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<PeriodoProyecto> findAll() {
		return reporsitory.findAll();
	}
	public Page<PeriodoProyecto> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}
