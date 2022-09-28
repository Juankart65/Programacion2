package libreria.model;

/**
 * Clase TextoLiterario
 *
 * @author Juanes Cardona
 *
 */
public abstract class TextoLiterario {
	// Declaracion de atributos
	private String titulo;
	private String editorial;
	private String codigo;
	private String estado;
	private int unidadesDisponibles;
	private TipoFormato tipoFormato;
	private double precio;
	private String idioma;
	private int numeroPaginas;
	private int anio;
	private String fechaPublicacion;

	/**
	 * Constructor de la clase TextoLiterario
	 *
	 * @param titulo
	 * @param editorial
	 * @param estado
	 * @param unidadesDisponibles
	 * @param tipoFormato
	 * @param precio
	 * @param idioma
	 * @param numeroPaginas
	 * @param anio
	 */

	public TextoLiterario(String titulo, String editorial, String codigo, String estado, int unidadesDisponibles,
			TipoFormato tipoFormato, double precio, String idioma, int numeroPaginas, int anio) {
		super();
		this.titulo = titulo;
		this.editorial = editorial;
		this.codigo = codigo;
		this.estado = estado;
		this.unidadesDisponibles = unidadesDisponibles;
		this.tipoFormato = tipoFormato;
		this.precio = precio;
		this.idioma = idioma;
		this.numeroPaginas = numeroPaginas;
		this.anio = anio;
	}

	/**
	 * get titulo
	 *
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * set titulo
	 *
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * get editorial
	 *
	 * @return
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * set editorial
	 *
	 * @param editorial
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * get estado
	 *
	 * @return
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * set estado
	 *
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * get unidades disponibles
	 *
	 * @return
	 */
	public int getUnidadesDisponibles() {
		return unidadesDisponibles;
	}

	/**
	 * set unidades disponibles
	 *
	 * @param unidadesDisponibles
	 */
	public void setUnidadesDisponibles(int unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
	}

	/**
	 * set tipo formato
	 *
	 * @return
	 */
	public TipoFormato getTipoFormato() {
		return tipoFormato;
	}

	/**
	 * set tipo formato
	 *
	 * @param tipoFormato
	 */
	public void setTipoFormato(TipoFormato tipoFormato) {
		this.tipoFormato = tipoFormato;
	}

	/**
	 * get fecha publicacion
	 *
	 * @return
	 */
	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	/**
	 * set fecha publicacion
	 *
	 * @param fechaPublicacion
	 */
	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
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
	 * get precio
	 *
	 * @return
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * set precio
	 *
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * get idioma
	 *
	 * @return
	 */
	public String getIdioma() {
		return idioma;
	}

	/**
	 * set idioma
	 *
	 * @param idioma
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	/**
	 * get numero paginas
	 *
	 * @return
	 */
	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * set numero paginas
	 *
	 * @param numeroPaginas
	 */
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	/**
	 * get anio
	 *
	 * @return
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * set anio
	 *
	 * @param anio
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}

	/**
	 * Metodo que une en una cadena los atributos
	 */
	@Override
	public String toString() {
		return "TextoLiterario [titulo=" + titulo + ", editorial=" + editorial + ", estado=" + estado
				+ ", unidadesDisponibles=" + unidadesDisponibles + ", tipoFormato=" + tipoFormato + ", precio=" + precio
				+ ", idioma=" + idioma + ", numeroPaginas=" + numeroPaginas + ", anio=" + anio + "]";
	}

	/**
	 *
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	/**
	 * Metodo que compara textoLiterario
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextoLiterario other = (TextoLiterario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}