package com.example.turismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.turismo.entity.CheckListEntity;

public interface CheckListRepository extends JpaRepository<CheckListEntity, Integer> {

}
