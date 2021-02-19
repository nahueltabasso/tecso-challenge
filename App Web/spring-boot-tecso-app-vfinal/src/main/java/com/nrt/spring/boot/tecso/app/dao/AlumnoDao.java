package com.nrt.spring.boot.tecso.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.nrt.spring.boot.tecso.app.entity.Alumno;

public interface AlumnoDao extends CrudRepository<Alumno, Long>{

}
