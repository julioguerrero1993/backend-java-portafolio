package com.example.turismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.turismo.entity.UserEntity;

@Repository
public interface UserProfileRepository extends JpaRepository<UserEntity, Long>{

	@Query("SELECT u FROM user_profile u WHERE u.nombre = ?1 AND u.password = ?2")
	public UserEntity getCredencialQuery(String name, String password);
}

