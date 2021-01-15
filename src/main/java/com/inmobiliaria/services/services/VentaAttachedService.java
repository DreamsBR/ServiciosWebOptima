package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.VentaAttached;
import com.inmobiliaria.services.repository.VentaAttachedRepository;

@Service
@Transactional(readOnly=true)
public class VentaAttachedService {
	@Autowired
	private VentaAttachedRepository reporsitory;
	@Transactional
	public VentaAttached registrar(VentaAttached reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(VentaAttached reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public VentaAttached update(VentaAttached reg) {
		return reporsitory.save(reg);
	}
	public VentaAttached findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<VentaAttached> findAll() {
		return reporsitory.findAll();
	}
	public Page<VentaAttached> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public List<VentaAttached> findByIdVenta(Integer idVenta) {
		return reporsitory.findByIdVenta(idVenta);
	}
}