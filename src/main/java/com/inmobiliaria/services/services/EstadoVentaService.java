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

import com.inmobiliaria.services.model.EstadoVenta;
import com.inmobiliaria.services.repository.EstadoVentaRepository;

@Service
@Transactional(readOnly=true)
public class EstadoVentaService {
	@Autowired
	private EstadoVentaRepository reporsitory;
	@Transactional
	public EstadoVenta registrar(EstadoVenta reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(EstadoVenta reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public EstadoVenta update(EstadoVenta reg) {
		return reporsitory.save(reg);
	}
	public EstadoVenta findById(Integer id) {
		return reporsitory.getOne(id);
	}
	public List<EstadoVenta> findAll() {
		return reporsitory.findAll();
	}
	public Page<EstadoVenta> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}