package com.example.turismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.turismo.entity.EstadoEntity;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoEntity, Long> {

}
