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

import com.inmobiliaria.services.repository.GerenciaProyectoRepository;
import com.inmobiliaria.services.repository.ProyectoRepository;
import com.inmobiliaria.services.model.GerenciaProyecto;
import com.inmobiliaria.services.model.Proyecto;
import com.inmobiliaria.services.model.response.ProyectoResponse;

@Service
@Transactional(readOnly=true)
public class ProyectoService {
	@Autowired
	private ProyectoRepository reporsitory;
	@Autowired
	private GerenciaProyectoRepository gerenciaProyectoRepository;
	@Transactional
	public Proyecto registrar(Proyecto reg) {
		reg.setEnable((byte) 1);
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Proyecto reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Proyecto update(Proyecto reg) {
		return reporsitory.save(reg);
	}
	public Proyecto findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Proyecto> findAll() {
		return reporsitory.findAll();
	}
	public Page<Proyecto> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public List<Proyecto> findByIdGerencia(Integer idGerencia) {
		return reporsitory.findByIdGerencia(idGerencia);
	}
	public ProyectoResponse findInfoProyecto(Integer id) {
		ProyectoResponse response = new ProyectoResponse();
		List<GerenciaProyecto> list;
		response.setProyecto(reporsitory.findById(id).get());
		list = gerenciaProyectoRepository.findByIdProyecto(id);
		if ( list.size() > 0 ) {
			response.setGerencia(list.get(0).getGerencia());

		}
		return response;
	}
}