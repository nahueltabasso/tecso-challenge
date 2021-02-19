package ejercicio2;

import java.util.Date;

public class Persona {

	private String tipoDocumento;
	 private Integer nroDocumento;
	 private String nombre;
	 private String apellido;
	 private Date fechaNaciemento;

	 //Constructor Vacio
	 public Persona() {}
	 
	 //Constructor con parametros
	 public Persona(String tipoDocumento, int nroDocumento, String nombre, String apellido,
			 Date fechaNacimiento) {
		 this.tipoDocumento = tipoDocumento;
		 this.nroDocumento = nroDocumento;
		 this.nombre = nombre;
		 this.apellido = apellido;
		 this.fechaNaciemento = fechaNacimiento;
	 }

	//Getters/Setters 
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(Integer nroDocumento) {
		this.nroDocumento = nroDocumento;
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

	public Date getFechaNaciemento() {
		return fechaNaciemento;
	}

	public void setFechaNaciemento(Date fechaNaciemiento) {
		this.fechaNaciemento = fechaNaciemiento;
	}

	//Metodo toString()
	@Override
	public String toString() {
		return "Persona [tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", fechaNaciemento=" + fechaNaciemento + "]";
	}	
}
