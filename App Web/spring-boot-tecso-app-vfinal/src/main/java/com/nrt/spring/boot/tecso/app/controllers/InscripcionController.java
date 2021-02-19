package com.nrt.spring.boot.tecso.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nrt.spring.boot.tecso.app.entity.Alumno;
import com.nrt.spring.boot.tecso.app.entity.Curso;
import com.nrt.spring.boot.tecso.app.entity.Inscripcion;
import com.nrt.spring.boot.tecso.app.service.ServiceInterface;

@Controller
@RequestMapping("/inscripcion-curso")
@SessionAttributes("inscripcion")
public class InscripcionController {
	
	@Autowired
	private ServiceInterface service;
	
	
	/**
	 * En este metodo se añaden en el model los objetos necesarios para la vista inscripcion-curso
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/completar-inscripcion"})
	public String crearInscripcion(Model model) {
		Inscripcion inscripcion = new Inscripcion();
		List<Alumno> alumnos = service.findAllAlumnos();
		List<Curso> cursos = service.findAllCursos();
		model.addAttribute("titulo", "Inscripcion a Curso");
		model.addAttribute("inscripcion", inscripcion);
		model.addAttribute("cursos", cursos);
		model.addAttribute("alumnos", alumnos);
		return "inscripcion-curso";
	}
	
	/**
	 * En este metodo se procesa, se valida y se registra en la base de datos la inscripcion
	 * @param alumnoId
	 * @param cursoId
	 * @param inscripcion
	 * @param model
	 * @param flash
	 * @param status
	 * @return
	 */
	@RequestMapping(value = {"/registrar-inscripcion"}, method = RequestMethod.POST)
	public String guardarInscripcion(@RequestParam(name = "alumnoId", required = true) Long alumnoId,
									 @RequestParam(name = "cursoId", required = true) Long cursoId, 
									 Inscripcion inscripcion, Model model, RedirectAttributes flash, SessionStatus status) {
		Alumno alumno = service.findAlumno(alumnoId);
		Curso curso = service.findCurso(cursoId);
		inscripcion.setAlumno(alumno);
		inscripcion.setCurso(curso);
		if(inscripcion.getAlumno().validarInscripcion(curso) == true) {
			flash.addFlashAttribute("error", "Ya esta inscripto en este curso");
			return "inscripcion-curso";
		}
		if(inscripcion.getAlumno().validarCarrera(curso) == true) {
			flash.addFlashAttribute("error", "Este curso no pertenece a su carrera");
			return "inscripcion-curso";
		}
		service.saveInscripcion(inscripcion);
		status.setComplete();
		flash.addFlashAttribute("success", "Inscripcion exitosa!");
		return "redirect:/perfil/" + alumno.getAlumnoId().toString();
	}
}

