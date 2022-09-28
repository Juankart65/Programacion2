package libreria.model;

/**
 * Clase revista
 *
 * @author Juanes Cardona
 *
 */
public class Revista extends TextoLiterario {
	// Declaracion de atributos
	private String isbn;
	private String categoria;

	/**
	 * Constructor de la clase revista
	 *
	 * @param titulo
	 * @param editorial
	 * @param codigo
	 * @param estado
	 * @param unidadesDisponibles
	 * @param formato
	 * @param precio
	 * @param idioma
	 * @param numeroPaginas
	 * @param anio
	 * @param categoria
	 * @param isbn
	 */
	public Revista(String titulo, String editorial, String codigo, String estado, int unidadesDisponibles,
			TipoFormato formato, double precio, String idioma, int numeroPaginas, int anio, String categoria,
			String isbn) {
		super(titulo, editorial, estado, codigo, unidadesDisponibles, formato, precio, idioma, numeroPaginas, anio);
		this.categoria = categoria;
		this.isbn = isbn;
	}

	/**
	 * get categoria
	 *
	 * @return
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * set categoria
	 *
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * get isbn
	 *
	 * @return
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * set isbn
	 *
	 * @param isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Metodo que convierte en cadena los atributos
	 */
	@Override
	public String toString() {
		return "Revista [isbn=" + isbn + ", categoria=" + categoria + "]";
	}

	/**
	 * Metodo que compara revista
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revista other = (Revista) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

}