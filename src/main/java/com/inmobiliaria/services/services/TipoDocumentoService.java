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

import com.inmobiliaria.services.model.TipoDocumento;
import com.inmobiliaria.services.repository.TipoDocumentoRepository;

@Service
@Transactional(readOnly=true)
public class TipoDocumentoService {
	@Autowired
	private TipoDocumentoRepository reporsitory;
	@Transactional
	public TipoDocumento registrar(TipoDocumento reg) {
		reg.setEnable((byte) 1);
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(TipoDocumento reg) {
		reg.setEnable((byte) 0);
		reporsitory.save(reg);
	}
	@Transactional
	public TipoDocumento update(TipoDocumento reg) {
		return reporsitory.save(reg);
	}
	public TipoDocumento findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<TipoDocumento> findAll() {
		return reporsitory.findAll();
	}
	public Page<TipoDocumento> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}