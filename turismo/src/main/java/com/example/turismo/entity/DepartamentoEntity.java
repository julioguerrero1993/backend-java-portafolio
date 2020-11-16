package com.example.turismo.entity;

import javax.persistence.Entity;

@Entity(name = "departamento")
public class DepartamentoEntity {

	private int id_departamento;
	
	private int comuna;
	
	private String descripcion;
	
	private String dimension;
	
	private long valor_diario;
	
	private String orientacion;
	
	private int max_huespedes;
	
	private int habitaciones;

	public int getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}

	public int getComuna() {
		return comuna;
	}

	public void setComuna(int comuna) {
		this.comuna = comuna;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public long getValor_diario() {
		return valor_diario;
	}

	public void setValor_diario(long valor_diario) {
		this.valor_diario = valor_diario;
	}

	public String getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}

	public int getMax_huespedes() {
		return max_huespedes;
	}

	public void setMax_huespedes(int max_huespedes) {
		this.max_huespedes = max_huespedes;
	}

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}
}
