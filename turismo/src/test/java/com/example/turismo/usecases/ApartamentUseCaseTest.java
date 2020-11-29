package com.example.turismo.usecases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.turismo.entity.ComunaEntity;
import com.example.turismo.service.DepartamentoService;
import com.turismo.apartament.application.usecase.ApartamentUseCase;
import com.turismo.apartament.domain.model.entity.DepartamentoDTO;
import com.turismo.apartament.infra.persistence.entity.DepartamentoEntity;


class ApartamentUseCaseTest {
	
	
	private ApartamentUseCase apartamentUseCase = new ApartamentUseCase();
	
	@Test
	void testCreateApartament() {
		assertEquals(true, apartamentUseCase.updateApartament(new DepartamentoDTO(1,
				"IQUIQUE", "IQUIQUE TEST", "100m2", 30000, "SUR", 3, 2,"path")));
	}


}
