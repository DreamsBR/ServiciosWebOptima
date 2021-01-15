package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.PeriodoColaborador;
import com.inmobiliaria.services.model.request.PeriodoColaboradorRequest;
import com.inmobiliaria.services.repository.PeriodoColaboradorRepository;
import com.inmobiliaria.services.repository.PeriodoRepository;
@Service
@Transactional(readOnly=true)
public class PeriodoColaboradorService {
	@Autowired
	private PeriodoColaboradorRepository reporsitory;
	@Autowired
	private PeriodoRepository periodoRepository;
	@Transactional
	public PeriodoColaborador registrar(PeriodoColaboradorRequest reg) {
		reg.setEnable((byte) 1);
		PeriodoColaborador periodoColaborador = mapperPeriodoColaborador(reg);
		return reporsitory.save(periodoColaborador);
	}
	@Transactional
	public void delete(PeriodoColaborador reg) {
		reg.setEnable((byte) 0);
		reporsitory.save(reg);
	}
	@Transactional
	public PeriodoColaborador update(PeriodoColaboradorRequest reg) {
		PeriodoColaborador periodoColaborador = mapperPeriodoColaborador(reg);
		return reporsitory.save(periodoColaborador);
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
	public List<PeriodoColaborador> findByIdColaborador(Integer idColaborador) {
		return reporsitory.findByIdColaborador(idColaborador);
	}
	private PeriodoColaborador mapperPeriodoColaborador(PeriodoColaboradorRequest reg) {
		PeriodoColaborador periodoColaborador = new PeriodoColaborador();
		periodoColaborador.setEnable(reg.getEnable());
		periodoColaborador.setIdColaborador(reg.getIdColaborador());
		periodoColaborador.setIdPeriodoColaborador(reg.getIdPeriodoColaborador());
		periodoColaborador.setMeta(reg.getMeta());
		periodoColaborador.setPeriodo(periodoRepository.findById(reg.getIdPeriodo()).get());
		return periodoColaborador;
	}
}
