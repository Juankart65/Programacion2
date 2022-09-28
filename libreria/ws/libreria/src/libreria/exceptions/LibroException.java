package libreria.exceptions;

public class LibroException extends Exception {

	/**
	 * identificador de la clase
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase
	 *
	 * @param mensaje
	 */
	public LibroException(String mensaje) {
		super(mensaje);
	}
}
