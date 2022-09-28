package libreria.exceptions;

public class PeriodicoException extends Exception {

	/**
	 * identificador de la clase
	 */
	private static final long serialVersionUID = 1L;

	//
	/**
	 * Constructor de la clase
	 *
	 * @param mensaje
	 */
	public PeriodicoException(String mensaje) {
		super(mensaje);
	}

}
