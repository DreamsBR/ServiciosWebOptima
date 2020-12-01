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

import com.inmobiliaria.services.repository.VendedorRepository; 
import com.inmobiliaria.services.model.Vendedor;

@Service
@Transactional(readOnly=true)
public class VendedorService {
	@Autowired
	private VendedorRepository reporsitory;
	@Transactional
	public Vendedor registrar(Vendedor reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Vendedor reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Vendedor update(Vendedor reg) {
		return reporsitory.save(reg);
	}
	public Vendedor findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Vendedor> findAll() {
		return reporsitory.findAll();
	}
	public Page<Vendedor> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public List<Vendedor> findByIdJefatura(Integer idJefatura) {
		return reporsitory.findByIdJefatura(idJefatura);
	}
}