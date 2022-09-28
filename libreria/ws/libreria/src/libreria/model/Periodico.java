package libreria.model;

/**
 * Clase periodico
 *
 * @author Juanes Cardona
 *
 */
public class Periodico extends TextoLiterario {
	// Declaracion de atributos
	private String ciudad;

	/**
	 * Constructor de la clase periodico
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
	 * @param ciudad
	 */
	public Periodico(String titulo, String editorial, String codigo, String estado, int unidadesDisponibles,
			TipoFormato tipoFormato, int precio, String idioma, int numeroPaginas, int anio, String ciudad) {
		super(titulo, editorial, estado, codigo, unidadesDisponibles, tipoFormato, precio, idioma, numeroPaginas, anio);
		this.ciudad = ciudad;
	}

	/**
	 * get ciudad
	 *
	 * @return
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * set ciudad
	 *
	 * @param ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * Metodo que convierte en cadena los atributos
	 */
	@Override
	public String toString() {
		return "Periodico [ciudad=" + ciudad + "]";
	}

}