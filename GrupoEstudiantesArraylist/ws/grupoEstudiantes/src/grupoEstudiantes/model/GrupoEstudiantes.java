package grupoEstudiantes.model;

import java.util.ArrayList;

import grupoEstudiantes.exceptions.EstudianteException;

/**
 * Clase principal
 *
 * @author Juanes Cardona
 *
 */
public class GrupoEstudiantes {

	// Declaracion de atributos
	private ArrayList<Estudiante> listaEstudiantes;

	/**
	 * Constructor de la clase
	 *
	 * @param cantidadEstudiantes
	 */
	public GrupoEstudiantes(int cantidadEstudiantes) {
		listaEstudiantes = new ArrayList<Estudiante>(cantidadEstudiantes);
	}

	/**
	 * Get ListaEstudiantes
	 *
	 * @return
	 */
	public ArrayList<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

	/**
	 * Set ListaEstudiantes
	 *
	 * @param listaEstudiantes
	 */
	public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	// ---------------------------------------------------------------------------------

	// CRUD Estudiante

	/**
	 * Metodo que crea un estudiante y los agrega a la lista
	 *
	 * @param nuevoEstudiante
	 * @return
	 */
	public String crearEstudiante(Estudiante nuevoEstudiante) {
		String mensaje = "";
		int posicionDisponible = -1;
		boolean estudianteVerificado;

		try {
			estudianteVerificado = verificarEstudiante(nuevoEstudiante.getIdentificacion());
			posicionDisponible = ObtenerPosicionDisponibleEstudiantes();
			if (estudianteVerificado == false && posicionDisponible != -1) {
				listaEstudiantes.add(posicionDisponible, nuevoEstudiante);
				mensaje = "Estudiante creado";
			}
		} catch (EstudianteException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Metodo que obtiene la posicion disponible dentro del arraylist
	 *
	 * @return
	 * @throws EstudianteException
	 */
	private int ObtenerPosicionDisponibleEstudiantes() throws EstudianteException {
		int posicionDisponible = -1;
		for (int i = 0; i < listaEstudiantes.size() && posicionDisponible == -1; i++) {
			if (listaEstudiantes.get(i) == null) {
				posicionDisponible = i;
			}
		}
		if (posicionDisponible == -1) {
			throw new EstudianteException("No hay cupo");
		}
		return posicionDisponible;
	}

	/**
	 * Metodo que verifica si un estudiante ya existe en el arraylist
	 *
	 * @param identificacion
	 * @return
	 * @throws EstudianteException
	 */
	private boolean verificarEstudiante(String identificacion) throws EstudianteException {
		boolean verificado = false;
		boolean flag = false;

		for (Estudiante estudiante : listaEstudiantes) {
			if (estudiante != null && flag == false && estudiante.getIdentificacion().equals(identificacion)) {
				verificado = true;
				flag = true;
				throw new EstudianteException("El estudiante ya existe");
			}
		}
		return verificado;
	}

	/**
	 * Metodo que obtiene un estudiante por su identificacion
	 *
	 * @param identificacion
	 * @return
	 * @throws EstudianteException
	 */
	public Estudiante obtenerEstudiante(String identificacion) throws EstudianteException {
		Estudiante estudianteEncontrado = null;
		boolean flag = false;

		for (Estudiante estudiante : listaEstudiantes) {
			if (flag == false && estudiante != null && estudiante.getIdentificacion().equals(identificacion)) {
				estudianteEncontrado = estudiante;
				flag = true;
			}
		}
		if (estudianteEncontrado == null) {
			throw new EstudianteException("El estudiante no existe");
		}
		return estudianteEncontrado;
	}

	/**
	 * Metodo que elimina un estudiante
	 *
	 * @param identificacion
	 * @return
	 */
	public String eliminarEstudiante(String identificacion) {
		String mensaje = "";
		Estudiante estudianteEncontrado = null;
		boolean flag = false;

		try {
			estudianteEncontrado = obtenerEstudiante(identificacion);
			for (Estudiante estudiante : listaEstudiantes) {
				if (flag == false && estudiante != null && estudiante == estudianteEncontrado) {
					estudiante = null;
					mensaje = "Estudiante eliminado correctamente";
					flag = true;
				}
			}
		} catch (EstudianteException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Metodo que actualiza un estudiante
	 *
	 * @param nuevoEstudiante
	 * @return
	 * @throws EstudianteException
	 */
	public String actualizarEstudiante(Estudiante nuevoEstudiante) throws EstudianteException {
		String mensaje = "";
		Estudiante estudianteEncontrado = null;
		boolean flag = false;

		for (Estudiante estudiante : listaEstudiantes) {
			if (estudiante != null && flag == false
					&& estudiante.getIdentificacion().equals(nuevoEstudiante.getIdentificacion())) {
				estudianteEncontrado = estudiante;
				try {
					estudianteEncontrado.setNombre(nuevoEstudiante.getNombre());
					estudianteEncontrado.setIdentificacion(nuevoEstudiante.getIdentificacion());
					flag = true;
					mensaje = "Estudiante actualizado";
				} catch (Exception e) {
					throw new EstudianteException("No se actualizo el estudiante");
				}
			}
		}
		if (estudianteEncontrado == null) {
			throw new EstudianteException("El estudiante no existe");
		}
		return mensaje;
	}
}