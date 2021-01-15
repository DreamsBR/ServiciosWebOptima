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

import com.inmobiliaria.services.model.TipoInmueble;
import com.inmobiliaria.services.repository.TipoInmuebleRepository;

@Service
@Transactional(readOnly=true)
public class TipoInmuebleService {
	@Autowired
	private TipoInmuebleRepository reporsitory;
	@Transactional
	public TipoInmueble registrar(TipoInmueble reg) {
		reg.setEnable((byte) 1);
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(TipoInmueble reg) {
		reg.setEnable((byte) 0);
		reporsitory.save(reg);
	}
	@Transactional
	public TipoInmueble update(TipoInmueble reg) {
		return reporsitory.save(reg);
	}
	public TipoInmueble findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<TipoInmueble> findAll() {
		return reporsitory.findAll();
	}
	public Page<TipoInmueble> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}