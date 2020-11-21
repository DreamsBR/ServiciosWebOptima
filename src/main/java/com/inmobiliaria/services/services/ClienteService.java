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

import com.inmobiliaria.services.repository.ClienteRepository; 
import com.inmobiliaria.services.model.Cliente;

@Service
@Transactional(readOnly=true)
public class ClienteService {
	@Autowired
	private ClienteRepository reporsitory;
	@Transactional
	public Cliente registrar(Cliente reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Cliente reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Cliente update(Cliente reg) {
		return reporsitory.save(reg);
	}
	public Cliente findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Cliente> findAll() {
		return reporsitory.findAll();
	}
	public Page<Cliente> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public List<Cliente> findByNroDocumento(String nroDocumento) {
		return reporsitory.findByNroDocumento(nroDocumento);
	}
}