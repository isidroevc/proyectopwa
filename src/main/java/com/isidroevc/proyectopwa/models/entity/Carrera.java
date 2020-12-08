package com.isidroevc.proyectopwa.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "carreras")
public class Carrera implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Carrera() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String clave;
	@NotNull
	@Column(name = "id_jefe")
	private Long idJefe;
	
	public Usuario getJefe() {
		return jefe;
	}

	public void setJefe(Usuario jefe) {
		this.jefe = jefe;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_jefe", referencedColumnName = "id",  insertable=false, updatable=false)
	private Usuario jefe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Long getIdJefe() {
		return idJefe;
	}

	public void setIdJefe(Long idJefe) {
		this.idJefe = idJefe;
	}
	
}
