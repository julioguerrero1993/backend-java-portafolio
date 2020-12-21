package com.example.turismo.dto;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.example.turismo.entity.CiudadEntity;

public class ComunaDTO {

	@Id
	private int id_comuna;
	
	private String nombre;
	
	private String cuidad;

	public int getId_comuna() {
		return id_comuna;
	}

	public void setId_comuna(int id_comuna) {
		this.id_comuna = id_comuna;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return cuidad;
	}

	public void setCiudad(String ciudad) {
		this.cuidad = ciudad;
	}
}
