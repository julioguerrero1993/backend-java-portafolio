package com.example.turismo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.turismo.dto.DepartamentoDTO;
import com.example.turismo.entity.DepartamentoEntity;
import com.example.turismo.repository.DepartamentoRepository;
import com.example.turismo.usecases.ApartamentUseCase;

@RestController
@RequestMapping("/apartament")
public class DepartamentoController {
	
	Logger logger = LoggerFactory.getLogger(DepartamentoController.class);
	
	@Autowired
	private ApartamentUseCase apartamentUseCase;
	
	@Autowired
	private DepartamentoRepository deptoRepo;

	
	@GetMapping("/get-apartaments")
	public ResponseEntity<List<DepartamentoDTO>> getApartaments() {
		List<DepartamentoDTO> listApartament = apartamentUseCase.getListapartamentDTO();
		try {
			if(listApartament.size() > 0) {
				logger.info("getting apartaments");
				return ResponseEntity.ok(listApartament);
			} else {
				return ResponseEntity.notFound().build();
			}
		}catch(Exception e) {
			logger.error("ERROR GETTING ALL APARTAMENTS");
			return ResponseEntity.notFound().build();
		}

	}
	
	@GetMapping("/get-apartament-by-id/{id}")
	public ResponseEntity<DepartamentoDTO> getApartamentById(
			@PathVariable("id") Integer id) {
		DepartamentoDTO apartament = apartamentUseCase.apartamentoById(id);
		try {
			if(apartament != null) {
				logger.info("getting apartaments");
				return ResponseEntity.ok(apartament);
			} else {
				return ResponseEntity.notFound().build();
			}
		}catch(Exception e) {
			logger.error("ERROR GETTING APARTAMENTS BY ID");
			return ResponseEntity.notFound().build();
		}

	}
	
	@PostMapping
	public int updateApartament(@RequestBody DepartamentoDTO departamentoDTO) {
		try{
			if(departamentoDTO != null) {
				return 1;
			} else {
				return 0;
			}
			
		}catch(Exception e) {
			logger.error("ERROR WITH UPDATE APARTAMENT");
			return 0;
		}
	}

}
