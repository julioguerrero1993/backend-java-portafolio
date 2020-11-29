package com.turismo.apartament.application.usecase;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turismo.apartament.domain.model.entity.DepartamentoDTO;
import com.turismo.apartament.domain.repository.IApartamentGetAll;
import com.turismo.apartament.domain.repository.IApartamentGetById;
import com.turismo.apartament.domain.repository.IApartementSaveOrUpdate;

@Service
public class ApartamentUseCase {
	
	Logger logger = LoggerFactory.getLogger(ApartamentUseCase.class);
	
	
	@Autowired
	private IApartamentGetAll getAllApartament;
	
	@Autowired
	private IApartementSaveOrUpdate apartamentSaveOrUpdate;
	
	@Autowired
	private IApartamentGetById getApartamentById;
	
	public List<DepartamentoDTO> getListapartamentDTO(){
		List<DepartamentoDTO> listApartamentDto = getAllApartament.getAllApartament();
		if(listApartamentDto != null && listApartamentDto.size() > 0) {
			logger.info("get all apartament success");
		}
		return listApartamentDto;
	}
	
	public DepartamentoDTO apartamentoById(int id) {
		return getApartamentById.getById(id);
	}
	
	public boolean updateApartament(DepartamentoDTO deptoDTO) {
		try {
			DepartamentoDTO apartamentDTO = getApartamentById.getById(deptoDTO.getId_departamento());
			if(apartamentDTO == null) {
				logger.info("apartament not exist, creating one");
				apartamentSaveOrUpdate.save(apartamentDTO);
				return true;
			} else {
				return false;
			}
		}catch(Exception e) {
			logger.error("ERROR with Update apartament {}", e.getMessage());
			return false;
		}
	}
}
