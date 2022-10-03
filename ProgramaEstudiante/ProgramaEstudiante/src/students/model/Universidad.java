package students.model;

/**
 * Clase universidad
 *
 * @author Juan Esteban Cardona Velásquez
 * @author Juan Esteban Ramírez Tabares
 * @author Jose Manuel Taborda Escobar
 *
 */
public class Universidad {

	private String nombre;
	private Estudiante estudiante1;
	private Estudiante estudiante2;
	private Curso curso1;
	private Curso curso2;
	private Curso curso3;


	/**
	 * Constructor de la clase universidad
	 *
	 * @param nombre
	 */
	public Universidad(String nombre) {
		super();
		this.nombre = nombre;
	}


	/**
	 * Metodo para obtener el nombre de la universidad
	 *
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo para cambiar el nombre de la universidad
	 *
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo para obtener el estudiante 1
	 * @return
	 */
	public Estudiante getEstudiante1() {
		return estudiante1;
	}

	/**
	 * Metodo para cambiar el estudiante 1
	 *
	 * @param estudiante1
	 */
	public void setEstudiante1(Estudiante estudiante1) {
		this.estudiante1 = estudiante1;
	}

	/**
	 * Metodo para obtener el estudiante 2
	 * @return
	 */
	public Estudiante getEstudiante2() {
		return estudiante2;
	}

	/**
	 * Metodo para cambiar el estudiante 2
	 *
	 * @param estudiante2
	 */
	public void setEstudiante2(Estudiante estudiante2) {
		this.estudiante2 = estudiante2;
	}

	/**
	 * Metodo para obtener el curso 1
	 *
	 * @return
	 */
	public Curso getCurso1() {
		return curso1;
	}

	/**
	 * Metodo para cambiar el curso 1
	 * @param curso1
	 */
	public void setCurso1(Curso curso1) {
		this.curso1 = curso1;
	}

	/**
	 * Metodo para obtener el curso 2
	 *
	 * @return
	 */
	public Curso getCurso2() {
		return curso2;
	}

	/**
	 * Metodo para cambiar el curso 2
	 * @param curso2
	 */
	public void setCurso2(Curso curso2) {
		this.curso2 = curso2;
	}

	/**
	 * Metodo para obtener el curso 3
	 *
	 * @return
	 */
	public Curso getCurso3() {
		return curso3;
	}

	/**
	 * Metodo para cambiar el curso 3
	 * @param curso3
	 */
	public void setCurso3(Curso curso3) {
		this.curso3 = curso3;
	}


	/**
	 * Metodo que convierte a String los atributos de la clase
	 */

	@Override
	public String toString() {
		return "Universidad [nombre=" + nombre + ", estudiante1=" + estudiante1 + ", estudiante2=" + estudiante2
				+ ", curso1=" + curso1 + ", curso2=" + curso2 + ", curso3=" + curso3 + "]";
	}


	//----------------------------------------TALLER----------------------------------

	//Punto 1: Crear estudiantes asociados al curso

	/**
	 * Este metodo permite crear a los estudiantes con sus respectivos atributos
	 *
	 * @param nombre
	 * @param edad
	 * @param curso
	 * @param correo
	 * @param identificacion
	 * @param nota1
	 * @param nota2
	 * @param nota3
	 *
	 * @return si el estudiante ha sido creado
	 */
	public boolean crearEstudiante(String nombre, int edad, int curso, String correo, String identificacion, double nota1,
			double nota2, double nota3){

		boolean creado = false;
		boolean existe = false;
		boolean hayCupo = false;

		existe = verificarEstudiante(identificacion);
		hayCupo = hayCupo();

		if(hayCupo == true && existe == false){
			if(estudiante1 == null){
				estudiante1 = new Estudiante(nombre, edad, curso, correo, identificacion, nota1, nota2, nota3);
				creado = true;
			}
			else{
				estudiante2 = new Estudiante(nombre, edad, curso, correo, identificacion, nota1, nota2, nota3);
				creado = true;
			}
		}

		return creado;
	}


	/**
	 * Este metodo permite verificar si ya existe un estudiante creado
	 *
	 * @param identificacion
	 *
	 * @return si ya existe un estudiante creado o no
	 */

