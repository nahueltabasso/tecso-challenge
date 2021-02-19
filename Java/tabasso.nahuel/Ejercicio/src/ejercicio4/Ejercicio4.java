package ejercicio4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

	public class Ejercicio4 {

		// listas de ejemplo, pueden variarse su contenido, 
		static Integer[] valoresLista1 = {1, 2, 5, 8, 10, 30, 20, 8, 9, 10};
		static Integer[] valoresLista2 = {1, 2, 4, 20, 5, 10, 7, 8, 10, 9};

		/**	 
		 * Para ejecutar el método main se debe hacer boton derecho sobre la clase
		 * "Run As --> Java Application" 
		 * @param args
		 */
		public static void main(String[] args) {
			
			System.out.println("**** inicializando datos ****");
			
			List<Integer> lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
			List<Integer> lista2 = new ArrayList<Integer>(Arrays.asList(valoresLista2));
		
			System.out.println("**** inicializacion exitosa ****");

			// EJERCICIO 4.1: explicar salidas y sugerir mejoras
			informacion(lista1, 10);
			
			// EJERCICIO 4.2: corregir el metodo
			List<Integer> union = unionListas(lista1, lista2);
			System.out.println("union: " + union.toString());
			
			// EJERCICIO 4.3: implementar
			List<Integer> interseccion = interseccionListas(lista1, lista2);
			System.out.println("interseccion: " + interseccion.toString());
			
			// EJERCICIO 4.4: implementar
			List<Integer> orden1 = ordenaListaAscendente(lista1);
			System.out.println("orden asc: " + orden1);
			
			// EJERCICIO 4.5: implementar
			List<Integer> orden2 = ordenaListaDescendente(lista2);
			System.out.println("orden desc: " + orden2);

			// EJERCICIO 4.6: implementar
			boolean b = tienenMismoContenido(lista1, lista2);
			System.out.println("mismo contenido: " + b);
			
		}

		private static void informacion(List<Integer> lista1, Integer numero) {
			// TODO: explicar salidas de los system out y sugerir alguna mejora a la implementacion
			int pares = 0;
			int c = 0;
			List<Integer> impares = new ArrayList<Integer>();
			for(Integer n: lista1) {
				if(n % 2 == 0) {
					pares = pares + 1;
				}else {
					impares.add(n);
				}
				if(n > numero) {
					c++;
				}
			}
			//Muestra en la consola la cantidad de numeros pares que hay en la lista pasada como argumento del metodo
			System.out.println("... " + pares);
			//Muestra una lista con los numeros impares que hay en la lista pasada como argumento del metodo
			System.out.println("... " + impares.toString());
			//Muestra en que posicion de la lista (lista1) se encuentra el resultado de [lista1.size()/"]
			System.out.println("..." + lista1.indexOf(lista1.size()/2));
			
			if (c > lista1.size() / 2) {
				//el contador c cuenta la cantidad de objetos de tipo Integer mayores a numero (argumento del metodo)
				//Muestra si c conto mas de la mitad de los objetos de tipo Integer de la lista lista1
				System.out.println("..." + c);
			} else if (c > 0) {
				//Muestra si c es mayor a cero
				System.out.println("..." + c);
			} else {
				System.out.println("..." + c);
			}
		}

		/***
		 * @param lista1
		 * @param lista2
		 * 
		 * retornar una lista que contenga los elementos de ambas listas, sin elementos repetidos 
		 * 
		 */
		private static List<Integer> unionListas(List<Integer> lista1, List<Integer> lista2) {
			// TODO: corregir el metodo para que funcione correctamente 
			
			List<Integer> union = new ArrayList<Integer>();
			
			union.addAll(lista1);
			
			for (Integer m: lista2) {
				if (union.contains(m)) {
					union.add(m);
				}
			}
			return union;
		}

		/***
		 * @param lista1
		 * @param lista2
		 * 
		 * retornar una lista que contenga los elementos que estan presentes en ambas listas, sin elementos repetidos 
		 * 
		 */
		private static List<Integer> interseccionListas(List<Integer> lista1, List<Integer> lista2) {
			// TODO:
			List<Integer> interseccion = new ArrayList<Integer>();
			for(Integer m: lista1) {
				if(lista2.contains(m)) {
					interseccion.add(m);
				}
			}
			return interseccion;
		}

		/***
		 * @param lista1
		 * 
		 * retornar la lista recibida, ordenada en forma ascendente
		 * 
		 */
		private static List<Integer> ordenaListaAscendente(List<Integer> lista1) {
			// TODO:
			Collections.sort(lista1);
			return lista1;
		}

		/***
		 * @param lista2
		 * 
		 * retornar la lista recibida, ordenada en forma descendente
		 * 
		 */
		private static List<Integer> ordenaListaDescendente(List<Integer> lista2) {
			// TODO:
			Comparator<Integer> comp = Collections.reverseOrder();
			Collections.sort(lista2, comp);
			return lista2;
		}

		/***
		 * @param lista1
		 * @param lista2
		 * 
		 * devuelve true si contienen los mismos elementos
		 * NO se considera valido que esten en diferente orden
		 * NO se considera valido que la cantidad de repeticiones de los elementos sea diferente
		 * 
		 */
		private static boolean tienenMismoContenido(List<Integer> lista1, List<Integer> lista2) {
			List<Integer> iguales = new ArrayList<Integer>();
			int i = 0;
			boolean flag = true;
			while(flag == true) {
				if(lista1.get(i) == lista2.get(i)) {
					iguales.add(lista1.get(i));
					i++;
				}else {
					flag = false;
				}
			}
			boolean c;
			if(iguales.size() == lista1.size()) {
				c = true;
			}else {
				c = false;
			}
			return c;
		}

	}
