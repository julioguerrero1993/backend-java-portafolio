package com.example.turismo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.turismo.dto.CityDTO;
import com.example.turismo.entity.CiudadEntity;
import com.example.turismo.repository.CiudadRepository;

@Service
public class CiudadService {
	
	Logger logger = LoggerFactory.getLogger(CiudadService.class);
	
	@Autowired
	private CiudadRepository ciudadRepo;
	
	public List<CiudadEntity> getAllCiudad() {
		return ciudadRepo.findAll();
	}
	
	public List<CityDTO> getCityByLike(String value) {
		List<CityDTO> listDts = new ArrayList<>();
		try {
			List<CiudadEntity> entities = ciudadRepo.getLike(value);
			if(entities !=null && entities.size() > 0) {
				for(CiudadEntity ent : entities) {
					CityDTO dto = new CityDTO();
					dto.setId_ciudad(ent.getId_ciudad());
					dto.setNombre(ent.getNombre());
					dto.setRegion(ent.getRegion());
					
					listDts.add(dto);
				}
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
		return listDts;
	}

}
