package com.example.turismo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.turismo.entity.DepartamentoEntity;

@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Long> {
	
	@Query("SELECT d FROM departamento d")
	public List<DepartamentoEntity> getAllByCustomQuery();

}
