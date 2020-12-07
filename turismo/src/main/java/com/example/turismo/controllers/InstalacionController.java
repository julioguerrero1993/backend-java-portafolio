package com.example.turismo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.turismo.dto.InstalacionesDTO;
import com.example.turismo.service.InstalacionesService;

@RestController
@RequestMapping("/instalaciones")
public class InstalacionController {
	
	private InstalacionesService instalacionesService;
	
	public InstalacionController(InstalacionesService instalacionesService) {
		this.instalacionesService = instalacionesService;
	}

	@GetMapping("/get-instalaciones")
	public ResponseEntity<List<InstalacionesDTO>> getInstalaciones() {
		return ResponseEntity.ok(this.instalacionesService.getAllInstalaciones());
	}
	
	@PostMapping("/saveOrUpdate-instalacion")
	public ResponseEntity<HttpStatus> saveOrUpdateInstalaciones(@RequestBody InstalacionesDTO instalacionesDTO) {
		this.instalacionesService.saveOrUpdate(instalacionesDTO);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("/get-instalacion-by-id/{id}")
	public ResponseEntity<InstalacionesDTO> getInstalacionById(@PathVariable("id") Integer id) {
		InstalacionesDTO instalacion = this.instalacionesService.findById(id);
		if(instalacion != null) {
			return ResponseEntity.ok(this.instalacionesService.findById(id));
		}
		return ResponseEntity.ok(null);
	}
}
