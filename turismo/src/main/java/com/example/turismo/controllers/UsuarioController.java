package com.example.turismo.controllers;

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

import com.example.turismo.entity.UserEntity;
import com.example.turismo.repository.UserProfileRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UserProfileRepository userRepo;
	
	@PostMapping("/save-or-update-users")
	public ResponseEntity<HttpStatus> login(
			@RequestBody UserEntity user){

		try {
			UserEntity ent = userRepo.findById(user.getId_user()).get();
			userRepo.save(ent);
		} catch(Exception e) {
			logger.error("user no exist, create one");
		}
		userRepo.save(user);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("/get-all-user")
	public ResponseEntity<List<UserEntity>> getAllUser() {
		return ResponseEntity.ok(userRepo.findAll());
	}
	
	@GetMapping("/delete-user/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("idTransporte") Integer id) {
		UserEntity user = userRepo.findById(id).get();
		userRepo.delete(user);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("/find-by-id-user/{id}")
	public ResponseEntity<UserEntity> getUser(@PathVariable("idTransporte") Integer id) {
		UserEntity user = userRepo.findById(id).get();
		return ResponseEntity.ok(user);
	}
}
