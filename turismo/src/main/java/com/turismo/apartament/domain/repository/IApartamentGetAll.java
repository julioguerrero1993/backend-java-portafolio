package com.turismo.apartament.domain.repository;

import java.util.List;

import com.turismo.apartament.domain.model.entity.DepartamentoDTO;

public interface IApartamentGetAll {
	
	List<DepartamentoDTO> getAllApartament();
}
