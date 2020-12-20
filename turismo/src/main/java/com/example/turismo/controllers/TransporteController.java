package com.example.turismo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.turismo.dto.TransporteDTO;
import com.example.turismo.entity.TransporteEntity;
import com.example.turismo.repository.TransporteRepository;

@RestController
@RequestMapping("/transporte")
public class TransporteController {

	Logger logger = LoggerFactory.getLogger(TransporteController.class);
	
	@Autowired
	private TransporteRepository transporteRepository;
	
	@GetMapping("/get-transportes")
	public ResponseEntity<List<TransporteDTO>> getAllTransporte(){
		List<TransporteEntity> listEnt = transporteRepository.findAll();
		List<TransporteDTO> listDto = new ArrayList<TransporteDTO>();
		if(!listEnt.isEmpty()) {
			for(TransporteEntity ent : listEnt) {
				listDto.add(toDTO(ent));
			}
		}
		return ResponseEntity.ok(listDto);
		
	}
	
	@PostMapping("/update-or-create")
	public ResponseEntity<HttpStatus> createOrUpdate(@RequestBody TransporteDTO dto){
		try {
			TransporteEntity entity = transporteRepository.findById(dto.getId_transporte()).get();
			if(entity != null) {
				transporteRepository.save(toEntity(toDTO(entity)));
			}
		}catch(Exception e) {
			logger.error("transporte already exist");
		}
		transporteRepository.save(toEntity(dto));
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("/delete-transporte/{idTransporte}")
	public ResponseEntity<HttpStatus> deleteTransporte(@PathVariable("idTransporte") String idTransporte){
		Integer id = Integer.parseInt(idTransporte);
		
		
		try {
			TransporteEntity ent = transporteRepository.findById(id).get();
			if(ent != null) {
				logger.info("delete transporte id {}",idTransporte);
				transporteRepository.delete(ent);
				return ResponseEntity.ok(HttpStatus.OK);
			}
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
		
		return ResponseEntity.ok(HttpStatus.NOT_FOUND);
		
	}
	
	private TransporteDTO toDTO(TransporteEntity ent) {
		TransporteDTO transporte = new TransporteDTO();
		transporte.setId_transporte(ent.getId_transporte());
		transporte.setDescripcion(ent.getDescripcion());
		transporte.setTipo_vehiculo(ent.getTipo_vehiculo());
		
		return transporte;
	}
	
	private TransporteEntity toEntity(TransporteDTO dto) {
		TransporteEntity transporte = new TransporteEntity();
		transporte.setId_transporte(dto.getId_transporte());
		transporte.setDescripcion(dto.getDescripcion());
		transporte.setTipo_vehiculo(dto.getTipo_vehiculo());
		
		return transporte;
	}
}
