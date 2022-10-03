package students.model;

/**
 * Clase estudiante
 *
 * @author Juan Esteban Cardona Velásquez
 * @author Juan Esteban Ramírez Tabares
 * @author Jose Manuel Taborda Escobar
 *
 */
public class Estudiante {

	private String nombre;
	private int edad;
	private int curso;
	private String correo;
	private String identificacion;
	private double nota1;
	private double nota2;
	private double nota3;



	/**
	 * Constructor de la clase estudiante con todos sus tributos
	 *
	 * @param nombre
	 * @param edad
	 * @param curso
	 * @param correo
	 * @param identificacion
	 * @param nota1
	 * @param nota2
	 * @param nota3
	 */
	public Estudiante(String nombre, int edad, int curso, String correo, String identificacion, double nota1,
			double nota2, double nota3) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.curso = curso;
		this.correo = correo;
		this.identificacion = identificacion;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}


	/**
	 * Metodo que obtiene el nombre del estudiante
	 *
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * Metodo que cambia el nombre del estudiante
	 *
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * Metodo que obtiene la edad del estudiante
	 *
	 * @return
	 */
	public int getEdad() {
		return edad;
	}


	/**
	 * Metodo que cambia la edad del estudiante
	 *
	 * @param nombre
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}


	/**
	 * Metodo que obtiene el curso del estudiante
	 *
	 * @return
	 */
	public int getCurso() {
		return curso;
	}


	/**
	 * Metodo que cambia el curso del estudiante
	 *
	 * @param nombre
	 */
	public void setCurso(int curso) {
		this.curso = curso;
	}


	/**
	 * Metodo que obtiene el correo del estudiante
	 *
	 * @return
	 */
	public String getCorreo() {
		return correo;
	}


	/**
	 * Metodo que cambia el correo del estudiante
	 *
	 * @param nombre
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}


	/**
	 * Metodo que obtiene la identificacion del estudiante
	 *
	 * @return
	 */
	public String getIdentificacion() {
		return identificacion;
	}


	/**
	 * Metodo que cambia la identificacion del estudiante
	 *
	 * @param nombre
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	/**
	 * Metodo que obtiene la nota 1 del estudiante
	 *
	 * @return
	 */
	public double getNota1() {
		return nota1;
	}


	/**
	 * Metodo que cambia la nota 1 del estudiante
	 *
	 * @param nombre
	 */
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}


	/**
	 * Metodo que obtiene la nota 2 del estudiante
	 *
	 * @return
	 */
	public double getNota2() {
		return nota2;
	}


	/**
	 * Metodo que cambia la nota 2 del estudiante
	 *
	 * @param nombre
	 */
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}


	/**
	 * Metodo que obtiene la nota 3 del estudiante
	 *
	 * @return
	 */
	public double getNota3() {
		return nota3;
	}


	/**
	 * Metodo que cambia la nota 3 del estudiante
	 *
	 * @param nombre
	 */
	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

	/**
	 * Metodo que convierte a String los atributos de la clase
	 */

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", edad=" + edad + ", curso=" + curso + ", correo=" + correo
				+ ", identificacion=" + identificacion + ", nota1=" + nota1 + ", nota2=" + nota2 + ", nota3=" + nota3
				+ "]";
	}

	/**
	 * Metodo que verifica si las condiciones de iniciar con vocal y promedio mayor a 3
	 * se cumplen
	 * @return
	 */
	public boolean verificarVocalPromedio(){

		boolean vocalVerificada = false;
		boolean promedioVerificado = false;

		vocalVerificada = verificarInicialVocal();
		promedioVerificado = verificarPromedio();

		if(vocalVerificada == true && promedioVerificado == true){

			return true;
		}

		return false;
	}

	/**
	 * Metodo que comprueba si el promedio es mayor a 3
	 * @return
	 */
	private boolean verificarPromedio() {
		boolean verificado = false;

		if(calcularNotaDefinitiva() >= 3)verificado = true;
		return verificado;
	}



	/**
	 * Metodo que comprueba si el primer caracter del nombre es una vocal
	 *
	 * @return
	 */
	public boolean verificarInicialVocal(){

		boolean verificado = false;

		char letra = nombre.charAt(0);
		if(esVocal(letra)){

			verificado = true;
		}

		return verificado;
	}


	/**
	 * Metodo que verifica si es una vocal o no
	 * @param letra
	 * @return
	 */
	private boolean esVocal(char letra) {

		boolean verificado = false;


		if(letra == 'a' | letra == 'e' | letra == 'i' | letra == 'o' | letra == 'u'){

			verificado = true;
		}
		return verificado;
	}


	/**
	 * Este metodo verifica si el estudiante gano o perdio
	 * @return
	 */
	public boolean verificarGanoPerdio() {

		boolean gano = true;

		if(!(calcularNotaDefinitiva() >= 3.0)){
			return false;
		}
		return gano;
	}

	//--------------------------------TALLER------------------------------

	//Punto 13: Calcular nota definitiva

	/**
	 * Metodo que permite calcular la nota definitiva de un estudiante
	 * @return
	 */
	public double calcularNotaDefinitiva(){

		double notaDefinitiva = 0;

		notaDefinitiva = (nota1 + nota2 + nota3)/3;

		return notaDefinitiva;
	}

}
