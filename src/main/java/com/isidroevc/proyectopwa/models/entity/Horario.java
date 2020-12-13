package com.isidroevc.proyectopwa.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "horario")
public class Horario {

	@Id
	private long id;
	@Column(name = "detalle")
	private String detalle;
	@Column(name = "dias")
	private String dias;
	@Column(name = "turno")
	private String turno;

	public Horario() {

	}

	public Horario(String detalle) {
		this.detalle = detalle;
	}

	public Long getId() {
		return this.id;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public String getDias() {
		return this.dias;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

}
