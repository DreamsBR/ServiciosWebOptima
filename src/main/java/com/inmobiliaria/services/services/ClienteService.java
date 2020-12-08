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
import com.inmobiliaria.services.repository.EstadoCivilRepository;
import com.inmobiliaria.services.repository.PaisRepository;
import com.inmobiliaria.services.repository.TipoDocumentoRepository;
import com.inmobiliaria.services.model.Cliente;
import com.inmobiliaria.services.model.request.ClienteRequest;

@Service
@Transactional(readOnly=true)
public class ClienteService {
	@Autowired
	private ClienteRepository reporsitory;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	@Autowired
	private EstadoCivilRepository estadoCivilRepository;
	@Transactional
	public Cliente registrar(ClienteRequest reg) {
		Cliente cliente = mapperCliente(reg);
		return reporsitory.save(cliente);
	}
	@Transactional
	public void delete(Cliente reg) {
		reporsitory.delete(reg);
	}
	@Transactional
	public Cliente update(ClienteRequest reg) {
		Cliente cliente = mapperCliente(reg);
		return reporsitory.save(cliente);
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
	public List<Cliente> findByNombresAndApellidos(String nombres, String apellidos) {
		return reporsitory.findByNombresStartsWithIgnoreCaseAndApellidosStartsWithIgnoreCase(nombres, apellidos);
	}
	private Cliente mapperCliente(ClienteRequest reg) {
		Cliente cliente = new Cliente();
		cliente.setApellidos(reg.getApellidos());
		cliente.setAsesor(reg.getApellidos());
		cliente.setConyuge(reg.getConyuge());
		cliente.setDireccion(reg.getDireccion());
		cliente.setDistrito(reg.getDistrito());
		cliente.setEmail(reg.getEmail());
		cliente.setFechaNacimiento(reg.getFechaNacimiento());
		cliente.setIdCliente(reg.getIdCliente());
		cliente.setIngresos(reg.getIngresos());
		cliente.setLugarTrabajo(reg.getLugarTrabajo());
		cliente.setNombres(reg.getNombres());
		cliente.setNroDocConyuge(reg.getNroDocumentoConyuge());
		cliente.setNroDocumento(reg.getNroDocumento());
		cliente.setOcupacion(reg.getOcupacion());
		cliente.setOcupacionConyuge(reg.getOcupacionConyuge());
		cliente.setProvincia(reg.getProvincia());
		cliente.setSexo(reg.getSexo());
		cliente.setTelefono(reg.getTelefono());
		cliente.setPais(paisRepository.findById(reg.getIdPais()).get());
		cliente.setTipoDocumento(tipoDocumentoRepository.findById(reg.getIdTipoDocumento()).get());
		cliente.setTipoDocumentoConyuge(tipoDocumentoRepository.findById(reg.getIdTipoDocumentoConyuge()).get());
		cliente.setEstadoCivil(estadoCivilRepository.findById(reg.getIdEstadoCivil()).get());
		cliente.setEstadoCivilConyuge(estadoCivilRepository.findById(reg.getIdEstadoCivilConyuge()).get());
		return cliente;
	}
}