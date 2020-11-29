package com.example.turismo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.turismo.apartament.domain.model.entity.DepartamentoDTO;

class DepartamentoServiceTest {
	
	@Autowired
	private DepartamentoService deptoService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		//assertEquals(true, new DepartamentoDTO(2, 1, descripcion, dimension, valor_diario, orientacion, max_huespedes, habitaciones));
	}

}
