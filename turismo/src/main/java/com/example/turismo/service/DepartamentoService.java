package com.example.turismo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.turismo.dto.DepartamentoDTO;
import com.example.turismo.entity.DepartamentoEntity;
import com.example.turismo.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;


	public List<DepartamentoEntity> getAllApartament() {
		return departamentoRepository.findAll();
		
	}
	
	public long countApartament() {
		return departamentoRepository.count();
	}
}
