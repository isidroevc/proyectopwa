package com.isidroevc.proyectopwa.models.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



@Entity
@Table(name="profesor_tiene_materia_en_horario_con_grupo")
public class ProfesorTieneMateriaConHorario implements Serializable{
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="id_profesor")
    private Long idProfesor;

    @Column(name="id_materia")
    private Long idMateria;

    @Column(name="id_horario")
    private Long idHorario;

    @Column(name="id_aula")
    private Long idAula;
    
    @Column(name="id_carrera")
    private Long idCarrera;
    @Column(name="grupo")
    private String grupo;
    
    @Column(name="numero_alumnos")
    private Integer numeroAlumnos;
    
    @Column(name="semestre")
    private Integer semestre;
    
    
	@ManyToOne
	 @JoinColumn(name = "id_profesor", referencedColumnName = "id",  insertable=false, updatable=false)
	 private Usuario profesor;
	
    @ManyToOne
    @JoinColumn(name = "id_materia", referencedColumnName = "id",  insertable=false, updatable=false)
    private Materia materia;
    
    @ManyToOne
    @JoinColumn(name = "id_aula", referencedColumnName = "id",  insertable=false, updatable=false)
    private Aula aula;
    
    @ManyToOne
    @JoinColumn(name = "id_horario", referencedColumnName = "id",  insertable=false, updatable=false)
    private Horario horario;
    
    @ManyToOne
    @JoinColumn(name = "id_carrera", referencedColumnName = "id",  insertable=false, updatable=false)
    private Carrera carrera;


	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}

	public Long getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Long idMateria) {
		this.idMateria = idMateria;
	}

	public Long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Long idHorario) {
		this.idHorario = idHorario;
	}

	public Long getIdAula() {
		return idAula;
	}

	public void setIdAula(Long idAula) {
		this.idAula = idAula;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Usuario getProfesor() {
		return profesor;
	}

	public void setProfesor(Usuario profesor) {
		this.profesor = profesor;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Integer getNumeroAlumnos() {
		return numeroAlumnos;
	}

	public void setNumeroAlumnos(Integer numeroAlumnos) {
		this.numeroAlumnos = numeroAlumnos;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Long getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(Long idCarrera) {
		this.idCarrera = idCarrera;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	
}
