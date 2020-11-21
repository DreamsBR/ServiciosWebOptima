/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.repository.ColaboradorRepository;
import com.inmobiliaria.services.repository.GerenciaRepository;
import com.inmobiliaria.services.repository.JefaturaRepository;
import com.inmobiliaria.services.repository.ProyectoRepository;
import com.inmobiliaria.services.model.Gerencia;
import com.inmobiliaria.services.model.response.GerenciaResponse;

@Service
@Transactional(readOnly=true)
public class GerenciaService {
	@Autowired
	private GerenciaRepository reporsitory;
	@Autowired
	private ColaboradorRepository gerenteRepository;
	@Autowired
	private JefaturaRepository jefaturaRepository;
	@Autowired
	private ProyectoRepository proyectoRepository;
	@Transactional
	public Gerencia registrar(Gerencia reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Gerencia reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Gerencia update(Gerencia reg) {
		return reporsitory.save(reg);
	}
	public Gerencia findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Gerencia> findAll() {
		return reporsitory.findAll();
	}
	public Page<Gerencia> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public GerenciaResponse findGerencia(Integer id) {
		GerenciaResponse response = new GerenciaResponse();
		response.setGerencia(reporsitory.getOne(id));
		response.setGerente(gerenteRepository.getOne(response.getGerencia().getIdGerente()));
		response.setListJefatura(jefaturaRepository.findByIdGerencia(id));
		response.setListProyecto(proyectoRepository.findByIdGerencia(id));
		return response;
	}
}