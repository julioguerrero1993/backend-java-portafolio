package com.example.turismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.turismo.entity.DepartamentoEntity;

@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Integer> {
	
	@Query("SELECT d FROM departamento d WHERE d.id_departamento = ?1")
	public DepartamentoEntity getByCustomIdQuery(Integer id);

}
