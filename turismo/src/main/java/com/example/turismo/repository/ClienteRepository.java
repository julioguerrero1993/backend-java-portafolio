package com.example.turismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.turismo.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

	@Query("SELECT c FROM cliente c WHERE c.cliente_user = ?1")
	public ClienteEntity getClienteByUserId(int id);
}
