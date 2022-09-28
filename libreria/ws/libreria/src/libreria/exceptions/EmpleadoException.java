package libreria.exceptions;

public class EmpleadoException extends Exception {

	/**
	 * Id de la clase
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase
	 *
	 * @param mensaje
	 */
	public EmpleadoException(String mensaje) {
		super(mensaje);
	}
}
