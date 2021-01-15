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

import com.inmobiliaria.services.repository.CanalRepository; 
import com.inmobiliaria.services.model.Canal;

@Service
@Transactional(readOnly=true)
public class CanalService {
	@Autowired
	private CanalRepository reporsitory;
	@Transactional
	public Canal registrar(Canal reg) {
		reg.setEnable((byte) 1);
		return reporsitory.save(reg);
	}
	@Transactional
	public void delete(Canal reg) {
		reg.setEnable((byte) 0);
		reporsitory.save(reg);
	}
	@Transactional
	public Canal update(Canal reg) {
		return reporsitory.save(reg);
	}
	public Canal findById(Integer id) {
		return reporsitory.findById(id).get();
	}
	public List<Canal> findAll() {
		return reporsitory.findAll();
	}
	public Page<Canal> findAll(Pageable pageable) {
		return reporsitory.findAll(pageable);
	}
}