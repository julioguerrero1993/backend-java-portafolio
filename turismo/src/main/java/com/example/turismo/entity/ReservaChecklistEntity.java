package com.example.turismo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "reserva_checklist")
public class ReservaChecklistEntity {
	
	@Id
	private int id_reserva_checklist;
	
	private int checklist;
	
	private int estado;

	public int getId_reserva_checklist() {
		return id_reserva_checklist;
	}

	public void setId_reserva_checklist(int id_reserva_checklist) {
		this.id_reserva_checklist = id_reserva_checklist;
	}

	public int getChecklist() {
		return checklist;
	}

	public void setChecklist(int checklist) {
		this.checklist = checklist;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
