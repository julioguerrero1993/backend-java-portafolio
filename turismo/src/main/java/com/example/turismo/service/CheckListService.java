package com.example.turismo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.turismo.dto.CheckListDTO;
import com.example.turismo.entity.CheckListEntity;
import com.example.turismo.repository.CheckListRepository;

@Service
public class CheckListService {

	Logger logger = LoggerFactory.getLogger(CheckListService.class);

	CheckListRepository checkListRepo;

	public CheckListService(CheckListRepository checklistRepo) {
		this.checkListRepo = checklistRepo;
	}

	public void save(CheckListDTO checklist) {
		CheckListEntity checkListValidateIfExist = null;
		try {
			checkListValidateIfExist = this.checkListRepo.findById(checklist.getId_checklist()).get();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (checkListValidateIfExist != null) {
			logger.info("update checklist {}", checklist.getNombre());
			checkListValidateIfExist.setNombre(checklist.getNombre());
			checkListValidateIfExist.setDescripcion(checklist.getDescripcion());
			this.checkListRepo.save(checkListValidateIfExist);
		} else {
			this.checkListRepo.save(this.toEntity(checklist));
		}

	}

	public List<CheckListDTO> getAllChecklist() {
		List<CheckListEntity> listEntitiesFromDB = this.checkListRepo.findAll();
		List<CheckListDTO> listDto = null;
		if (listEntitiesFromDB != null && !listEntitiesFromDB.isEmpty()) {
			logger.info("get checklist from DB");
			listDto = new ArrayList<CheckListDTO>();
			for (CheckListEntity ent : listEntitiesFromDB) {
				listDto.add(this.toDTO(ent));
			}
		}

		return listDto;
	}

	public CheckListDTO findById(int id) {
		return this.toDTO(this.checkListRepo.findById(id).get());
	}

	private CheckListEntity toEntity(CheckListDTO checklist) {
		CheckListEntity checkEntity = null;
		if (checklist != null) {
			checkEntity = new CheckListEntity();
			checkEntity.setId_checklist(checklist.getId_checklist());
			checkEntity.setDescripcion(checklist.getDescripcion());
			checkEntity.setNombre(checklist.getNombre());
			return checkEntity;
		}
		return checkEntity;
	}

	private CheckListDTO toDTO(CheckListEntity checklistEntity) {
		if (checklistEntity != null) {
			return new CheckListDTO(checklistEntity.getId_checklist(), checklistEntity.getNombre(),
					checklistEntity.getDescripcion());
		}
		return null;
	}
}
