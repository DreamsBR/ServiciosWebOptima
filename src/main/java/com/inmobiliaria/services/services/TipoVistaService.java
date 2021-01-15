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

import com.inmobiliaria.services.model.TipoVista;
import com.inmobiliaria.services.repository.TipoVistaRepository;

@Service
@Transactional(readOnly=true)
public class TipoVistaService {
	@Autowired
	private TipoVistaRepository reporsitory;
	@Transactional
	public TipoVista registrar(TipoVista reg) {
		reg.setEnable((byte) 1);
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(TipoVista reg) {
		reg.setEnable((byte) 0);
		reporsitory.save(reg);
	}
	@Transactional
	public TipoVista update(TipoVista reg) {
		return reporsitory.save(reg);
	}
	public TipoVista findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<TipoVista> findAll() {
		return reporsitory.findAll();
	}
	public Page<TipoVista> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}