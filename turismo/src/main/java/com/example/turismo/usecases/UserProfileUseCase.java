package com.example.turismo.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.turismo.dto.UserDTO;
import com.example.turismo.entity.UserEntity;
import com.example.turismo.service.UserProfileService;

@Service
public class UserProfileUseCase {

	@Autowired
	private UserProfileService userService;
	
	public UserDTO validCredencial(UserDTO user) {
		UserEntity ent = userService.validCredencial(user);
		if(ent != null) {
			UserDTO dto = new UserDTO();
			dto.setId_user(ent.getId_user());
			dto.setNombre(ent.getNombre());
			dto.setTipo(ent.getTipo());
			return dto;
		}
		return null;
	}
}
