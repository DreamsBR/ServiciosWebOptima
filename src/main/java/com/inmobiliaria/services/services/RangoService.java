package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.Rango;
import com.inmobiliaria.services.repository.RangoRepository;


@Service
@Transactional(readOnly=true)
public class RangoService {
	@Autowired
	private RangoRepository reporsitory;
	@Transactional
	public Rango registrar(Rango reg) {
		reg.setEnable((byte) 1);
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Rango reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Rango update(Rango reg) {
		return reporsitory.save(reg);
	}
	public Rango findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Rango> findAll() {
		return reporsitory.findAll();
	}
	public Page<Rango> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public List<Rango> findByTipoPeriodo(Integer idTipoPeriodo) {
		return reporsitory.findByIdTipoPeriodo(idTipoPeriodo);
	}
	public List<Rango> findByAnio(Integer anio) {
		return reporsitory.findByAnio(anio);
	}
	public List<Rango> findByAnioAndIdTipoPeriodo(Integer anio, Integer idTipoPeriodo) {
		return reporsitory.findByAnioAndIdTipoPeriodo(anio, idTipoPeriodo);
	}
}