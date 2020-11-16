package com.example.turismo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.turismo.entity.CiudadEntity;
import com.example.turismo.repository.CiudadRepository;

@Service
public class CiudadService {
	
	@Autowired
	private CiudadRepository ciudadRepo;
	
	public List<CiudadEntity> getAllCiudad() {
		return ciudadRepo.findAll();
	}

}
