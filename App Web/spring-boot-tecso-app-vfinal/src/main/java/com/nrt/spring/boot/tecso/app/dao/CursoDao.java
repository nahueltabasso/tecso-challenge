package com.nrt.spring.boot.tecso.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nrt.spring.boot.tecso.app.entity.Curso;

public interface CursoDao extends CrudRepository<Curso, Long>{
	
	@Query("select c from Curso c join  c.carrera car where car.carreraId = ?1 order by c.nombre ASC")
	public List<Curso> findCursosByCarreraId(Long carreraId); 
	/*
	@Query("select distinct c from Curso c join c.alumnos cur  where cur.alumno.alumnoId = ?1 order by c.nombre ASC" )
	public List<Curso> findCursosByAlumnoId(Long alumnoId);
	*/
}
