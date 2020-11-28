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

import com.inmobiliaria.services.repository.BancoRepository;
import com.inmobiliaria.services.repository.EstadoFinanciamientoRepository;
import com.inmobiliaria.services.repository.FinanciamientoRepository;
import com.inmobiliaria.services.repository.TipoCreditoRepository;
import com.inmobiliaria.services.model.Financiamiento;
import com.inmobiliaria.services.model.request.FinanciamientoRequest;

@Service
@Transactional(readOnly=true)
public class FinanciamientoService {
	@Autowired
	private FinanciamientoRepository reporsitory;
	@Autowired
	private BancoRepository bancoRepository;
	@Autowired
	private EstadoFinanciamientoRepository estadoFinanciamientoRepository;
	@Autowired
	private TipoCreditoRepository tipoCreditoRepository;
	@Transactional
	public Financiamiento registrar(FinanciamientoRequest reg) {
		Financiamiento financiamiento = mapperFinanciamiento(reg);
		return reporsitory.save(financiamiento);
	}
	@Transactional
	public void delete(Financiamiento reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Financiamiento update(FinanciamientoRequest reg) {
		Financiamiento financiamiento = mapperFinanciamiento(reg);
		return reporsitory.save(financiamiento);
	}
	public Financiamiento findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Financiamiento> findAll() {
		return reporsitory.findAll();
	}
	public Page<Financiamiento> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	private Financiamiento mapperFinanciamiento(FinanciamientoRequest reg) {
		Financiamiento financiamiento = new Financiamiento();
		financiamiento.setAfp(reg.getAfp());
		financiamiento.setAhorro(reg.getAhorro());
		financiamiento.setAsesor(reg.getAsesor());
		financiamiento.setBanco(bancoRepository.findById(reg.getIdBanco()).get());
		financiamiento.setBono(reg.getBono());
		financiamiento.setEnable(reg.getEnable());
		financiamiento.setEstadoFinanciamiento(estadoFinanciamientoRepository.findById(reg.getIdEstadoFinanciamiento()).get());
		financiamiento.setFechaFinAhorro(reg.getFechaFinAhorro());
		financiamiento.setFechaInicioAhorro(reg.getFechaInicioAhorro());
		financiamiento.setIdFinanciamiento(reg.getIdFinanciamiento());
		financiamiento.setMontoFinanciado(reg.getMontoFinanciado());
		financiamiento.setMontoCuotaInicial(reg.getMontoCuotaInicial());
		financiamiento.setPorcCuotaInicial(reg.getPorcCuotaInicial());
		financiamiento.setTipoCredito(tipoCreditoRepository.findById(reg.getIdTipoCredito()).get());
		return financiamiento;
	}
}