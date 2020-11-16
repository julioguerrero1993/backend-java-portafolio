package com.example.turismo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "check_list")
public class CheckListEntity {
	
	@Id
	private int id_checklist;
	
	@Column( name = "nombe")
	private String nombre;
	
	@Column( name = "descripcion")
	private String descripcion;
	
	public int getId_checklist() {
		return id_checklist;
	}

	public void setId_checklist(int id_checklist) {
		this.id_checklist = id_checklist;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
