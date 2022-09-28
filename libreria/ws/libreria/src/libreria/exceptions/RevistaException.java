package libreria.exceptions;

public class RevistaException extends Exception {

	/**
	 * identificador de la clase
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase
	 *
	 * @param mensaje
	 */
	public RevistaException(String mensaje) {
		super(mensaje);
	}
}
