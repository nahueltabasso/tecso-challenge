package ejercicio3;

import ejercicio2.Persona;

public class Alumno {

	private Persona persona;
	private Integer legajo;
	
	//Constructor vacio
	public Alumno() {}
	
	//Constructor con parametros
	public Alumno(Persona persona, Integer legajo) {
		this.persona = persona;
		this.legajo = legajo;
	}

	//Getters/Setters
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	//Metodo toString()
	@Override
	public String toString() {
		return "Alumno [persona=" + persona + ", legajo=" + legajo + "]";
	}
}
