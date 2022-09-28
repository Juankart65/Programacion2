package libreria.model;

/**
 * Clase Libro que hereda de la clase TextoLiterario
 *
 * @author Juanes Cardona
 *
 */
public class Libro extends TextoLiterario {
	// Declaración de atributos
	private String isbn;
	private Autor autor;

	/**
	 * Constructor de la clase libro
	 *
	 * @param titulo
	 * @param editorial
	 * @param codigo
	 * @param estado
	 * @param unidadesDisponibles
	 * @param tipoFormato
	 * @param precio
	 * @param idioma
	 * @param numeroPaginas
	 * @param anio
	 * @param autor
	 * @param isbn
	 */
	public Libro(String titulo, String editorial, String codigo, String estado, int unidadesDisponibles,
			TipoFormato tipoFormato, double precio, String idioma, int numeroPaginas, int anio, Autor autor,
			String isbn) {
		super(titulo, editorial, codigo, estado, unidadesDisponibles, tipoFormato, precio, idioma, numeroPaginas, anio);
		this.autor = autor;
		this.isbn = isbn;
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
	 * get autor
	 *
	 * @return
	 */
	public Autor getAutor() {
		return autor;
	}

	/**
	 * set autor
	 *
	 * @param autor
	 */
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	/**
	 * Metodo que convierte en cadena los atributos
	 */
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", autor=" + autor + "]";
	}

}