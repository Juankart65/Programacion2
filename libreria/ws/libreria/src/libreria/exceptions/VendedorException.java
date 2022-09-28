package libreria.exceptions;

public class VendedorException extends Exception {

	/**
	 * Id de la clase
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase
	 *
	 * @param message
	 */
	public VendedorException(String message) {
		super(message);
	}

}
