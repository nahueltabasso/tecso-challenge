package com.nrt.spring.boot.tecso.app.service;

import java.util.List;

import com.nrt.spring.boot.tecso.app.entity.Alumno;
import com.nrt.spring.boot.tecso.app.entity.Carrera;
import com.nrt.spring.boot.tecso.app.entity.Curso;
import com.nrt.spring.boot.tecso.app.entity.Inscripcion;

public interface ServiceInterface {

	public List<Alumno> findAllAlumnos();
	
	public Alumno findAlumno(Long alumnoId);
	
	public void saveAlumno(Alumno alumno);
	
	public void deleteAlumno(Long alumnoId);
	
	public List<Curso> findAllCursos();
	
	public Curso findCurso(Long cursoId);	
	
	public Carrera findCarrera(Long carreraId);
	
	public List<Carrera> findAllCarreras();
	
	public void saveInscripcion(Inscripcion inscripcion);
}

