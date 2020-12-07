package com.example.turismo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.turismo.entity.CiudadEntity;

@Repository
public interface CiudadRepository extends JpaRepository<CiudadEntity, Integer>{

	@Query("SELECT c FROM ciudad c WHERE c.nombre LIKE %?1%")
	public List<CiudadEntity> getLike(String value);
}
