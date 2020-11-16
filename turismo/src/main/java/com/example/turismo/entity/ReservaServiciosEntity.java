package com.example.turismo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "reserva_servicios")
public class ReservaServiciosEntity {

	@Id
	private int id_res_ser;
	
	private int servicio;
	
	private int reserva;

	public int getId_res_ser() {
		return id_res_ser;
	}

	public void setId_res_ser(int id_res_ser) {
		this.id_res_ser = id_res_ser;
	}

	public int getServicio() {
		return servicio;
	}

	public void setServicio(int servicio) {
		this.servicio = servicio;
	}

	public int getReserva() {
		return reserva;
	}

	public void setReserva(int reserva) {
		this.reserva = reserva;
	}
}
