package com.example.turismo.dto;

public class CheckListDTO {

	private int id_checklist;
	
	private String nombre;
	
	private String descripcion;
	
	public CheckListDTO() {
	}

	public CheckListDTO(int id_checklist, String nombre, String descripcion) {
		super();
		this.id_checklist = id_checklist;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
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
