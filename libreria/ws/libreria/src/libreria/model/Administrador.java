package libreria.model;

/**
 * Clase administrador
 * 
 * @author Juanes Cardona
 *
 */
public class Administrador extends Empleado {
	// Declaracion de atributos
	private String profesion;

	/**
	 * Constructor de la clase administrador
	 * 
	 * @param nombre
	 * @param correo
	 * @param cedula
	 * @param direccion
	 * @param salario
	 * @param profesion
	 */
	public Administrador(String nombre, String correo, String cedula, String direccion, int salario, String profesion) {
		super(nombre, correo, cedula, direccion, salario);
		this.profesion = profesion;
	}

	/**
	 * get profesion
	 * 
	 * @return
	 */
	public String getProfesion() {
		return profesion;
	}

	/**
	 * set profesion
	 * 
	 * @param profesion
	 */
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	/**
	 * Convierte en una cadena los atributos
	 */
	@Override
	public String toString() {
		return "Administrador [profesion=" + profesion + "]";
	}
}