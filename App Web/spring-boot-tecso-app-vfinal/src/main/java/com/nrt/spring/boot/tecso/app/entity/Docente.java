package com.nrt.spring.boot.tecso.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "docente")
public class Docente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "docente_id")
	private Long docenteId;
	private String nombre;
	private String apellido;
	@OneToMany(mappedBy="docente", fetch=FetchType.LAZY)
	private List<Curso> cursosDocente;
	
	public Docente() {
		cursosDocente = new ArrayList<Curso>();
	}

	public Long getDocenteId() {
		return docenteId;
	}

	public void setDocenteId(Long docenteId) {
		this.docenteId = docenteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public List<Curso> getCursosDocente(){
		return cursosDocente;
	}
	
	public void setCursosDocente(List<Curso> cursosDocente) {
		this.cursosDocente = cursosDocente;
	}
}
