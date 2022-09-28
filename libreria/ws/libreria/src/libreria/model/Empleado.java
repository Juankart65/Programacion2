package libreria.model;

/**
 * Clase empleado
 *
 * @author Juanes cardona
 *
 */
public abstract class Empleado {
	// Declaracion de atributos
	private String nombre;
	private String correo;
	private String cedula;
	private String direccion;
	private double salario;

	/**
	 * Constructor de la clase Empleado
	 *
	 * @param nombre
	 * @param correo
	 * @param cedula
	 * @param direccion
	 * @param salario
	 */
	public Empleado(String nombre, String correo, String cedula, String direccion, double salario) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.cedula = cedula;
		this.direccion = direccion;
		this.salario = salario;
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
	 * get correo
	 *
	 * @return
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * set correo
	 *
	 * @param correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * get cedula
	 *
	 * @return
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * set cedula
	 *
	 * @param cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * get direccion
	 *
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * set direccion
	 *
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * get salario
	 *
	 * @return
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * set salario
	 *
	 * @param salario
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * Metodo que convierte en cadena los atributos
	 */
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", correo=" + correo + ", cedula=" + cedula + ", direccion=" + direccion
				+ ", salario=" + salario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		return result;
	}

	/**
	 * Metodo que compara empleado
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}

}