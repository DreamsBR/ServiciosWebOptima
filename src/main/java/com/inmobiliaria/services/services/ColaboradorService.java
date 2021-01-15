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
import com.inmobiliaria.services.repository.TipoDocumentoRepository;
import com.inmobiliaria.services.security.model.User;
import com.inmobiliaria.services.security.repository.UserRepository;
import com.inmobiliaria.services.model.Colaborador;
import com.inmobiliaria.services.model.request.ColaboradorRequest;

@Service
@Transactional(readOnly=true)
public class ColaboradorService {
	@Autowired
	private ColaboradorRepository reporsitory;
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
    @Autowired
    private UserRepository userRepository;
	@Transactional
	public Colaborador registrar(ColaboradorRequest reg) {
		reg.setEnable((byte) 1);
		Colaborador colaborador = mapperColaborador(reg);
		return reporsitory.save(colaborador);
	}
	@Transactional
	public void delete(Colaborador reg) {
		reg.setEnable((byte) 0);
		reporsitory.save(reg);
	}
	@Transactional
	public Colaborador update(ColaboradorRequest reg) {
		Colaborador colaborador = mapperColaborador(reg);
		return reporsitory.save(colaborador);
	}
	public Colaborador findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Colaborador> findAll() {
		return reporsitory.findAll();
	}
	public Page<Colaborador> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public List<Colaborador> findByNumeroDocumento(String numeroDocumento) {
		return reporsitory.findByNumeroDocumento(numeroDocumento);
	}
	private Colaborador mapperColaborador(ColaboradorRequest reg) {
		Colaborador colaborador = new Colaborador();
		colaborador.setApellidos(reg.getApellidos());
		colaborador.setEnable(reg.getEnable());
		colaborador.setNombres(reg.getNombres());
		colaborador.setIdColaborador(reg.getIdColaborador());
		colaborador.setNumeroDocumento(reg.getNumeroDocumento());
		colaborador.setSexo(reg.getSexo());
		colaborador.setTipoDocumento(tipoDocumentoRepository.findById(reg.getIdTipoDocumento()).get());
		return colaborador;
	}
	public List<User> findByIdColaborador(Integer idColaborador) {
		List<User> list = userRepository.findByIdColaborador(idColaborador);
		for (int i = 0; i < list.size(); i++) {
			 list.get(i).setPassword("");
		}
		return list;
	}
}