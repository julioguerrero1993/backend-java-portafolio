package com.turismo.apartament.domain.repository;

import com.turismo.apartament.domain.model.entity.DepartamentoDTO;

public interface IApartementSaveOrUpdate {
	public boolean save (DepartamentoDTO ent);
}
