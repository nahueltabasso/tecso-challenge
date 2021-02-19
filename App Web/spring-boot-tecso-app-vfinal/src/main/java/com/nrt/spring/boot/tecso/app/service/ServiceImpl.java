package com.nrt.spring.boot.tecso.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nrt.spring.boot.tecso.app.dao.AlumnoDao;
import com.nrt.spring.boot.tecso.app.dao.CarreraDao;
import com.nrt.spring.boot.tecso.app.dao.CursoDao;
import com.nrt.spring.boot.tecso.app.dao.InscripcionDao;
import com.nrt.spring.boot.tecso.app.entity.Alumno;
import com.nrt.spring.boot.tecso.app.entity.Carrera;
import com.nrt.spring.boot.tecso.app.entity.Curso;
import com.nrt.spring.boot.tecso.app.entity.Inscripcion;

@Service
public class ServiceImpl implements ServiceInterface{

	@Autowired
	public AlumnoDao alumnoDao;
	@Autowired
	public CursoDao cursoDao;
	@Autowired
	public CarreraDao carreraDao;
	@Autowired
	public InscripcionDao inscripcionDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Alumno> findAllAlumnos() {
		return (List<Alumno>) alumnoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Alumno findAlumno(Long alumnoId) {
		return alumnoDao.findById(alumnoId).orElse(null);
	}

	@Override
	@Transactional
	public void saveAlumno(Alumno alumno) {
		alumnoDao.save(alumno);
	}

	@Override
	@Transactional
	public void deleteAlumno(Long alumnoId) {
		alumnoDao.deleteById(alumnoId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Curso> findAllCursos() {
		return (List<Curso>) cursoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Curso findCurso(Long cursoId) {
		return cursoDao.findById(cursoId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Carrera findCarrera(Long carreraId) {
		return carreraDao.findById(carreraId).orElse(null);
	}

	@Override
	@Transactional
	public void saveInscripcion(Inscripcion inscripcion) {
		inscripcionDao.save(inscripcion);
	}

	@Override
	public List<Carrera> findAllCarreras() {
		return (List<Carrera>) carreraDao.findAll();
	}
}
