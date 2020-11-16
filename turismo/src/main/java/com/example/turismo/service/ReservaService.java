package com.example.turismo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.turismo.entity.ReservaEntity;
import com.example.turismo.repository.ReservaRepository;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository reservaRepo;
	
	public List<ReservaEntity> getAllReserva() {
		return reservaRepo.findAll();
	}
}
