package com.example.turismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.turismo.entity.ReservaChecklistEntity;

@Repository
public interface ReservaChecklistRepository extends JpaRepository<ReservaChecklistEntity, Integer>{

}