package students.model;


/**
 * Clase curso
 *
 * @author Juan Esteban Cardona Velásquez
 * @author Juan Esteban Ramírez Tabares
 * @author Jose Manuel Taborda Escobar
 *
 */
public class Curso {

	private String nombre;
	private String codigo;
	private int intensidadHoraria;
	private int creditos;
	private Estudiante estudiante1;
	private Estudiante estudiante2;


	/**
	 * Constructor de la clase Curso
	 *
	 * @param nombre
	 * @param codigo
	 * @param intensidadHoraria
	 * @param creditos
	 */
	public Curso(String nombre, String codigo, int intensidadHoraria, int creditos) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.intensidadHoraria = intensidadHoraria;
		this.creditos = creditos;
	}


	/**
	 * Este metodo obtiene el nombre del curso
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Este metodo cambia el nombre del curso
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Este metodo obtiene el codigo del curso
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Este metodo cambia el codigo del curso
	 * @param nombre
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Este metodo obtiene la intensidad horaria del curso
	 * @return
	 */
	public int getIntensidadHoraria() {
		return intensidadHoraria;
	}

	/**
	 * Este metodo cambia la intensidad horaria del curso
	 * @param nombre
	 */
	public void setIntensidadHoraria(int intensidadHoraria) {
		this.intensidadHoraria = intensidadHoraria;
	}

	/**
	 * Este metodo obtiene el numero de creditos del curso
	 * @return
	 */
	public int getCreditos() {
		return creditos;
	}

	/**
	 * Este metodo cambia el numero de creditos del curso
	 * @param nombre
	 */
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	/**
	 * Este metodo obtiene el estudiante 1
	 * @return
	 */
	public Estudiante getEstudiante1() {
		return estudiante1;
	}

	/**
	 * Este metodo cambia el estudiante 1
	 * @param nombre
	 */
	public void setEstudiante1(Estudiante estudiante1) {
		this.estudiante1 = estudiante1;
	}

	/**
	 * Este metodo obtiene el estudiante 2
	 * @return
	 */
	public Estudiante getEstudiante2() {
		return estudiante2;
	}

	/**
	 * Este metodo cambia el estudiante 2
	 * @param nombre
	 */
	public void setEstudiante2(Estudiante estudiante2) {
		this.estudiante2 = estudiante2;
	}

	/**
	 * Metodo que convierte a String los atributos de la clase
	 */
	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", codigo=" + codigo + ", intensidadHoraria=" + intensidadHoraria
				+ ", creditos=" + creditos + ", estudiante1=" + estudiante1 + ", estudiante2=" + estudiante2 + "]";
	}


	//------------------------------------------TALLER---------------------------------------

	//Punto 5: Calcular promedio curso

	/**
	 * Este metodo calcula el promedio del curso
	 *
	 * @return
	 */
	public double calcularPromedioCurso(){

		double promedioCurso = 0;
		double notaDefinitivaEstudiante1 = estudiante1.calcularNotaDefinitiva();
		double notaDefinitivaEstudiante2 = estudiante2.calcularNotaDefinitiva();

		promedioCurso = (notaDefinitivaEstudiante1 + notaDefinitivaEstudiante2)/2;

		return promedioCurso;

	}

	//Punto 7: Calcular promedio nota 1

	/**
	 * Este metodo calcula el promedio de la nota 1
	 * @return
	 */
	public double calcularPromedioNota1(){

		double promedioNota1 = 0;

		promedioNota1 = (estudiante1.getNota1() + estudiante2.getNota1())/2;

		return promedioNota1;
	}

	//Punto 8: Calcular nota mayor del curso

	/**
	 * Este metodo obtiene la nota más alta del curso
	 * @return
	 */
	public double obtenerNotaMayorCurso(){

		double notaMayor = 0;

		if(estudiante1.calcularNotaDefinitiva() > estudiante2.calcularNotaDefinitiva()){
			notaMayor = estudiante1.calcularNotaDefinitiva();
		}
		else{
			notaMayor = estudiante2.calcularNotaDefinitiva();
		}

		return notaMayor;
	}

	//Punto 9: Calcular nota menor del curso

	/**
	 * Este metodo obtiene la nota menor del curso
	 * @return
	 */
	public double obtenerNotaMenorCurso(){

		double notaMenor = 0;

		if(estudiante1.calcularNotaDefinitiva()<estudiante2.calcularNotaDefinitiva()){
			notaMenor = estudiante1.calcularNotaDefinitiva();
		}
		else{
			notaMenor = estudiante2.calcularNotaDefinitiva();
		}

		return notaMenor;
	}

	//Punto 10: Porcentaje de los que ganron el curso

	/**
	 * Este metodo muestra el porcentaje de los que ganaron el curso
	 * @return
	 */
	public String porcentajeGanaronCurso(){

		String mensaje = "";

		if(estudiante1.verificarGanoPerdio() == true && estudiante2.verificarGanoPerdio() == true){

			mensaje = "El 100% de los estudiantes ganaron el curso";
		}

		if(estudiante1.verificarGanoPerdio() == true && estudiante2.verificarGanoPerdio() == false){

			mensaje = "El 50% de los estudiantes ganaron el curso";
		}

		if(estudiante1.verificarGanoPerdio() == false && estudiante2.verificarGanoPerdio() == true){

			mensaje = "El 50% de los estudiantes ganaron el curso";
		}
		else{
			mensaje = "El 0% de los estudiantes ganaron el curso";
		}

		return mensaje;
	}

	//Punto 11: Porcentaje de los que perdieron el curso

	/**
	 * Este metodo muestra el porcentaje de los que perdieron el curso
	 * @return
	 */
	public String porcentajePerdieronCurso(){

		String mensaje = "";

		if(estudiante1.verificarGanoPerdio() == false && estudiante2.verificarGanoPerdio() == false){

			mensaje = "El 100% de los estudiantes perdieron el curso";
		}

		if(estudiante1.verificarGanoPerdio() == true && estudiante2.verificarGanoPerdio() == false){

			mensaje = "El 50% de los estudiantes perdieron el curso";
		}

		if(estudiante1.verificarGanoPerdio() == false && estudiante2.verificarGanoPerdio() == true){

			mensaje = "El 50% de los estudiantes perdieron el curso";
		}
		else{
			mensaje = "El 0% de los estudiantes perdieron el curso";
		}

		return mensaje;
	}

	//Punto 12: Estudiantes con notas mayor a 4

	/**
	 * Este metodo obtiene el estudiante cuyas notas son mayores a 4
	 * @return
	 */
	public Estudiante obtenerEstudianteNotasMayor4(){

		Estudiante estudiante = null;

		if(estudiante1.getNota1() >= 4 && estudiante1.getNota2() >= 4 && estudiante1.getNota3() >= 4){

			estudiante = estudiante1;
		}

		if(estudiante2.getNota1() >= 4 && estudiante2.getNota2() >= 4 && estudiante2.getNota3() >= 4){

			estudiante = estudiante2;
		}

		return estudiante;
	}


}
