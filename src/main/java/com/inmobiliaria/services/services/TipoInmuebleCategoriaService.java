package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.TipoInmuebleCategoria;
import com.inmobiliaria.services.repository.TipoInmuebleCategoriaRepository;
@Service
@Transactional(readOnly=true)
public class TipoInmuebleCategoriaService {
	@Autowired
	private TipoInmuebleCategoriaRepository reporsitory;
	@Transactional
	public TipoInmuebleCategoria registrar(TipoInmuebleCategoria reg) {
		reg.setEnable((byte) 1);
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(TipoInmuebleCategoria reg) {
		reg.setEnable((byte) 0);
		reporsitory.save(reg);
	}
	@Transactional
	public TipoInmuebleCategoria update(TipoInmuebleCategoria reg) {
		return reporsitory.save(reg);
	}
	public TipoInmuebleCategoria findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<TipoInmuebleCategoria> findAll() {
		return reporsitory.findAll();
	}
	public List<TipoInmuebleCategoria> findTipoInmueble(Integer idTipoInmueble) {
		return reporsitory.findByIdTipoInmueble(idTipoInmueble);
	}
	public Page<TipoInmuebleCategoria> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}
