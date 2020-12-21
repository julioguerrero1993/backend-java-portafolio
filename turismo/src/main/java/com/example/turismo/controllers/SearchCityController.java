package com.example.turismo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.turismo.dto.CityDTO;
import com.example.turismo.dto.ComunaDTO;
import com.example.turismo.entity.ComunaEntity;
import com.example.turismo.repository.ComunaRepository;
import com.example.turismo.service.CiudadService;

@RestController
@RequestMapping("/search-city")
public class SearchCityController {

	Logger logger = LoggerFactory.getLogger(SearchCityController.class);
	
	@Autowired
	private CiudadService ciudadService;
	
	@Autowired
	private ComunaRepository comunaRepo;
	
	@GetMapping("/get-like-value/{value}")
	public ResponseEntity<List<CityDTO>> getByLikeValue(@PathVariable("value") String value){
		
		List<CityDTO> listCities = new ArrayList<CityDTO>();
		logger.info("getting cities");
		listCities = ciudadService.getCityByLike(value);
		logger.info("the cities founded are {}", listCities.size());
		return new ResponseEntity<>(listCities,HttpStatus.OK);
	}
	
	@GetMapping("/get-all-comunas")
	public ResponseEntity<List<ComunaDTO>> getAllComunas(){
		List<ComunaDTO> listDto = new ArrayList<ComunaDTO>();
		List<ComunaEntity> listEnt = comunaRepo.findAll();
		for(ComunaEntity e : listEnt) {
			listDto.add(toDTO(e));
		}
		return new ResponseEntity<>(listDto,HttpStatus.OK);
	}
	
	private ComunaDTO toDTO(ComunaEntity ent) {
		ComunaDTO dto = new ComunaDTO();
		dto.setCiudad(ent.getCiudad().getNombre());
		dto.setId_comuna(ent.getId_comuna());
		dto.setNombre(ent.getNombre());
		return dto;
	}
}
