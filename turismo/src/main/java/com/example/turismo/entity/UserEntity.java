package com.example.turismo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user")
public class UserEntity {
	
	@Id
	private int id_user;
	
	private String nombre;
	
	private String password;
	
	private int tipo;

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
