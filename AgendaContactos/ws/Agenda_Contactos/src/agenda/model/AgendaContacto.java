package agenda.model;

import java.util.ArrayList;

import agenda.exceptions.ContactoExcepciones;
import agenda.exceptions.GrupoExcepciones;
import agenda.exceptions.ReunionExcepciones;

/**
 * Clase principal que representa una agenda de contactos
 *
 * @author Juanes Cardona
 *
 */
public class AgendaContacto {

	// Declaracion de atributos
	private ArrayList<Contacto> listaContactos = new ArrayList<Contacto>();
	private ArrayList<Grupo> listaGrupos = new ArrayList<Grupo>();
	private ArrayList<Reunion> listaReuniones = new ArrayList<Reunion>();
	private Grupo grupo;
	private Reunion reunion;

	// -------------------------------------------------------------------------------------------------

	// Getters y Setters

	/**
	 * Constructor de la clase principal
	 *
	 * @param listaContactos
	 * @param listaGrupos
	 * @param listaReuniones
	 */
	public AgendaContacto(ArrayList<Contacto> listaContactos, ArrayList<Grupo> listaGrupos,
			ArrayList<Reunion> listaReuniones) {
		super();
		this.listaContactos = listaContactos;
		this.listaGrupos = listaGrupos;
		this.listaReuniones = listaReuniones;
	}

	/**
	 * get listaContacto
	 *
	 * @return
	 */
	public ArrayList<Contacto> getListaContactos() {
		return listaContactos;
	}

	/**
	 * set listaContactos
	 *
	 * @param listaContactos
	 */
	public void setListaContactos(ArrayList<Contacto> listaContactos) {
		this.listaContactos = listaContactos;
	}

	/**
	 * get listaGrupos
	 *
	 * @return
	 */
	public ArrayList<Grupo> getListaGrupos() {
		return listaGrupos;
	}

