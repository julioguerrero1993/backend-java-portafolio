package com.example.turismo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.turismo.dto.InstalacionesDTO;
import com.example.turismo.entity.InstalacionesEntity;
import com.example.turismo.repository.InstalacionesRepository;

@Service
public class InstalacionesService {

	InstalacionesRepository instalacionesRepo;
	
	public InstalacionesService(InstalacionesRepository instalacionesRepo) {
		this.instalacionesRepo = instalacionesRepo;
	}
	
	public List<InstalacionesDTO> getAllInstalaciones() {
		List<InstalacionesEntity> listInstalacionesEntityFromDB = this.instalacionesRepo.findAll();
		List<InstalacionesDTO> listInstalacionesDto = null;
		if(listInstalacionesEntityFromDB != null && !listInstalacionesEntityFromDB.isEmpty()) {
			listInstalacionesDto = new ArrayList<InstalacionesDTO>();
			for(InstalacionesEntity ent : listInstalacionesEntityFromDB) {
				listInstalacionesDto.add(this.toDTO(ent));
			}
		}
		return listInstalacionesDto;
	}
	
	public InstalacionesDTO findById(Integer id) {
		return this.toDTO(this.instalacionesRepo.findById(id).get());
	}
	
	public void saveOrUpdate(InstalacionesDTO instalacionDTO) {
		InstalacionesEntity instalacionFromDB = null;
		try {
			instalacionFromDB = this.instalacionesRepo.findById(instalacionDTO.getId_instalacion()).get();
		}catch(Exception e) {
			
		}
		if(instalacionFromDB != null) {
			this.instalacionesRepo.save(this.toEntity(instalacionDTO));
		} else {
			this.instalacionesRepo.save(this.toEntity(instalacionDTO));
		}
	}
	
	public InstalacionesDTO toDTO(InstalacionesEntity instalacionesEntity){
		if(instalacionesEntity != null) {
			return new InstalacionesDTO(instalacionesEntity.getId_instalacion(), 
					instalacionesEntity.getNombre(), 
					instalacionesEntity.getDescripcion());
		}
		return null;
	}
	
	public InstalacionesEntity toEntity(InstalacionesDTO instalacionesDTO) {
		if(instalacionesDTO != null) {
			return new InstalacionesEntity(instalacionesDTO.getId_instalacion(), instalacionesDTO.getNombre(), instalacionesDTO.getDescripcion());
		}
		return null;
	}
}
