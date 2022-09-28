package libreria.model;

import java.util.Arrays;

/**
 * Clase vendedor
 *
 * @author Juanes Cardona
 *
 */
public class Vendedor extends Empleado {
	// Declaracion de atributos
	private int numeroVentas;
	private Compra[] compras = new Compra[2];

	/**
	 * Constructor de la clase vendedor
	 *
	 * @param nombre
	 * @param correo
	 * @param cedula
	 * @param direccion
	 * @param salario
	 * @param numeroVentas
	 */
	public Vendedor(String nombre, String correo, String cedula, String direccion, int salario, int numeroVentas) {
		super(nombre, correo, cedula, direccion, salario);
		this.numeroVentas = numeroVentas;
	}

	/**
	 * get numero ventanas
	 *
	 * @return
	 */
	public int getNumeroVentas() {
		return numeroVentas;
	}

	/**
	 * set numero ventas
	 *
	 * @param numeroVentas
	 */
	public void setNumeroVentas(int numeroVentas) {
		this.numeroVentas = numeroVentas;
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
	 * Metodo que convierte en cadena los atributos
	 */
	@Override
	public String toString() {
		return "Vendedor [numeroVentas=" + numeroVentas + ", compras=" + Arrays.toString(compras) + "]";
	}

	public boolean verificarVentaLibro(String titulo) {
		boolean verificado = false;

		for (int i = 0; i < compras.length; i++) {
			if (compras[i] != null) {
				if (compras[i].verificarCompraLibro(titulo)) {
					return true;
				}
			}
		}
		return verificado;
	}

}