	/**
	 * set listaGrupos
	 *
	 * @param listaGrupos
	 */
	public void setListaGrupos(ArrayList<Grupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	/**
	 * get listaReuniones
	 *
	 * @return
	 */
	public ArrayList<Reunion> getListaReuniones() {
		return listaReuniones;
	}

	/**
	 * set listaReuniones
	 *
	 * @param listaReuniones
	 */
	public void setListaReuniones(ArrayList<Reunion> listaReuniones) {
		this.listaReuniones = listaReuniones;
	}

	// ---------------------------------------------------------------------------------------------------

	// CRUD Contacto

	/**
	 * Este metodo crea y agrega un contacto a la agenda
	 *
	 * @param newContacto
	 * @return
	 */
	public String aniadirContacto(Contacto newContacto) {
		String mensaje = "";
		boolean contactoVerificado;
		try {
			contactoVerificado = verificarContacto(newContacto.getNombre(), newContacto.getTelefono());

			if (contactoVerificado == false) {
				listaContactos.add(newContacto);
				mensaje = "Contacto agregado";
			}
		} catch (ContactoExcepciones e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Este metodo verifica si ya existe un contacto
	 *
	 * @param nombre
	 * @param telefono
	 * @return
	 * @throws ContactoExcepciones
	 */
	private boolean verificarContacto(String nombre, String telefono) throws ContactoExcepciones {
		boolean verificado = false;

		for (Contacto contacto : listaContactos) {
			if (contacto != null && !verificado && contacto.getNombre().equals(nombre)
					&& contacto.getTelefono().equals(telefono)) {
				verificado = true;
				throw new ContactoExcepciones("El contacto ya existe");
			}
		}
		return verificado;
	}

	/**
	 * Metodo que obtiene un contacto de acuerdo al nombre
	 *
	 * @param nombre
	 * @return
	 * @throws ContactoExcepciones
	 */
	public Contacto obtenerContacto(String nombre) throws ContactoExcepciones {
		Contacto contactoEncontrado = null;

		for (Contacto contacto : listaContactos) {
			if (contacto != null && contactoEncontrado == null && contacto.getTelefono().equals(nombre)) {
				contactoEncontrado = contacto;
			}
		}
		if (contactoEncontrado == null) {
			throw new ContactoExcepciones("El contacto no existe");
		}
		return contactoEncontrado;
	}

	/**
	 * Este metodo actualiza los atributos de un contacto
	 *
	 * @param newContacto
	 * @return
	 */
	public String actualizarContacto(Contacto newContacto) {
		String mensaje = "";
		Contacto contactoEncontrado = null;

		for (Contacto contacto : listaContactos) {
			if (contactoEncontrado == null && contacto != null
					&& contacto.getNombre().equals(newContacto.getNombre())) {
				contactoEncontrado = contacto;
				contactoEncontrado.setNombre(newContacto.getNombre());
				contactoEncontrado.setTelefono(newContacto.getTelefono());
				contactoEncontrado.setAlias(newContacto.getAlias());
				contactoEncontrado.setEmail(newContacto.getEmail());
				contactoEncontrado.setDireccion(newContacto.getDireccion());
				mensaje = "Contacto actualizado";
			}
		}
		return mensaje;
	}

	/**
	 * Este metodo elimina un contacto de acuerdo al numero de telefono
	 *
	 * @param telefono
	 * @return
	 */
	public String eliminarContacto(String nombre) {
		String mensaje = "";
		Contacto contactoEliminar = null;
		boolean flag = false;

		try {
			contactoEliminar = obtenerContacto(nombre);
			for (Contacto contacto : listaContactos) {
				if (!flag && contacto != null && contacto == contactoEliminar) {
					contacto = null;
					mensaje = "Contacto eliminado correctamente";
				}
			}
		} catch (ContactoExcepciones e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Este metodo muestra la informacion de todos los contactos en la agenda
	 *
	 * @return
	 */
	public String enlistarContactos() {
		String mensaje = "";

		for (Contacto contacto : listaContactos) {
			if (contacto != null) {
				mensaje = contacto.toString();
			}
		}
		return mensaje;
	}

	// ----------------------------------------------------------------------------------------------------------------------

	// CRUD Grupo

	/**
	 * Este metodo crea y agrega el grupo a la agenda
	 *
	 * @param newGrupo
	 * @return
	 */
	public String crearGrupo(Grupo newGrupo) {
		String mensaje = "";
		boolean grupoVerificado;
		try {
			grupoVerificado = verificarGrupo(newGrupo.getId());

			if (!grupoVerificado) {
				listaGrupos.add(newGrupo);
				mensaje = "Grupo creado y agregado";
			}
		} catch (GrupoExcepciones e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Este metodo verifica si ya existe un grupo
	 *
	 * @param nombre
	 * @param categoria
	 * @return
	 * @throws GrupoExcepciones
	 */
	private boolean verificarGrupo(String id) throws GrupoExcepciones {
		boolean verificado = false;

		for (Grupo grupo : listaGrupos) {
			if (grupo != null && !verificado && grupo.getId().equals(id)) {
				verificado = true;
				throw new GrupoExcepciones("El grupo ya existe");
			}
		}
		return verificado;
	}

	/**
	 * Este metodo obtiene un grupo de acuerdo al id
	 *
	 * @param id
	 * @return
	 * @throws GrupoExcepciones
	 */
	public Grupo obtenerGrupo(String id) throws GrupoExcepciones {
		Grupo grupoEncontrado = null;

		for (Grupo grupo : listaGrupos) {
			if (grupoEncontrado == null && grupo != null && grupo.getId().equals(id)) {
				grupoEncontrado = grupo;
			}
		}
		if (grupoEncontrado == null) {
			throw new GrupoExcepciones("El grupo no existe");
		}
		return grupoEncontrado;
	}

	/**
	 * Este metodo actualiza los atributos de un grupo
	 *
	 * @param newGrupo
	 * @return
	 */
	public String actualizarGrupo(Grupo newGrupo) {
		String mensaje = "";
		Grupo grupoEncontrado = null;

		for (Grupo grupo : listaGrupos) {
			if (grupoEncontrado == null && grupo != null && grupo.getId().equals(newGrupo.getId())) {
				grupoEncontrado = grupo;
				grupoEncontrado.setNombre(newGrupo.getNombre());
				grupoEncontrado.setId(newGrupo.getId());
				grupoEncontrado.setCategoria(newGrupo.getCategoria());
				mensaje = "Grupo actualizado";
			}
		}
		return mensaje;
	}

	/**
	 * Este metodo elimina un contacto de acuerdo al id
	 *
	 * @param id
	 * @return
	 */
	public String eliminarGrupo(String id) {
		String mensaje = "";
		Grupo grupoEliminar = null;
		boolean flag = false;

		try {
			grupoEliminar = obtenerGrupo(id);
			for (Grupo grupo : listaGrupos) {
				if (!flag && grupo != null && grupo == grupoEliminar) {
					grupo = null;
					mensaje = "Grupo eliminado correctamente";
				}
			}
		} catch (GrupoExcepciones e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Este metodo agrega los contactos que perteneceran al grupo
	 *
	 * @param contacto1
	 * @param contacto2
	 * @param contacto3
	 * @param contacto4
	 * @param contacto5
	 * @return
	 */
	public String agregarContactosGrupo(String contacto1, String contacto2, String contacto3, String contacto4,
			String contacto5) {
		String mensaje = "";
		boolean cupoContacto = false;
		String[] contactosAgregar = { contacto1, contacto2, contacto3, contacto4, contacto5 };

		try {
			cupoContacto = grupo.verificarCupo();
			if (cupoContacto) {
				for (String nombre : contactosAgregar) {
					if (nombre != null) {
						Contacto contacto = obtenerContacto(nombre);
						grupo.agregarContactos(contacto);
					}
				}
			}
		} catch (GrupoExcepciones | ContactoExcepciones e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	// -------------------------------------------------------------------------------------------------

	// CRUD Reunion

	/**
	 * Este metodo crea y agrega una reunion a la agenda
	 *
	 * @param newReunion
	 * @return
	 */
	public String crearReunion(Reunion newReunion) {
		String mensaje = "";
		boolean reunionVerificada;
		try {
			reunionVerificada = verificarReunion(newReunion.getId());
			if (!reunionVerificada) {
				listaReuniones.add(newReunion);
				mensaje = "Reunion creada y agregada";
			}
		} catch (ReunionExcepciones e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Este metodo verifica si ya existe una reunion
	 *
	 * @param id
	 * @return
	 * @throws ReunionExcepciones
	 */
	private boolean verificarReunion(String id) throws ReunionExcepciones {
		boolean verificada = false;

		for (Reunion reunion : listaReuniones) {
			if (reunion != null && !verificada && reunion.getId().equals(id)) {
				verificada = true;
				throw new ReunionExcepciones("La reunion ya existe");
			}
		}
		return verificada;
	}

	/**
	 * Este metodo obtiene una reunion de acuerdo al id
	 *
	 * @param id
	 * @return
	 * @throws ReunionExcepciones
	 */
	public Reunion obtenerReunion(String id) throws ReunionExcepciones {
		Reunion reunionEncontrada = null;

		for (Reunion reunion : listaReuniones) {
			if (reunionEncontrada == null && reunion != null && reunion.getId().equals(id)) {
				reunionEncontrada = reunion;
			}
		}
		if (reunionEncontrada == null) {
			throw new ReunionExcepciones("La reunion no existe");
		}
		return reunionEncontrada;
	}

	/**
	 * Este metodo actualiza los atributos de un grupo
	 *
	 * @param newReunion
	 * @return
	 */
	public String actualizarReunion(Reunion newReunion) {
		String mensaje = "";
		Reunion reunionEncontrada = null;

		for (Reunion reunion : listaReuniones) {
			if (reunionEncontrada == null && reunion != null && reunion.getId().equals(newReunion.getId())) {
				reunionEncontrada = reunion;
				reunionEncontrada.setDescripcion(newReunion.getDescripcion());
				reunionEncontrada.setId(newReunion.getId());
				reunionEncontrada.setFecha(newReunion.getFecha());
				reunionEncontrada.setHora(newReunion.getHora());
				mensaje = "Reunion actualizada";
			}
		}
		return mensaje;
	}

	/**
	 * Este metodo elimina una reunion de acuerdo a su id
	 *
	 * @param id
	 * @return
	 */
	public String eliminarReunion(String id) {
		String mensaje = "";
		Reunion reunionEliminar = null;
		boolean flag = false;

		try {
			reunionEliminar = obtenerReunion(id);
			for (Reunion reunion : listaReuniones) {
				if (!flag && reunion != null && reunion == reunionEliminar) {
					reunion = null;
					mensaje = "Reunion eliminada correctamente";
				}
			}
		} catch (ReunionExcepciones e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Este metodo agrega los contactos que perteneceran a la reunion
	 *
	 * @param contacto1
	 * @param contacto2
	 * @param contacto3
	 * @param contacto4
	 * @param contacto5
	 * @return
	 */
	public String agregarContactosReunion(String contacto1, String contacto2, String contacto3, String contacto4,
			String contacto5) {
		String mensaje = "";
		boolean cupoContacto = false;
		String[] contactosAgregar = { contacto1, contacto2, contacto3, contacto4, contacto5 };

		try {
			cupoContacto = reunion.verificarCupo();
			if (cupoContacto) {
				for (String nombre : contactosAgregar) {
					if (nombre != null) {
						Contacto contacto = obtenerContacto(nombre);
						reunion.agregarContactos(contacto);
					}
				}
			}
		} catch (ReunionExcepciones | ContactoExcepciones e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	// ---------------------------Taller de agenda seguimiento en clase-----------------------------

	// 1 - Imprimir los contactos de las posiciones impares

	/**
	 * Este metodo imprime los contactos que estan en una posicion impar
	 *
	 * @return
	 */
	public String imprimirContactosImpares() {
		String mensaje = "";

		for (int i = 0; i < listaContactos.size(); i++) {
			if (i % 2 != 0) {
				mensaje += listaContactos.get(i).toString();
			}
		}
		return mensaje;
	}

	// 2 - Obtener cual es la edad que más se repite

	/**
	 * Este metodo devuelve la edad que más se repite en los contactos
	 *
	 * @return
	 */
	public int obtenerEdadMasRepite() {
		int edadMasRepite = 0;
		int cont = 0;

		for (Contacto contacto : listaContactos) {
			int cont2 = 0;

			for (Contacto contacto2 : listaContactos) {
				if (contacto != null && contacto2 != null && contacto.getEdad() == contacto2.getEdad()) {
					cont2 += 1;
				}
			}
			if (cont2 > cont) {
				edadMasRepite = contacto.getEdad();
				cont = cont2;
			}
			cont2 = 0;
		}
		return edadMasRepite;
	}

	// 3 - Obtener el promedio de edades de los contactos

	/**
	 * Este metodo obtiene el promedio de las edades de los contactos
	 *
	 * @return
	 */
	public double obtenerPromedioEdad() {
		double promedio = 0.0;
		int suma = 0;
		for (Contacto contacto : listaContactos) {
			if (contacto != null) {
				suma += contacto.getEdad();
			}
		}
		promedio = suma / listaContactos.size();
		return promedio;
	}

	// 4 - Obtener los contactos con una edad menor a 18

	/**
	 * Este metodo obtiene los contactos cuya edad es menor a 18
	 *
	 * @return
	 */
	public String obtenerContactosEdadMenor() {
		String mensaje = "";

		for (Contacto contacto : listaContactos) {
			if (contacto != null && contacto.getEdad() < 18) {
				mensaje += contacto.toString();
			}
		}
		return mensaje;
	}

	// 5 - Calcular la desviacion estandar de las edades

	/**
	 * Este metodo calcula la desviacion estandar de las edades
	 *
	 * @return
	 */
	public double calcularDesviacionEstandar() {
		double media = obtenerPromedioEdad();
		double desviacionEstandar = 0.0;
		double sq = 0.0;
		double residuo = 0.0;
		for (Contacto contacto : listaContactos) {
			desviacionEstandar += Math.pow(contacto.getEdad() - media, 2);
		}
		sq = desviacionEstandar / listaContactos.size();
		residuo = Math.sqrt(sq);
		return residuo;
	}
}
