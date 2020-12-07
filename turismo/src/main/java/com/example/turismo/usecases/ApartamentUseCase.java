package com.example.turismo.usecases;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.turismo.dto.DepartamentoDTO;
import com.example.turismo.entity.ComunaEntity;
import com.example.turismo.entity.DepartamentoEntity;
import com.example.turismo.service.DepartamentoService;

@Service
public class ApartamentUseCase {
	
	Logger logger = LoggerFactory.getLogger(ApartamentUseCase.class);
	
	@Autowired
	private DepartamentoService apartamentService;
	
	@Autowired
	private ComunaUseCase comunaUseCase;
	
	public List<DepartamentoDTO> getListapartamentDTO(){
		List<DepartamentoDTO> listDto = null;
		List<DepartamentoEntity> listEnt = apartamentService.getAllApartament();
		if(!listEnt.isEmpty()) {
			listDto = new ArrayList<>();
			for(DepartamentoEntity ent : listEnt) {
				listDto.add(new DepartamentoDTO(ent.getId_departamento(),
						ent.getComuna().getNombre(),
						ent.getDescripcion(),
						ent.getDimension(),
						ent.getValor_diario(),
						ent.getOrientacion(),
						ent.getMax_huespedes(),
						ent.getHabitaciones(),
						ent.getImg()));
			}
		}
		return listDto;
	}
	
	public DepartamentoDTO apartamentoById(int id) {
		return this.transformToDto(apartamentService.getById(id));
	}
	
	public List<DepartamentoDTO> getListapartamentDTOByCity(String cityName){
		List<DepartamentoDTO> listDto = null;
		List<DepartamentoEntity> listEnt = apartamentService.getAllApartament();
		if(!listEnt.isEmpty()) {
			logger.info("get apartament");
			listDto = new ArrayList<>();
			for(DepartamentoEntity ent : listEnt) {
				if(cityName.equals(ent.getComuna().getCiudad().getNombre())) {
					listDto.add(new DepartamentoDTO(ent.getId_departamento(),
							ent.getComuna().getNombre(),
							ent.getDescripcion(),
							ent.getDimension(),
							ent.getValor_diario(),
							ent.getOrientacion(),
							ent.getMax_huespedes(),
							ent.getHabitaciones(),
							ent.getImg()));	
				}
				
			}
		}
		return listDto;
	}
	
	public boolean updateApartament(DepartamentoDTO deptoDTO) {
		try {
			DepartamentoEntity ent = apartamentService.getById(deptoDTO.getId_departamento());
			if(ent == null) {
				ent = transformToEntityFromDto(deptoDTO);
				logger.info("apartament not exist, creating one");
				apartamentService.save(ent);
				return true;
			} else {
				return false;
			}
		}catch(Exception e) {
			logger.error("ERROR with Update apartament {}", e.getMessage());
			return false;
		}
	}
	
	public DepartamentoEntity transformToEntityFromDto(DepartamentoDTO deptoDto) {
		DepartamentoEntity deptoEnt = new DepartamentoEntity();
		ComunaEntity comunaEnt = comunaUseCase.getByName(deptoDto.getComuna());
		if(comunaEnt != null) {
			deptoEnt.setId_departamento(deptoDto.getId_departamento());
			deptoEnt.setComuna(comunaEnt);
			deptoEnt.setDescripcion(deptoDto.getDescripcion());
			deptoEnt.setDimension(deptoDto.getDimension());
			deptoEnt.setOrientacion(deptoDto.getOrientacion());
			deptoEnt.setValor_diario(deptoDto.getValor_diario());
			deptoEnt.setMax_huespedes(deptoDto.getMax_huespedes());
			deptoEnt.setHabitaciones(deptoDto.getHabitaciones());
			deptoEnt.setImg(deptoDto.getImg());
		}
		return deptoEnt;
		
	}
	
	public DepartamentoDTO transformToDto(DepartamentoEntity deptoEntity) {
		DepartamentoDTO depto = new DepartamentoDTO();
		depto.setId_departamento(deptoEntity.getId_departamento());
		depto.setComuna(deptoEntity.getComuna().getNombre());
		depto.setDescripcion(deptoEntity.getDescripcion());
		depto.setDimension(deptoEntity.getDimension());
		depto.setHabitaciones(deptoEntity.getHabitaciones());
		depto.setMax_huespedes(deptoEntity.getMax_huespedes());
		depto.setValor_diario(deptoEntity.getValor_diario());
		depto.setImg(deptoEntity.getImg());
		
		return depto;
		
	}
}