	private boolean verificarEstudiante(String identificacion) {

		boolean encontrado = false;

		if(estudiante1 != null && estudiante1.getIdentificacion().equals(identificacion)){
			encontrado = true;
		}
		if(estudiante2 != null && estudiante2.getIdentificacion().equals(identificacion)){
			encontrado = true;
		}
		return encontrado;
	}

	/**
	 * Este metodo verifica si hay cupo disponible
	 *
	 * @return si hay cupo o no
	 */
	private boolean hayCupo() {

		if(estudiante1 == null){
			return true;
		}
		if(estudiante2 == null){
			return true;
		}
		return false;
	}


	//Punto 2: eliminar un estudiante

	/**
	 * Este metodo permite eliminar un estudiante
	 *
	 * @param identificacion
	 *
	 * @return si ha sido eliminado
	 */
	public String eliminarEstudiante(String identificacion){

		String mensaje = "Estudiante eliminado";
		Estudiante estudiante = null;

		estudiante = buscarEstudiante(identificacion);

		if(estudiante == estudiante1){
			estudiante1 = null;
		}
		if(estudiante == estudiante2){
			estudiante2 = null;
		}

		return mensaje;
	}

	//Punto 3: Actualizar informacion de un estudiante

	/**
	 * Este metodo permite actualizar la informacion de un estudiante
	 *
	 * @param nombre
	 * @param edad
	 * @param curso
	 * @param correo
	 * @param identificacion
	 * @param nota1
	 * @param nota2
	 * @param nota3
	 *
	 * @return si ha sido actualizado o si no existe
	 */
	public String actualizarEstudiante(String nombre, int edad, int curso, String correo, String identificacion, double nota1,
			double nota2, double nota3){

		String mensaje = "Estudiante actualizado";

		Estudiante estudiante = null;

		estudiante = buscarEstudiante(identificacion);

		if(estudiante == null){
			mensaje = "EL estudiante no existe";
		}
		else{
			estudiante.setNombre(nombre);
			estudiante.setEdad(edad);
			estudiante.setCorreo(correo);
			estudiante.setCurso(curso);
		}

		return mensaje;
	}

	//Punto 4: Obtener un solo estudiante

	/**
	 * Este metodo permite buscar un estudiante que ya esté creado
	 *
	 * @param identificacion
	 *
	 * @return el estudiante que se encontró
	 */
	public Estudiante buscarEstudiante(String identificacion){

		Estudiante estudianteEncontrado = null;

		if(estudiante1 != null){
			if(estudiante1.getIdentificacion().equals(identificacion)){
				estudianteEncontrado = estudiante1;
			}
		}

		if(estudiante2 != null){
			if(estudiante2.getIdentificacion().equals(identificacion)){
				estudianteEncontrado = estudiante2;
			}
		}

		return estudianteEncontrado;
	}

	//Punto 6: calcular promedio edad

	/**
	 * Este metodo calcula la edad promedio de los estudiantes
	 *
	 * @return
	 */
	public double calcularEdadPromedio(){

		double edadPromedio = 0;

		edadPromedio = (estudiante1.getEdad() + estudiante2.getEdad())/2;

		return edadPromedio;
	}

	//Punto 14: obtener estudiante cuyo nombre inicie en vocal y su promedio sea mayor o igual a 3

	/**
	 * Este metodo obtiene el estudiante que su nombre inicia por vocal
	 * y tiene una nota definitiva mayor o igual a 3
	 * @return
	 */
	public Estudiante obtenerEstudianteVocalPromedio(){

		Estudiante estudiantePromedio = null;
		boolean cumpleVocalPromedio = false;

		if(estudiante1 != null){

			cumpleVocalPromedio = estudiante1.verificarVocalPromedio();

			if(cumpleVocalPromedio)estudiantePromedio = estudiante1;
		}

		if(estudiante2 != null){

			cumpleVocalPromedio = estudiante2.verificarVocalPromedio();

			if(cumpleVocalPromedio)estudiantePromedio = estudiante2;
		}

		return estudiantePromedio;

	}


}
