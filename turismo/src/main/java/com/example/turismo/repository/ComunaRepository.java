package com.example.turismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.turismo.entity.ComunaEntity;

@Repository
public interface ComunaRepository extends JpaRepository<ComunaEntity, Long>{

	@Query("SELECT c FROM comuna c WHERE c.id_comuna = ?1")
	public ComunaEntity getComunaByIdQuery(Integer id);
	
	@Query("SELECT c FROM comuna c WHERE c.nombre = ?1")
	public ComunaEntity getComunaByNameQuery(String name);
}
