package com.nrt.spring.boot.tecso.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nrt.spring.boot.tecso.app.entity.Curso;
import com.nrt.spring.boot.tecso.app.service.ServiceInterface;

@Controller
public class CursoController {
	
	@Autowired
	public ServiceInterface service;
	
	/**
	 * Este metodo carga en model el curso a traves de su id para la vista perfil-curso
	 * @param cursoId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/detalle-curso/{cursoId}"}, method=RequestMethod.GET)
	public String verDetalleCurso(@PathVariable(value = "cursoId") Long cursoId, Model model) {
		Curso curso = service.findCurso(cursoId);
		model.addAttribute("titulo", curso.getNombre());
		model.addAttribute("curso", curso);
		return "perfil-curso";
	}

	/**
	 * Metodo para listar los cursos registrados en la base de datos
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/cursos"}, method=RequestMethod.GET)
	public String listarCursos(Model model) {
		List<Curso> cursos = service.findAllCursos();
		model.addAttribute("titulo", "Cursos");
		model.addAttribute("cursos", cursos);
		return "listar-cursos";
	}
}
