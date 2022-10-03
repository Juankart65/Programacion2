package grupoEstudiantes.model;

/**
 * Clase que representa un estudiante
 *
 * @author Juanes Cardona
 *
 */
public class Estudiante {

	// Declaracion de atributos
	private String nombre;
	private String identificacion;

	/**
	 * Constructor de la clase Estudiante
	 *
	 * @param nombre
	 * @param identificacion
	 */
	public Estudiante(String nombre, String identificacion) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
	}

	/**
	 * Get nombre
	 *
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Set nombre
	 *
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Get identificacion
	 *
	 * @return
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * Set identificacion
	 *
	 * @param identificacion
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificacion == null) ? 0 : identificacion.hashCode());
		return result;
	}

	/**
	 * Metodo que compara estudiantes
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		if (identificacion == null) {
			if (other.identificacion != null)
				return false;
		} else if (!identificacion.equals(other.identificacion))
			return false;
		return true;
	}

	/**
	 * Metodo que convierte a cadena los atributos
	 */
	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", identificacion=" + identificacion + "]";
	}

}