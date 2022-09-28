package libreria.test;

import org.junit.Before;
import org.junit.Test;

// Se importan las Clases necesarias
import libreria.model.Libreria;
import libreria.model.Libro;
import libreria.model.Periodico;
import libreria.model.Revista;
import libreria.model.TipoFormato;

/**
 * Esta Clase testea los metodos para saber si funcionan correctamente
 *
 * @author Juanes Cardona
 *
 */
public class pruebasUnitarias {
	// Declaracion de atributos
	Libreria lib;

	/**
	 * Metodo que inicializa las variables con algunos valores
	 */
	@Before
	public void antesDe() {
		lib = new Libreria("Cervantes", 1, 1, 1, 1);
	}

	/**
	 * Metodo que evalua si la funcion crearLibro funciona
	 */
	@Test
	public void crearLibro() {

		// Se crea un libro con todos sus atributos y se le pasa al metodo
		// crearLibro() para que as� lo guarde en el arreglo
		// listaTextosLiterarios[]
		Libro libro1 = new Libro("Harry Potter", "Edit Azul", "387233", "Disponible", 150, TipoFormato.IMPRESO, 50.0,
				"espa�ol", 7000, 1999, null, "JKH383HD83");
		String libro = lib.crearLibro(libro1);

		// Se crea un nuevo libro que tiene los mismos atributos que el primero
		// y se le pasa al metodo crearLibro() para que lo agregue al arreglo,
		// sin embargo, dar� una excepcion puesto que el libro ya existe
		Libro libro2 = new Libro("Harry Potter", "Edit Azul", "387233", "Disponible", 150, TipoFormato.IMPRESO, 50.0,
				"espa�ol", 7000, 1999, null, "JKH383HD83");
		String libr = lib.crearLibro(libro2);

		// Se imprimen los resultados
		System.out.println(libro);
		System.out.println(libr);
	}

	/**
	 * Metodo que evalua si la funcion crearRevista funciona
	 */
	@Test
	public void crearRevista() {

		// Se crea una revista con todos sus atributos y se le pasa al metodo
		// crearRevista() para que as� lo guarde en el arreglo
		// listaTextosLiterarios[]
		Revista revista1 = new Revista("TheEconomist", "TheEconomist", "37768239489", "Disponible", 50,
				TipoFormato.DIGITAL, 3.5, "Espa�ol", 50, 2022, "Economia", "K3J43U8DUH");
		String revista = lib.crearRevista(revista1);

		// Se crea una nueva revista que tiene los mismos atributos que la
		// primera
		// y se le pasa al metodo crearRevista() para que lo agregue al arreglo,
		// sin embargo, dar� una excepcion puesto que la revista ya existe
		Revista revista2 = new Revista("TheEconomist", "TheEconomist", "37768239489", "Disponible", 50,
				TipoFormato.DIGITAL, 3.5, "Espa�ol", 50, 2022, "Economia", "K3J43U8DUH");
		String revist = lib.crearRevista(revista2);

		// Se imprimen los resultados
		System.out.println(revista);
		System.out.println(revist);
	}

	/**
	 * Metodo que evalua si la funcion crearPeriodico funciona
	 */
	@Test
	public void crearPeriodico() {

		// Se crea un periodico con todos sus atributos y se le pasa al metodo
		// crearPeriodico() para que as� lo guarde en el arreglo
		// listaTextosLiterarios[]
		Periodico periodico1 = new Periodico("titulo", "editorial", "1234", "disponible", 0, TipoFormato.DIGITAL, 1500,
				"espa�ol", 56, 2022, "armenia");
		String periodico = lib.crearPeriodico(periodico1);

		// Se crea un nuevo periodico los mismos atributos que tiene el primero
		// y se le pasa al metodo crearPeriodico() para que lo agregue al
		// arreglo, sin embargo, dar� una excepcion puesto que el periodico ya
		// existe
		Periodico periodico2 = new Periodico("titulo", "editorial", "1234", "disponible", 0, TipoFormato.DIGITAL, 1500,
				"espa�ol", 56, 2022, "armenia");
		String periodic = lib.crearPeriodico(periodico2);

		// Se imprimen los resultados
		System.out.println(periodico);
		System.out.println(periodic);
	}
}
