package com.turismo.apartament.domain.repository;

import com.turismo.apartament.domain.model.entity.DepartamentoDTO;

public interface IApartamentGetById {
	public DepartamentoDTO getById(Integer id);
}
