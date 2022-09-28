package libreria.exceptions;

public class ClienteException extends Exception {

	/**
	 * Identidicador de la clase
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase
	 *
	 * @param mensaje
	 */
	public ClienteException(String mensaje) {
		super(mensaje);
	}
}
