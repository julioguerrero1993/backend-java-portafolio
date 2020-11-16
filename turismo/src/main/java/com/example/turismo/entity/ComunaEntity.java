package com.example.turismo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "comuna")
public class ComunaEntity {
	
	@Id
	private int id_comuna;
	
	private String nombre;
	
	private int ciudad;

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

	public int getCiudad() {
		return ciudad;
	}

	public void setCiudad(int ciudad) {
		this.ciudad = ciudad;
	}

}
