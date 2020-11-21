package com.example.turismo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.turismo.entity.ServicioEntity;
import com.example.turismo.repository.ServicioRepository;

@RestController
@RequestMapping("/servicio")
public class ServicioController {
	
	@Autowired
	private ServicioRepository servicioRepo;
	
	@GetMapping("/get-all-servicio")
	public ResponseEntity<List<ServicioEntity>> getAllServicio(){
		return ResponseEntity.ok(servicioRepo.findAll());
	}
	
}
