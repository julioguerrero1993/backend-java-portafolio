package com.turismo.apartament.infra.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.turismo.entity.ComunaEntity;
import com.example.turismo.repository.ComunaRepository;
import com.turismo.apartament.domain.model.entity.DepartamentoDTO;
import com.turismo.apartament.domain.repository.IApartamentGetAll;
import com.turismo.apartament.domain.repository.IApartamentGetById;
import com.turismo.apartament.domain.repository.IApartementSaveOrUpdate;
import com.turismo.apartament.infra.persistence.entity.DepartamentoEntity;
import com.turismo.apartament.infra.persistence.repository.DepartamentoRepository;

@Service
public class ApartamentDataProvider implements IApartamentGetAll, IApartamentGetById, IApartementSaveOrUpdate {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private ComunaRepository comunaRepo;

	@Override
	public List<DepartamentoDTO> getAllApartament() {
		List<DepartamentoEntity> listEntities =  departamentoRepository.findAll();
		List<DepartamentoDTO> listApartamentDTO = null;
		if(listEntities != null) {
			listApartamentDTO = getListApartamentDTOfromListEntities(listEntities);
		}
		return listApartamentDTO;
	}
	
	public long countApartament() {
		return departamentoRepository.count();
	}
	
	@Override
	public DepartamentoDTO getById(Integer id) {
		return transformToDto(departamentoRepository.findById(id).get());
	}
	
	@Override
	public boolean save (DepartamentoDTO dto) {
		if(dto != null){
			departamentoRepository.save(transformToEntityFromDto(dto));
			return true;
		}
		return false;
	}
	
	private List<DepartamentoDTO> getListApartamentDTOfromListEntities(List<DepartamentoEntity> listEntities){
		List<DepartamentoDTO> listApartamentDTO = null;
		if(listEntities.size() > 0) {
			listApartamentDTO = new ArrayList<>();
			for(DepartamentoEntity entity : listEntities) {
				DepartamentoDTO apartamentDTO = new DepartamentoDTO(entity.getId_departamento(), entity.getComuna().getNombre(),
						entity.getDescripcion(), entity.getDimension(), entity.getValor_diario(), 
						entity.getOrientacion(), entity.getMax_huespedes(), entity.getHabitaciones(), entity.getImg());
				listApartamentDTO.add(apartamentDTO);
			}
		}
		return listApartamentDTO;
	}
	
	public DepartamentoEntity transformToEntityFromDto(DepartamentoDTO deptoDto) {
		DepartamentoEntity deptoEnt = new DepartamentoEntity();
		ComunaEntity comunaEnt = comunaRepo.getComunaByNameQuery(deptoDto.getComuna());
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
