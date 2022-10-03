package grupoEstudiantes.exceptions;

/**
 * Clase que representa una excepcion por si el estudiantes esta repetido
 *
 * @author Juanes Cardona
 *
 */
public class EstudianteException extends Exception {

	/**
	 * Id de la clase
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase
	 *
	 * @param mensaje
	 */
	public EstudianteException(String mensaje) {
		super(mensaje);
	}

}
