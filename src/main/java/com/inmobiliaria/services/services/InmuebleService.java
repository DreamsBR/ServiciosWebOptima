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

import com.inmobiliaria.services.repository.InmuebleRepository; 
import com.inmobiliaria.services.model.Inmueble;

@Service
@Transactional(readOnly=true)
public class InmuebleService {
	@Autowired
	private InmuebleRepository reporsitory;
	@Transactional
	public Inmueble registrar(Inmueble reg) {
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Inmueble reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Inmueble update(Inmueble reg) {
		return reporsitory.save(reg);
	}
	public Inmueble findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Inmueble> findAll() {
		return reporsitory.findAll();
	}
	public Page<Inmueble> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
	public Inmueble searchByNumero(Integer idProyecto, Integer idTipoInmueble, String numero) {
		return reporsitory.findByIdProyectoAndIdTipoInmuebleAndNumero(idProyecto, idTipoInmueble, numero);
	}
	public List<Inmueble> searchByCategoria(Integer idProyecto, Integer idTipoInmueble, Integer idTipoInmuebleCategoria) {
		return reporsitory.findByIdProyectoAndIdTipoInmuebleAndIdTipoInmuebleCategoria(idProyecto, idTipoInmueble, idTipoInmuebleCategoria);
	}
	public List<Inmueble> searchByProyecto(Integer idProyecto) {
		return reporsitory.findByIdProyecto(idProyecto);
	}
}