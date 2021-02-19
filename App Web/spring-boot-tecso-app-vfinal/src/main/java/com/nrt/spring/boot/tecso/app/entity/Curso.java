package com.nrt.spring.boot.tecso.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.context.annotation.SessionScope;

@Entity
@Table(name = "curso")
@SessionScope
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "curso_id")
	private Long cursoId;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String descripcion;
	@Column(name = "cupo_maximo")
	@NotNull
	private int cupoMaximo;
	@NotNull
	private int anio;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "docente_id")
	private Docente docente;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "carrera_id")
	private Carrera carrera;
	@OneToMany(mappedBy = "curso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Inscripcion> alumnos;
	
	public Curso() {
		alumnos = new ArrayList<Inscripcion>();
	}

	public Long getCursoId() {
		return cursoId;
	}

	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
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

	public int getCupoMaximo() {
		return cupoMaximo;
	}

	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public Docente getDocente() {
		return docente;
	}
	
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	public Carrera getCarrera() {
		return carrera;
	}
	
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	public List<Inscripcion> getAlumnos(){
		return alumnos;
	}
	
	public void setAlumnos(List<Inscripcion> alumnos) {
		this.alumnos = alumnos;
	}
	
	public void addAlumno(Inscripcion alumno) {
		alumnos.add(alumno);
	}
}
