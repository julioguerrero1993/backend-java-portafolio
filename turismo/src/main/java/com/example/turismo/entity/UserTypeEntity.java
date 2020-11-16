package com.example.turismo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user_type")
public class UserTypeEntity {
	
	@Id
	private int id_user_type;
	
	private String nombre;

	public int getId_user_type() {
		return id_user_type;
	}

	public void setId_user_type(int id_user_type) {
		this.id_user_type = id_user_type;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
