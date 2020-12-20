package com.example.turismo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.turismo.dto.UserDTO;
import com.example.turismo.entity.ClienteEntity;
import com.example.turismo.repository.ClienteRepository;
import com.example.turismo.usecases.UserProfileUseCase;

@RestController
@RequestMapping("/login")
public class LoginController {
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserProfileUseCase userUseCase;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@PostMapping("/valid-credencial")
	public ResponseEntity<UserDTO> login(
			@RequestBody UserDTO user){
		logger.info("validating credencials ...");
		UserDTO userValidated = userUseCase.validCredencial(user);
		
		if(userValidated != null) {
			ClienteEntity cus = clienteRepo.getClienteByUserId(userValidated.getId_user());
			
			List<ClienteEntity> listCus = clienteRepo.findAll();
			for(ClienteEntity c : listCus) {
				if(c.getCliente_user() == userValidated.getId_user()) {
					userValidated.setId_customer(c.getId_cliente());
				}
			}
			return ResponseEntity.ok(userValidated);
		}
		
		
		return ResponseEntity.ok(userValidated);
	}
}
