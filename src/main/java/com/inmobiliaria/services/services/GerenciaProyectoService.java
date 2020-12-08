package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.GerenciaProyecto;
import com.inmobiliaria.services.model.request.GerenciaProyectoRequest;
import com.inmobiliaria.services.repository.GerenciaProyectoRepository;
import com.inmobiliaria.services.repository.GerenciaRepository;
import com.inmobiliaria.services.repository.ProyectoRepository;
@Service
@Transactional(readOnly=true)
public class GerenciaProyectoService {
	@Autowired
	private GerenciaProyectoRepository repository;
	@Autowired
	private GerenciaRepository gerenciaRepository;
	@Autowired
	private ProyectoRepository proyectoRepository;
	@Transactional
	public GerenciaProyecto registrar(GerenciaProyectoRequest reg) {
		reg.setEnable((byte) 1);
		GerenciaProyecto gerenciaProyecto = mapperGerenciaProyecto(reg);
		return repository.save(gerenciaProyecto);
	}
	@Transactional
	public void delete(GerenciaProyecto reg) {
		repository.delete(reg);
	}
	@Transactional
	public GerenciaProyecto update(GerenciaProyectoRequest reg) {
		GerenciaProyecto gerenciaProyecto = mapperGerenciaProyecto(reg);
		return repository.save(gerenciaProyecto);
	}
	private GerenciaProyecto mapperGerenciaProyecto(GerenciaProyectoRequest reg) {
		GerenciaProyecto gerenciaProyecto = new GerenciaProyecto();
		gerenciaProyecto.setEnable(reg.getEnable());
		gerenciaProyecto.setFechaTermin(reg.getFechaTermin());
		gerenciaProyecto.setFechaAsignacion(reg.getFechaAsignacion());
		gerenciaProyecto.setIdGerenciaProyecto(reg.getIdGerenciaProyecto());
		gerenciaProyecto.setGerencia(gerenciaRepository.findById(reg.getiGerencia()).get());
		gerenciaProyecto.setProyecto(proyectoRepository.findById(reg.getIdProyecto()).get());
		return gerenciaProyecto;
	}
	public GerenciaProyecto findById(Integer id) {
		return repository.findById(id).get();
	}
	public List<GerenciaProyecto> findAll() {
		return repository.findAll();
	}
	public Page<GerenciaProyecto> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	public List<GerenciaProyecto> findByIdGerencia(Integer idGerencia) {
		return repository.findByIdGerencia(idGerencia);
	}
}
