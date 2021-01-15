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

import com.inmobiliaria.services.repository.ColaboradorRepository;
import com.inmobiliaria.services.repository.JefaturaRepository; 
import com.inmobiliaria.services.model.Jefatura;
import com.inmobiliaria.services.model.request.JefaturaRequest;

@Service
@Transactional(readOnly=true)
public class JefaturaService {
	@Autowired
	private JefaturaRepository reporsitory;
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	@Transactional
	public Jefatura registrar(JefaturaRequest reg) {
		reg.setEnable((byte) 1);
		Jefatura jefatura = mapperJefatura(reg);
		return reporsitory.save(jefatura);
	}
	@Transactional
	public void delete(Jefatura reg) {
		reg.setEnable((byte) 0);
		reporsitory.save(reg);
	}
	@Transactional
	public Jefatura update(JefaturaRequest reg) {
		Jefatura jefatura = mapperJefatura(reg);
		return reporsitory.save(jefatura);
	}
	public Jefatura findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Jefatura> findAll() {
		return reporsitory.findAll();
	}
	public Page<Jefatura> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public List<Jefatura> findByIdGerencia(Integer idGerencia) {
		return reporsitory.findByIdGerencia(idGerencia);
	}
	private Jefatura mapperJefatura(JefaturaRequest reg) {
		Jefatura jefatura = new Jefatura();
		jefatura.setEnable(reg.getEnable());
		jefatura.setFechaIngreso(reg.getFechaIngreso());
		jefatura.setFechaTermino(reg.getFechaTermino());
		jefatura.setIdGerencia(reg.getIdGerencia());
		jefatura.setIdJefatura(reg.getIdJefatura());
		jefatura.setNombre(reg.getNombre());
		jefatura.setColaborador(colaboradorRepository.findById(reg.getIdJefeVenta()).get());
		return jefatura;
	}
}