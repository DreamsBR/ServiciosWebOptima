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

import com.inmobiliaria.services.repository.JefaturaProyectoRepository;
import com.inmobiliaria.services.repository.JefaturaRepository;
import com.inmobiliaria.services.repository.ProyectoRepository;
import com.inmobiliaria.services.model.JefaturaProyecto;
import com.inmobiliaria.services.model.request.JefaturaProyectoRequest;

@Service
@Transactional(readOnly=true)
public class JefaturaProyectoService {
	@Autowired
	private JefaturaProyectoRepository repository;
	@Autowired
	private JefaturaRepository jefaturaRepository;
	@Autowired
	private ProyectoRepository proyectoRepository;
	@Transactional
	public JefaturaProyecto registrar(JefaturaProyectoRequest reg) {
		JefaturaProyecto jefaturaProyecto = mapperJefaturaProyecto(reg);
		return repository.save(jefaturaProyecto);
	}
	@Transactional
	public void delete(JefaturaProyecto reg) {
		repository.delete(reg);
	}
	@Transactional
	public JefaturaProyecto update(JefaturaProyectoRequest reg) {
		JefaturaProyecto jefaturaProyecto = mapperJefaturaProyecto(reg);
		return repository.save(jefaturaProyecto);
	}
	private JefaturaProyecto mapperJefaturaProyecto(JefaturaProyectoRequest reg) {
		JefaturaProyecto jefaturaProyecto = new JefaturaProyecto();
		jefaturaProyecto.setEnable(reg.getEnable());
		jefaturaProyecto.setIdJefaturaProyecto(reg.getIdJefaturaProyecto());
		jefaturaProyecto.setJefatura(jefaturaRepository.findById(reg.getIdJefatura()).get());
		jefaturaProyecto.setProyecto(proyectoRepository.findById(reg.getIdProyecto()).get());
		return jefaturaProyecto;
	}
	public JefaturaProyecto findById(Integer id) {
		return repository.findById(id).get();
	}
	public List<JefaturaProyecto> findAll() {
		return repository.findAll();
	}
	public Page<JefaturaProyecto> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	public List<JefaturaProyecto> findByProyecto(Integer idProyecto) {
		return repository.findByIdProyecto(idProyecto);
	}
	public List<JefaturaProyecto> findByJefatura(Integer idJefatura) {
		return repository.findByIdJefatura(idJefatura);
	}
}