package com.example.turismo.adapter.primary;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.turismo.entity.EstadoEntity;
import com.example.turismo.service.EstadoService;

@RestController
public class DepartamentoController {
	
	Logger logger = LoggerFactory.getLogger(DepartamentoController.class);
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("/get-apartaments")
	public String getApartaments() {
		logger.info("getting apartaments from db");
		List<EstadoEntity> listEstado = estadoService.getAllEstado();
		if(listEstado.size() == 0) {
			logger.info("no estados");
		}
		for(EstadoEntity e : listEstado) {
			logger.info("estado : {}", e.getNombre());
		}
		return "hola mundo";
	}

}
