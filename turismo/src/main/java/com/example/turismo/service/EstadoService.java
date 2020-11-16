package com.example.turismo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.turismo.entity.EstadoEntity;
import com.example.turismo.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<EstadoEntity> getAllEstado(){
		return estadoRepository.findAll();
	}
}
