package com.nrt.spring.boot.tecso.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.context.annotation.SessionScope;

@Entity
@Table(name = "inscripciones_curso")
@SessionScope
public class Inscripcion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inscripcion_id")
	private Long inscripcionId;
	@Column(name = "fecha_inscripcion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaInscripcion;
	private String estado;
	private Double nota;
	@ManyToOne(fetch = FetchType.LAZY)
	private Alumno alumno;
	@ManyToOne(fetch = FetchType.LAZY)
	private Curso curso;
	
	@PrePersist
	public void prePersist() {
		fechaInscripcion = new Date();
		estado = "En curso";
		nota = null;
	}
	
	public Long getInscripcionId() {
		return inscripcionId;
	}

	public void setInscripcionId(Long inscripcionId) {
		this.inscripcionId = inscripcionId;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
