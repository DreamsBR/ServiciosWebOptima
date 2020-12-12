package com.inmobiliaria.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.VentaFiles;
import com.inmobiliaria.services.model.request.VentaFilesRequest;
import com.inmobiliaria.services.repository.EstadoVentaRepository;
import com.inmobiliaria.services.repository.VentaFilesRepository;
@Service
@Transactional(readOnly=true)
public class VentaFilesService {
	@Autowired
	private VentaFilesRepository repository;
	@Autowired
	private EstadoVentaRepository estadoVentaRepository;
	@Transactional
	public VentaFiles registrar(VentaFilesRequest reg) {
		VentaFiles ventaFiles = mapperVentaFiles(reg);
		return repository.save(ventaFiles);
	}
	private VentaFiles mapperVentaFiles(VentaFilesRequest reg) {
		VentaFiles ventaFiles = new VentaFiles();
		ventaFiles.setFileRuta(reg.getFileRuta());
		ventaFiles.setIdVenta(reg.getIdVenta());
		ventaFiles.setIdVentaFiles(reg.getIdVentaFiles());
		ventaFiles.setEstadoVenta(estadoVentaRepository.findById(reg.getIdEstadoVenta()).get());
		return ventaFiles;
	}
	@Transactional
	public void delete(VentaFiles reg) {
		repository.delete(reg);
	}
	@Transactional
	public VentaFiles update(VentaFilesRequest reg) {
		VentaFiles ventaFiles = mapperVentaFiles(reg);
		return repository.save(ventaFiles);
	}
	public VentaFiles findById(Integer id) {
		return repository.findById(id).get();
	}
	public List<VentaFiles> findAll() {
		return repository.findAll();
	}
	public Page<VentaFiles> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	public List<VentaFiles> findByIdVenta(Integer idVenta) {
		return repository.findByIdVenta(idVenta);
	}
}
