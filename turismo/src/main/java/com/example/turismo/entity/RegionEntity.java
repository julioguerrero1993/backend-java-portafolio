package com.example.turismo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "region")
public class RegionEntity {
	
	@Id
	private int id_region;
	
	private String nombre;

	public int getId_region() {
		return id_region;
	}

	public void setId_region(int id_region) {
		this.id_region = id_region;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
