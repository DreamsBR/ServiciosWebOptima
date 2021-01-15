package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.PeriodoProyecto;
import com.inmobiliaria.services.model.request.PeriodoProyectoRequest;
import com.inmobiliaria.services.repository.PeriodoProyectoRepository;
import com.inmobiliaria.services.repository.PeriodoRepository;
import com.inmobiliaria.services.repository.ProyectoRepository;
@Service
@Transactional(readOnly=true)
public class PeriodoProyectoService {
	@Autowired
	private PeriodoProyectoRepository reporsitory;
	@Autowired
	private PeriodoRepository periodoRepository;
	@Autowired
	private ProyectoRepository proyectoRepository;
	@Transactional
	public PeriodoProyecto registrar(PeriodoProyectoRequest reg) {
		reg.setEnable((byte) 1);
		PeriodoProyecto periodoProyecto = mapperPeriodoProyecto(reg);
		return reporsitory.save(periodoProyecto);
	}
	@Transactional
	public void delete(PeriodoProyecto reg) {
		reg.setEnable((byte) 0);
		reporsitory.save(reg);
	}
	@Transactional
	public PeriodoProyecto update(PeriodoProyectoRequest reg) {
		PeriodoProyecto periodoProyecto = mapperPeriodoProyecto(reg);
		return reporsitory.save(periodoProyecto);
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
	private PeriodoProyecto mapperPeriodoProyecto(PeriodoProyectoRequest reg) {
		PeriodoProyecto periodoProyecto = new PeriodoProyecto();
		periodoProyecto.setEnable(reg.getEnable());
		periodoProyecto.setIdPeriodoProyecto(reg.getIdPeriodoProyecto());
		periodoProyecto.setMeta(reg.getMeta());
		periodoProyecto.setPeriodo(periodoRepository.findById(reg.getIdPeriodo()).get());
		periodoProyecto.setProyecto(proyectoRepository.findById(reg.getIdProyecto()).get());
		return periodoProyecto;
	}
	public List<PeriodoProyecto> findByIdProyecto(Integer idProyecto) {
		return reporsitory.findByIdProyecto(idProyecto);
	}
	public List<PeriodoProyecto> findByIdPeriodo(Integer idPeriodo) {
		return reporsitory.findByIdPeriodo(idPeriodo);
	}
}
