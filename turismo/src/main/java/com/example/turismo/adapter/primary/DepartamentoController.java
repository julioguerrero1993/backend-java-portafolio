package com.example.turismo.adapter.primary;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.turismo.dto.DepartamentoDTO;
import com.example.turismo.entity.CiudadEntity;
import com.example.turismo.entity.DepartamentoEntity;
import com.example.turismo.entity.EstadoEntity;
import com.example.turismo.entity.ReservaEntity;
import com.example.turismo.entity.ServicioEntity;
import com.example.turismo.service.CiudadService;
import com.example.turismo.service.DepartamentoService;
import com.example.turismo.service.EstadoService;
import com.example.turismo.service.ReservaService;
import com.example.turismo.service.ServicioService;

@RestController
public class DepartamentoController {
	
	Logger logger = LoggerFactory.getLogger(DepartamentoController.class);
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private CiudadService ciudadService;
	
	@Autowired
	private ServicioService servicioService;
	
	@GetMapping("/get-apartaments")
	public String getApartaments() {
		List<DepartamentoEntity> listApartament = departamentoService.getAllApartament();
		
		List<ReservaEntity> listEnt = reservaService.getAllReserva();
		
		List<CiudadEntity> listCiudad = ciudadService.getAllCiudad();
		
		List<ServicioEntity> listServicio = servicioService.getAllServicios();
		
		if(listServicio.size() > 0) {
			logger.info("trae data de las servicio {}", listServicio.size());
		} else {
			logger.info("no trae data servicio {}", listServicio.size());
		}
		
		for(DepartamentoEntity e : listApartament) {
			logger.info("depto 1 : {}", e.getComuna().getCiudad().getNombre());
		}
		return "hola mundo";
	}

}
