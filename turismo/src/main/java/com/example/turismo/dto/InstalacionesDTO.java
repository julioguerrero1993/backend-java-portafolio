package com.example.turismo.dto;

public class InstalacionesDTO {

	private int id_instalacion;

	private String nombre;

	private String descripcion;

	public InstalacionesDTO() {
		super();
	}
	
	public InstalacionesDTO(int id_instalacion, String nombre, String descripcion) {
		super();
		this.id_instalacion = id_instalacion;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getId_instalacion() {
		return id_instalacion;
	}

	public void setId_instalacion(int id_instalacion) {
		this.id_instalacion = id_instalacion;
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
