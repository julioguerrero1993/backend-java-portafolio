package com.example.turismo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.turismo.entity.ReservaEntity;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Integer> {

	@Query("SELECT r FROM reserva r WHERE r.fecha_final > ?1 AND r.departamento = ?2 AND r.estado = 1")
	public ReservaEntity getBookingQuery(Date fecha_inicio, int id_departamento);
	
	@Query("SELECT r FROM reserva r WHERE r.cliente = ?1")
	public List<ReservaEntity> getBookingByCustomerQuery(int id_departamento);
}
