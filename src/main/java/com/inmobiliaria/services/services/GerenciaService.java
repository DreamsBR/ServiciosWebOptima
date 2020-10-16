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

import com.inmobiliaria.services.repository.GerenciaRepository;
import com.inmobiliaria.services.repository.GerenteRepository;
import com.inmobiliaria.services.repository.JefaturaRepository;
import com.inmobiliaria.services.repository.ProyectoRepository;
import com.inmobiliaria.services.model.Gerencia;
import com.inmobiliaria.services.model.response.GerenciaResponse;

@Service
@Transactional(readOnly=true)
public class GerenciaService {
	@Autowired
	private GerenciaRepository gerenciaRepository;
	@Autowired
	private GerenteRepository gerenteRepository;
	@Autowired
	private JefaturaRepository jefaturaRepository;
	@Autowired
	private ProyectoRepository proyectoRepository;
	@Transactional
	public Gerencia registrar(Gerencia reg) {
		return gerenciaRepository.save(reg);
	}
	@Transactional
	public void delete(Gerencia reg) {
		gerenciaRepository.delete(reg);
	}
	@Transactional
	public Gerencia update(Gerencia reg) {
		return gerenciaRepository.save(reg);
	}
	public Gerencia findById(Integer id) {
		return gerenciaRepository.getOne(id);
	}
	public List<Gerencia> findAll() {
		return gerenciaRepository.findAll();
	}
	public Page<Gerencia> findAll(Pageable pageable) {
		return gerenciaRepository.findAll(pageable);
	}
	public GerenciaResponse findGerencia(Integer id) {
		GerenciaResponse response = new GerenciaResponse();
		response.setGerencia(gerenciaRepository.getOne(id));
		response.setGerente(gerenteRepository.getOne(response.getGerencia().getIdGerente()));
		response.setListJefatura(jefaturaRepository.findByIdGerencia(id));
		response.setListProyecto(proyectoRepository.findByIdGerencia(id));
		return response;
	}
}