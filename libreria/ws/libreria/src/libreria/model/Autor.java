package libreria.model;

/**
 * Clase autor
 *
 * @author Juanes Cardona
 *
 */
public class Autor {
	// Declaracion de atributos
	private String nombre;
	private String apellidos;
	private String identificacion;

	/**
	 * Constructor de la clase autor
	 *
	 * @param nombre
	 * @param apellidos
	 * @param identificacion
	 */
	public Autor(String nombre, String apellidos, String identificacion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.identificacion = identificacion;
	}

	/**
	 * get nombre
	 *
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * set nombre
	 *
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * get identificacion
	 *
	 * @return
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * set identificacion
	 *
	 * @param identificacion
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * get apellidos
	 *
	 * @return
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * set apellidos
	 *
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Convierte en una cadena los atributos
	 */
	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

	/**
	 * Metodo que compara dos autores
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (identificacion == null) {
			if (other.identificacion != null)
				return false;
		} else if (!identificacion.equals(other.identificacion))
			return false;
		return true;
	}

}