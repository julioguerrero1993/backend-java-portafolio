package com.example.turismo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "comuna")
public class ComunaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id_comuna;
	
	private String nombre;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuidad", referencedColumnName = "id_ciudad")
	private CiudadEntity cuidad;

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

	public CiudadEntity getCiudad() {
		return cuidad;
	}

	public void setCiudad(CiudadEntity ciudad) {
		this.cuidad = ciudad;
	}

}
