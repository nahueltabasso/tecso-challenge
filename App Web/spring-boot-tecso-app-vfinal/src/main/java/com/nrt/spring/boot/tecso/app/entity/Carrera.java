package com.nrt.spring.boot.tecso.app.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "carrera")
public class Carrera implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carrera_id")
	private Long carreraId;
	private String nombre;
	private String descripcion;
	private String siglas;
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_desde")
	private Date fechaDesde;
	@OneToMany(mappedBy="carrera", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Curso> cursosCarrera;
	@ManyToMany
	@JoinTable(name = "inscripciones_carrera",
			joinColumns = @JoinColumn(name = "carrera_id"),
			inverseJoinColumns = @JoinColumn(name = "alumno_id"))
	private List<Alumno> alumnosCarrera;

	public Long getCarreraId() {
		return carreraId;
	}

	public void setCarreraId(Long carreraId) {
		this.carreraId = carreraId;
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
	
	public String getSiglas() {
		return siglas;
	}
	
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public List<Curso> getCursosCarrera(){
		return cursosCarrera;
	}
	
	public void setCursosCarrera(List<Curso> cursosCarrera) {
		this.cursosCarrera = cursosCarrera;
	}
}
