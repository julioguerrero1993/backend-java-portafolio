package com.turismo.apartament.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.turismo.apartament.infra.persistence.entity.DepartamentoEntity;

@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Integer> {
	
	@Query("SELECT d FROM departamento d WHERE d.id_departamento = ?1")
	public DepartamentoEntity getByCustomIdQuery(Integer id);

}
