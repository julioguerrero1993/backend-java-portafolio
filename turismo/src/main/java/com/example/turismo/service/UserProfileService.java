package com.example.turismo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.turismo.controllers.DepartamentoController;
import com.example.turismo.dto.UserDTO;
import com.example.turismo.entity.UserEntity;
import com.example.turismo.repository.UserProfileRepository;

@Service
public class UserProfileService {

	Logger logger = LoggerFactory.getLogger(UserProfileService.class);
	
	@Autowired
	private UserProfileRepository userRepo;
	
	public UserEntity validCredencial(UserDTO user) {
		UserEntity ent = userRepo.getCredencialQuery(user.getNombre(), user.getPassword());
		if(ent == null ) {
			return null;
		}
		logger.info("get user from table");
		return ent;
	}
}
