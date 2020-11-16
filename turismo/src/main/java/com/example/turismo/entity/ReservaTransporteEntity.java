package com.example.turismo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "reserva_transporte")
public class ReservaTransporteEntity {

	@Id
	private int id_reserva_transporte;
	
	private int reserva;
	
	private int transporte;

	public int getId_reserva_transporte() {
		return id_reserva_transporte;
	}

	public void setId_reserva_transporte(int id_reserva_transporte) {
		this.id_reserva_transporte = id_reserva_transporte;
	}

	public int getReserva() {
		return reserva;
	}

	public void setReserva(int reserva) {
		this.reserva = reserva;
	}

	public int getTransporte() {
		return transporte;
	}

	public void setTransporte(int transporte) {
		this.transporte = transporte;
	}
	
	
}
