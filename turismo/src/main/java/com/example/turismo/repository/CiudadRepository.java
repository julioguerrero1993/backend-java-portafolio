package com.example.turismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.turismo.entity.CiudadEntity;

@Repository
public interface CiudadRepository extends JpaRepository<CiudadEntity, Long>{

}
