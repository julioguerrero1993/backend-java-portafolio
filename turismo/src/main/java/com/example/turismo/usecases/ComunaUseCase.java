package com.example.turismo.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.turismo.entity.ComunaEntity;
import com.example.turismo.repository.ComunaRepository;

@Service
public class ComunaUseCase {

	@Autowired
	private ComunaRepository comunaRepo;
	
	public ComunaEntity getByName(String name) {
		if(!name.isEmpty()) {
			return comunaRepo.getComunaByNameQuery(name);
		} 
		return null;
	}
}
