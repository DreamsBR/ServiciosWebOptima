package com.inmobiliaria.services.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.services.model.Banco;
import com.inmobiliaria.services.repository.BancoRepository;

@Service
public class BancoService {
	@Autowired
	BancoRepository repository;

	@Transactional(readOnly = true)
	public List<Banco> getAll() {
		return repository.findAll();
	}

	public Banco save(Banco entity) {
		return repository.save(entity);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Optional<Banco> findById(Integer id) {
		return repository.findById(id);
	}

	public boolean existById(Integer id) {
		return repository.existsById(id);
	}

	@Transactional
	public Page<Banco> getAll(Pageable pageable) {
		return repository.findAll(pageable);

	}

	public Banco update(Integer id, Banco entity) {
		if( repository.existsById(id) ) {
			entity.setIdbanco(id);
			return repository.save(entity);
		}
		return null;
	}
}
