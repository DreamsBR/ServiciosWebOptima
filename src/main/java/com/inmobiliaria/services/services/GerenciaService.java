/**
 * @author Walter Canchan
 * @email wcanchan@gmail.com
 */
package com.inmobiliaria.services.services;

import java.util.List;
import java.util.stream.Collectors;

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
import com.inmobiliaria.services.model.request.GerenciaRequest;
import com.inmobiliaria.services.model.response.GerenciaResponse;

@Service
@Transactional(readOnly=true)
public class GerenciaService {
	@Autowired
	private GerenciaRepository reporsitory;
	@Autowired
	private JefaturaRepository jefaturaRepository;
	@Autowired
	private ProyectoRepository proyectoRepository;
	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@Transactional
	public Gerencia registrar(GerenciaRequest reg) {
		reg.setEnable((byte) 1);
		Gerencia gerencia = mapperGerencia(reg);
		return reporsitory.save(gerencia);
	}
	@Transactional
	public void delete(Gerencia reg) {
		reg.setEnable((byte) 0);
		reporsitory.save(reg);
	}
	@Transactional
	public Gerencia update(GerenciaRequest reg) {
		Gerencia gerencia = mapperGerencia(reg);
		return reporsitory.save(gerencia);
	}
	private Gerencia mapperGerencia(GerenciaRequest reg) {
		Gerencia gerencia = new Gerencia();
		gerencia.setColaborador(colaboradorRepository.findById(reg.getIdGerente()).get());
		gerencia.setFechaIngreso(reg.getFechaIngreso());
		gerencia.setFechaTermino(reg.getFechaTermino());
		gerencia.setIdGerencia(reg.getIdGerencia());
		gerencia.setEnable(reg.getEnable());
		gerencia.setNombre(reg.getNombre());
		return gerencia;
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
		response.setGerencia(reporsitory.findById(id).get());
		response.setGerente(response.getGerencia().getColaborador());
		response.setListJefatura(jefaturaRepository.findByIdGerencia(id).stream().filter(x -> x.getEnable() == 1).collect(Collectors.toList()));
		response.setListProyecto(proyectoRepository.findByIdGerencia(id).stream().filter(x -> x.getEnable() == 1).collect(Collectors.toList()));
		return response;
	}
	public GerenciaResponse findByIdColaborador(Integer idColaborador) {
		List<Gerencia> listGerencia = reporsitory.findByIdColaborador(idColaborador);
		return this.findGerencia(listGerencia.get(0).getIdGerencia());
	}


}