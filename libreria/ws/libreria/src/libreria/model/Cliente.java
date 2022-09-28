package libreria.model;

import java.util.Arrays;

/**
 * Clase cliente
 *
 * @author Juanes Cardona
 *
 */
public class Cliente {
	// Declaracion de atributos
	private String nombre;
	private String telefono;
	private String cedula;
	private String correo;
	private Compra[] compras = new Compra[2];

	/**
	 * Constructor de la clase cliente
	 *
	 * @param nombre
	 * @param telefono
	 * @param cedula
	 * @param correo
	 */
	public Cliente(String nombre, String telefono, String cedula, String correo) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.cedula = cedula;
		this.correo = correo;
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
	 * get telefono
	 *
	 * @return
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * set telefono
	 *
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
	 * get compras
	 *
	 * @return
	 */
	public Compra[] getCompras() {
		return compras;
	}

	/**
	 * set compras
	 *
	 * @param compras
	 */
	public void setCompras(Compra[] compras) {
		this.compras = compras;
	}

	/**
	 * Metodo que convierte en una cadena los atributos
	 */
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", telefono=" + telefono + ", cedula=" + cedula + ", correo=" + correo
				+ ", compras=" + Arrays.toString(compras) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		return result;
	}

	/**
	 * Metodo que compara clientes
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}

	/**
	 * Metodo que verifica la fecha de una compra
	 *
	 * @param fecha
	 * @return
	 */
	public boolean verificarFechaCompras(String fecha) {
		for (int i = 0; i < compras.length; i++) {
			if (compras[i] != null) {
				if (compras[i].verificarFecha(fecha)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Metodo que verifica si el cliente tiene nombre palindrome
	 *
	 * @param nombre
	 * @return
	 */
	public boolean verificarPalindromo(String nombre) {
		boolean verificado = false;
		boolean error = false;
		int ini, ult;
		ini = 0;
		ult = nombre.length() - 1;

		while (ini < ult && !error) {
			if (nombre.charAt(ini) == nombre.charAt(ult)) {
				ini++;
				ult--;
				verificado = true;
			} else {
				error = true;
			}
		}
		return verificado;
	}

}