package libreria.model;

import java.util.Arrays;

/**
 * Clase compra
 *
 * @author Juanes Cardona
 *
 */
public class Compra {
	// Declaracion de atributos
	private String codigo;
	private String fechaCompra;
	private double total;
	private double iva;
	private String medioPago;
	private double descuentos;
	private DetalleCompra[] detalleCompras = new DetalleCompra[2];

	/**
	 * Constructor de la clase compra
	 *
	 * @param codigo
	 * @param fechaCompra
	 * @param total
	 * @param iva
	 * @param medioPago
	 * @param descuentos
	 * @param detalleCompras
	 */
	public Compra(String codigo, String fechaCompra, double total, double iva, String medioPago, double descuentos,
			DetalleCompra detalleCompra1, DetalleCompra[] detalleCompras) {
		super();
		this.codigo = codigo;
		this.fechaCompra = fechaCompra;
		this.total = total;
		this.iva = iva;
		this.medioPago = medioPago;
		this.descuentos = descuentos;
		this.detalleCompras = detalleCompras;
	}

	/**
	 * get codigo
	 *
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * set codigo
	 *
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * get fecha compra
	 *
	 * @return
	 */
	public String getFechaCompra() {
		return fechaCompra;
	}

	/**
	 * set fecha compra
	 *
	 * @param fechaCompra
	 */
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	/**
	 * get total
	 *
	 * @return
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * set total
	 *
	 * @param total
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * get iva
	 *
	 * @return
	 */
	public double getIva() {
		return iva;
	}

	/**
	 * set iva
	 *
	 * @param iva
	 */
	public void setIva(double iva) {
		this.iva = iva;
	}

	/**
	 * get medio pago
	 *
	 * @return
	 */
	public String getMedioPago() {
		return medioPago;
	}

	/**
	 * set medio pago
	 *
	 * @param medioPago
	 */
	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}

	/**
	 * get descuentos
	 *
	 * @return
	 */
	public double getDescuentos() {
		return descuentos;
	}

	/**
	 * set descuentos
	 *
	 * @param descuentos
	 */
	public void setDescuentos(double descuentos) {
		this.descuentos = descuentos;
	}

	/**
	 * get detalle compras
	 *
	 * @return
	 */
	public DetalleCompra[] getDetalleCompras() {
		return detalleCompras;
	}

	/**
	 * set detalle compras
	 *
	 * @param detalleCompras
	 */
	public void setDetalleCompras(DetalleCompra[] detalleCompras) {
		this.detalleCompras = detalleCompras;
	}

	/**
	 * Metodo que convierte en cadena los atributos
	 */
	@Override
	public String toString() {
		return "Compra [codigo=" + codigo + ", fechaCompra=" + fechaCompra + ", total=" + total + ", iva=" + iva
				+ ", medioPago=" + medioPago + ", descuentos=" + descuentos + ", detalleCompras="
				+ Arrays.toString(detalleCompras) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	/**
	 * Metodo que compara detalles compras
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	/**
	 * Metodo que verifica la fecha de una compra
	 *
	 * @param fecha
	 * @return
	 */
	public boolean verificarFecha(String fecha) {
		if (this.fechaCompra.equals(fecha)) {
			return true;
		}
		return false;
	}

	/**
	 * Metodo que verifica la compra de un libro segun su titulo
	 *
	 * @param titulo
	 * @return
	 */
	public boolean verificarCompraLibro(String titulo) {
		for (int i = 0; i < detalleCompras.length; i++) {
			if (detalleCompras[i] != null) {
				if (detalleCompras[i].verificarLibro(titulo)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 *
	 * @param categoria
	 * @return
	 */
	public boolean verificarCategoria(String categoria) {
		for (int i = 0; i < detalleCompras.length; i++) {
			if (detalleCompras[i] != null) {
				if (detalleCompras[i].verificarCategoria(categoria)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Metodo que verifica la cantidad e idioma
	 *
	 * @param cantidad
	 * @param idioma
	 * @return
	 */
	public boolean verificarCantidadIdioma(int cantidad, String idioma) {
		boolean verificado = false;

		for (int i = 0; i < detalleCompras.length; i++) {
			if (detalleCompras[i] != null) {
				if (detalleCompras[i].verificarCantidad(cantidad) && detalleCompras[i].verificarIdioma(idioma)) {
					verificado = true;
				}
			}
		}
		return verificado;
	}

}