package com.example.turismo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.turismo.entity.DepartamentoEntity;
import com.example.turismo.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	Logger logger = LoggerFactory.getLogger(DepartamentoService.class);
	
	@Autowired
	private DepartamentoRepository departamentoRepository;


	public List<DepartamentoEntity> getAllApartament() {
		return departamentoRepository.findAll();
		
	}
	
	public long countApartament() {
		return departamentoRepository.count();
	}
	
	public DepartamentoEntity getById(Integer id) {
		return departamentoRepository.findById(id).get();
	}
	
	public boolean save (DepartamentoEntity ent) {
		if(ent != null){
			departamentoRepository.save(ent);
			return true;
		}
		return false;
	}
	
}
