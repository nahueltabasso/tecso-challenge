package com.nrt.spring.boot.tecso.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nrt.spring.boot.tecso.app.entity.Alumno;
import com.nrt.spring.boot.tecso.app.service.ServiceInterface;

@Controller
public class AlumnoController {
	
	@Autowired
	private ServiceInterface service;

	/**
	 * Este metodo añade a model el objeto alumno necesario para la vista perfil-alumno
	 * @param alumnoId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"perfil/{alumnoId}"}, method=RequestMethod.GET)
	public String perfilAlumno(@PathVariable(value = "alumnoId") Long alumnoId, Model model) {
		Alumno alumno = service.findAlumno(alumnoId);
		alumno.calcularPromedio();
		model.addAttribute("titulo", "Perfil: " + alumno.getNombre() + " " + alumno.getApellido());
		model.addAttribute("alumno", alumno);
		return "perfil-alumno";
	}
	
	/**
	 * Este metodo lista los alumnos registrados en la base de datos
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/alumnos"}, method=RequestMethod.GET)
	public String listarAlumnos(Model model) {
		List<Alumno> alumnos = service.findAllAlumnos();
		model.addAttribute("titulo", "Alumnos");
		model.addAttribute("alumnos", alumnos);
		return "listar-alumnos";
	}
	
	/**
	 * Metodo para crear un nuevo alumno
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/formulario-alumno"}, method=RequestMethod.GET)
	public String agregarAlumno(Model model) {
		Alumno alumno = new Alumno();
		model.addAttribute("titulo", "Formulario Alumno");
		model.addAttribute("alumno", alumno);
		return "formulario-alumno";
	}
	
	/**
	 * Este metodo procesa, valida y registra en la base de datos el nuevo alumno
	 * @param alumno
	 * @param result
	 * @param model
	 * @param flash
	 * @return
	 */
	@RequestMapping(value = {"/formulario-alumno"}, method=RequestMethod.POST)
	public String guardarAlumno(@Valid Alumno alumno, BindingResult result, Model model, RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Alumno");
			return "formulario-alumno";
		}
		String mensaje = (alumno.getAlumnoId() != null)? "Alumno editado con exito!" : "Alumno creado con exito";
		service.saveAlumno(alumno);
		flash.addFlashAttribute("success", mensaje);
		return "redirect:/alumnos";
	}
	
	/**
	 * Metodo para editar un alumno a traves de su id
	 * @param alumnoId
	 * @param model
	 * @param flash
	 * @return
	 */
	@RequestMapping(value = {"/formulario-alumno/{alumnoId}"}, method=RequestMethod.GET)
	public String editarAlumno(@PathVariable(value = "alumnoId") Long alumnoId, Model model, RedirectAttributes flash) {
		Alumno alumno = null;
		if(alumnoId > 0) {
			alumno = service.findAlumno(alumnoId);
			if(alumno == null) {
				flash.addFlashAttribute("error", "El alumno no existe en la base de datos");
				return "redirect:/alumno";
			}
		}else {
			flash.addFlashAttribute("error", "ID de alumno no puede ser cero!");
			return "redirect:/alumnos";
		}
		model.addAttribute("titulo", "Editar Datos Personales de: " + alumno.getNombre() + " " + alumno.getApellido());
		model.addAttribute("alumno", alumno);
		return "formulario-alumno";
	}
	
	/**
	 * Metodo para eliminar un alumno a traves de su id
	 * @param alumnoId
	 * @param flash
	 * @return
	 */
	@RequestMapping(value = {"/eliminar/{alumnoId}"})
	public String eliminarAlumno(@PathVariable(value = "alumnoId") Long alumnoId, RedirectAttributes flash) {
		if(alumnoId > 0) {
			service.deleteAlumno(alumnoId);
			flash.addFlashAttribute("success", "Alumno eliminado con exito!");
		}
		return "redirect:/alumnos";
	}
}
