package com.example.turismo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.turismo.entity.ServicioEntity;
import com.example.turismo.repository.ServicioRepository;

@Service
public class ServicioService {

	@Autowired
	private ServicioRepository servicioRepo;
	
	public List<ServicioEntity> getAllServicios(){
		return servicioRepo.findAll();
	}
}
