package com.example.turismo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "instalaciones_departamento")
public class InstalacionesDepartamentoEntity {
	
	@Id
	private int id_inst_depto;
	
	private int departamento; 
	
	private int instalacion;

	public int getId_inst_depto() {
		return id_inst_depto;
	}

	public void setId_inst_depto(int id_inst_depto) {
		this.id_inst_depto = id_inst_depto;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public int getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(int instalacion) {
		this.instalacion = instalacion;
	}

}
