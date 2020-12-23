package com.example.turismo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.turismo.dto.CheckListDTO;
import com.example.turismo.entity.ReservaChecklistEntity;
import com.example.turismo.repository.ReservaChecklistRepository;
import com.example.turismo.service.CheckListService;

@RestController
@RequestMapping("/checklist")
public class CheckListController {
	
	@Autowired
	private CheckListService checklistService;
	
	@Autowired
	private ReservaChecklistRepository repo;
	
	@GetMapping("/get-checklist-reserva")
	public ResponseEntity<List<ReservaChecklistEntity>> getChecklistReserva() {
		return ResponseEntity.ok(this.repo.findAll());
	}

	@GetMapping("/get-checklist")
	public ResponseEntity<List<CheckListDTO>> getChecklist() {
		return ResponseEntity.ok(this.checklistService.getAllChecklist());
	}
	
	@PostMapping("/saveOrUpdate-checklist")
	public ResponseEntity<HttpStatus> saveOrUpdateChecklist(@RequestBody CheckListDTO checklistDTO) {
		this.checklistService.save(checklistDTO);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("/get-checklist-by-id/{id}")
	public ResponseEntity<CheckListDTO> getChecklistById(@PathVariable("id") Integer id) {
		CheckListDTO checklist = this.checklistService.findById(id);
		if(checklist != null) {
			return ResponseEntity.ok(this.checklistService.findById(id));
		}
		return ResponseEntity.ok(null);
	}
}
