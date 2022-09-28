package libreria.model;

/**
 * Clase DetalleCompra
 *
 * @author Hewlett Packard
 *
 */
public class DetalleCompra {
	// Declaracion de atributos
	private int cantidad;
	private double subTotal;
	private String codigo;
	private TextoLiterario textoLiterario;

	/**
	 * Constructor de la clase DetalleCompra
	 *
	 * @param cantidad
	 * @param subTotal
	 * @param codigo
	 */
	public DetalleCompra(int cantidad, double subTotal, String codigo) {
		super();
		this.cantidad = cantidad;
		this.subTotal = subTotal;
		this.codigo = codigo;
	}

	/**
	 * get texto literario
	 *
	 * @return
	 */
	public TextoLiterario getTextoLiterario() {
		return textoLiterario;
	}

	/**
	 * set texto literario
	 *
	 * @param textoLiterario
	 */
	public void setTextoLiterario(TextoLiterario textoLiterario) {
		this.textoLiterario = textoLiterario;
	}

	/**
	 * get cantidad
	 *
	 * @return
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * set cantidad
	 *
	 * @param cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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
	 * get subtotal
	 *
	 * @return
	 */
	public double getSubTotal() {
		return subTotal;
	}

	/**
	 * set subtotal
	 *
	 * @param subTotal
	 */
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * Metodo que convierte en cadena los atributos
	 */
	@Override
	public String toString() {
		return "DetalleCompra [cantidad=" + cantidad + ", subTotal=" + subTotal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	/**
	 * Metodo que compara detalleCompra
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleCompra other = (DetalleCompra) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	/**
	 * Metodo que verifica un libro por el titulo
	 *
	 * @param titulo
	 * @return
	 */
	public boolean verificarLibro(String titulo) {
		if (textoLiterario instanceof Libro) {
			if (textoLiterario.getTitulo().equals(titulo)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo que verifica la categoria de un libro
	 *
	 * @param categoria
	 * @return
	 */
	public boolean verificarCategoria(String categoria) {
		if (textoLiterario instanceof Revista) {
			if (((Revista) textoLiterario).getCategoria().equals(categoria)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo que verifica una cantidad determinada
	 *
	 * @param cantidad2
	 * @return
	 */
	public boolean verificarCantidad(int cantidad2) {
		boolean verificado = false;

		if (cantidad != 0) {
			if (cantidad == cantidad2) {
				verificado = true;
			}
		}
		return verificado;
	}

	/**
	 * Metodo que verifica el idioma
	 *
	 * @param idioma
	 * @return
	 */
	public boolean verificarIdioma(String idioma) {
		boolean verificado = false;

		if (textoLiterario != null) {
			if (textoLiterario.getIdioma().equals(idioma)) {
				verificado = true;
			}
		}
		return verificado;
	}

}