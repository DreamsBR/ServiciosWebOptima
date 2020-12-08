package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.PeriodoGerencia;
import com.inmobiliaria.services.model.request.PeriodoGerenciaRequest;
import com.inmobiliaria.services.repository.PeriodoGerenciaRepository;
import com.inmobiliaria.services.repository.PeriodoRepository;
@Service
@Transactional(readOnly=true)
public class PeriodoGerenciaService {
	@Autowired
	private PeriodoGerenciaRepository reporsitory;
	@Autowired
	private PeriodoRepository periodoRepository;
	@Transactional
	public PeriodoGerencia registrar(PeriodoGerenciaRequest reg) {
		reg.setEnable((byte) 1);
		PeriodoGerencia periodoGerencia = mapperPeriodoGerencia(reg);
		return reporsitory.save(periodoGerencia);
	}
	@Transactional
	public void delete(PeriodoGerencia reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public PeriodoGerencia update(PeriodoGerenciaRequest reg) {
		PeriodoGerencia periodoGerencia = mapperPeriodoGerencia(reg);
		return reporsitory.save(periodoGerencia);
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
	private PeriodoGerencia mapperPeriodoGerencia(PeriodoGerenciaRequest req) {
		PeriodoGerencia periodoGerencia = new PeriodoGerencia();
		periodoGerencia.setEnable(req.getEnable());
		periodoGerencia.setIdGerencia(req.getIdGerencia());
		periodoGerencia.setIdPeriodoGerencia(req.getIdPeriodoGerencia());
		periodoGerencia.setMeta(req.getMeta());
		periodoGerencia.setPeriodo(periodoRepository.findById(req.getIdPeriodo()).get());
		return periodoGerencia;
	}
	public List<PeriodoGerencia> findByIdGerencia(Integer idGerencia) {
		return reporsitory.findByIdGerencia(idGerencia);
	}
}
