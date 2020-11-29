package com.turismo.apartament.infra.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.example.turismo.entity.ComunaEntity;

@Entity(name = "departamento")
public class DepartamentoEntity {

	@Id
	private int id_departamento;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comuna", referencedColumnName = "id_comuna")
	private ComunaEntity comuna;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "dimension")
	private String dimension;

	@Column(name = "valor_diario")
	private int valor_diario;

	@Column(name = "orientacion")
	private String orientacion;

	@Column(name = "max_huespedes")
	private int max_huespedes;

	@Column(name = "habitaciones")
	private int habitaciones;
	
	@Column(name = "img")
	private String img;

	public int getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}

	public ComunaEntity getComuna() {
		return comuna;
	}

	public void setComuna(ComunaEntity comuna) {
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

	public int getValor_diario() {
		return valor_diario;
	}

	public void setValor_diario(int valor_diario) {
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
