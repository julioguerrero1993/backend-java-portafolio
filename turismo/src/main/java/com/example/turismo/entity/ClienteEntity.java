package com.example.turismo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "cliente")
public class ClienteEntity {

	@Id
	private int id_cliente;
	
	private int comuna;
	
	private String nombre;
	
	private String fecha_nacimiento;
	
	private String telefono;
	
	private String mail;
	
	private int cliente_user;

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getComuna() {
		return comuna;
	}

	public void setComuna(int comuna) {
		this.comuna = comuna;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getCliente_user() {
		return cliente_user;
	}

	public void setCliente_user(int cliente_user) {
		this.cliente_user = cliente_user;
	}
}
