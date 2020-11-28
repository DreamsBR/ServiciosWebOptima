package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.GerenciaProyecto;
import com.inmobiliaria.services.repository.GerenciaProyectoRepository;
@Service
@Transactional(readOnly=true)
public class GerenciaProyectoService {
	@Autowired
	private GerenciaProyectoRepository reporsitory;
	@Transactional
	public GerenciaProyecto registrar(GerenciaProyecto reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(GerenciaProyecto reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public GerenciaProyecto update(GerenciaProyecto reg) {
		return reporsitory.save(reg);
	}
	public GerenciaProyecto findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<GerenciaProyecto> findAll() {
		return reporsitory.findAll();
	}
	public Page<GerenciaProyecto> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}
