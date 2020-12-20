package com.example.turismo.dto;

public class TransporteDTO {

	private int id_transporte;

	private String descripcion;

	private String tipo_vehiculo;

	private int cantidad_personas;

	public int getId_transporte() {
		return id_transporte;
	}

	public void setId_transporte(int id_transporte) {
		this.id_transporte = id_transporte;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo_vehiculo() {
		return tipo_vehiculo;
	}

	public void setTipo_vehiculo(String tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}

	public int getCantidad_personas() {
		return cantidad_personas;
	}

	public void setCantidad_personas(int cantidad_personas) {
		this.cantidad_personas = cantidad_personas;
	}
}
