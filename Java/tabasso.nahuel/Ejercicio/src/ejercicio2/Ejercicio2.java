package ejercicio2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ejercicio2 {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = sdf.parse("1996-12-11");
		Persona p1 = new Persona();
		p1.setTipoDocumento("DNI");
		p1.setNroDocumento(39949799);
		p1.setNombre("Nahuel");
		p1.setApellido("Tabasso");
		p1.setFechaNaciemento(fecha);
		
		System.out.println(p1.toString());
	}
}