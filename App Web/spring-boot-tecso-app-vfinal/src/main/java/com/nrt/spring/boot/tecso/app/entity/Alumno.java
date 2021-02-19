package com.nrt.spring.boot.tecso.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "alumno")
public class Alumno implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alumno_id")
	private Long alumnoId;
	@Column(name = "tipo_documento")
	@NotEmpty
	private String tipoDocumento;
	@Column(name = "nro_documento")
	@NotEmpty
	@Size(min=8, max=9)
	private String nroDocumento;
	@NotNull
	private int legajo;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date fechaNacimiento;
	@ManyToMany
	@JoinTable(name = "inscripciones_carrera",
			joinColumns = @JoinColumn(name = "alumno_id"),
			inverseJoinColumns = @JoinColumn(name = "carrera_id"))
	private List<Carrera> carreras;
	@Column(name = "promedio_carrera")
	private Double promedioCarrera;
	@OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Inscripcion> cursos;
	
	public Alumno() {
		cursos = new ArrayList<Inscripcion>();
	}
	
	public Long getAlumnoId() {
		return alumnoId;
	}

	public void setAlumnoId(Long alumnoId) {
		this.alumnoId = alumnoId;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public List<Carrera> getCarreras() {
		return carreras;
	}
	
	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}
	
	public Double getPromedioCarrera() {
		return promedioCarrera;
	}

	public void setPromedioCarrera(Double promedioCarrera) {
		this.promedioCarrera = promedioCarrera;
	}
	
	public List<Inscripcion> getCursos(){
		return cursos;
	}
	
	@SuppressWarnings("unused")
	private void setCursos(List<Inscripcion> cursos) {
		this.cursos = cursos;
	}
	
	public void addCurso(Inscripcion curso) {
		cursos.add(curso);
	}
	
	public boolean validarInscripcion(Curso curso) {
		for(Inscripcion i : cursos) {
			if(i.getCurso().getCursoId() == curso.getCursoId()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean validarCarrera(Curso curso) {
		for(Carrera c : carreras) {
			if(c.getCarreraId() == curso.getCarrera().getCarreraId()) {
				return false;
			}
		}
		return true;
	}
	
	public void calcularPromedio() {
		promedioCarrera = 0.0;
		int c = 0;
		for(Inscripcion i : cursos) {
			if(i.getNota() != null) {
			promedioCarrera = promedioCarrera + i.getNota();
			c++;
			}
		}
		promedioCarrera = promedioCarrera / c;
	}
}
