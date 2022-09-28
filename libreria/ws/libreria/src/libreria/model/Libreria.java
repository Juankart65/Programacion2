package libreria.model;

import libreria.exceptions.AdministradorException;
import libreria.exceptions.ClienteException;
import libreria.exceptions.EmpleadoException;
import libreria.exceptions.LibroException;
import libreria.exceptions.PeriodicoException;
import libreria.exceptions.RevistaException;
import libreria.exceptions.TextoLiterarioException;
import libreria.exceptions.VendedorException;

/**
 * Clase libreria
 *
 * @author Juanes Cardona
 *
 */
public class Libreria {
	// DECLARACION DE ATRIBUTOS
	private String nombre;
	private TextoLiterario[] listaTextosLiterarios;
	private Empleado[] listaEmpleados;
	private Cliente[] listaClientes;
	private Compra[] listaCompras;

	// --------------------------------------------------------------------

	/**
	 * constructor de la clase libreria
	 *
	 * @param nombre
	 */
	public Libreria(String nombre, int cantidadTextosLiterarios, int cantidadEmpleados, int cantidadClientes,
			int cantidadCompras) {
		super();
		this.nombre = nombre;
		this.listaTextosLiterarios = new TextoLiterario[cantidadTextosLiterarios];
		this.listaClientes = new Cliente[cantidadClientes];
		this.listaEmpleados = new Empleado[cantidadEmpleados];
		this.listaCompras = new Compra[cantidadCompras];
	}

	/**
	 * get ListaTextosLiterarios
	 *
	 * @return
	 */
	public TextoLiterario[] getListaTextosLiterarios() {
		return listaTextosLiterarios;
	}

	/**
	 * set ListaTextosLiterarios
	 *
	 * @param listaTextosLiterarios
	 */
	public void setListaTextosLiterarios(TextoLiterario[] listaTextosLiterarios) {
		this.listaTextosLiterarios = listaTextosLiterarios;
	}

	/**
	 * get ListaEmpleados
	 *
	 * @return
	 */
	public Empleado[] getListaEmpleados() {
		return listaEmpleados;
	}

	/**
	 * set ListaEmpleados
	 *
	 * @param listaEmpleados
	 */
	public void setListaEmpleados(Empleado[] listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	/**
	 * get ListaClientes
	 *
	 * @return
	 */
	public Cliente[] getListaClientes() {
		return listaClientes;
	}

	/**
	 * set ListaClientes
	 *
	 * @param listaClientes
	 */
	public void setListaClientes(Cliente[] listaClientes) {
		this.listaClientes = listaClientes;
	}

	/**
	 * get ListaCompras
	 *
	 * @return
	 */
	public Compra[] getListaCompras() {
		return listaCompras;
	}

	/**
	 * set ListaCompras
	 *
	 * @param listaCompras
	 */
	public void setListaCompras(Compra[] listaCompras) {
		this.listaCompras = listaCompras;
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
	 * set Nombre
	 *
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que convierte en una cadenas
	 */
	@Override
	public String toString() {
		return "Libreria [nombre=" + nombre + "]";
	}

	// -------------------------------------------------------

	// CRUD Libro

	/**
	 * Metodo que crea el libro
	 *
	 * @param nuevoLibro
	 * @return
	 * @throws TextoLiterarioException
	 */
	public String crearLibro(Libro nuevoLibro) {
		String mensaje = "";
		int posicionDisponible = -1;
		boolean libroVerificado;

		try {
			libroVerificado = verificarLibro(nuevoLibro.getCodigo());
			posicionDisponible = obtenerPosicionDisponibleTextoLiterario();
			if (libroVerificado == false && posicionDisponible != -1) {
				listaTextosLiterarios[posicionDisponible] = nuevoLibro;
				mensaje = "Libro Creado";
			}

		} catch (LibroException | TextoLiterarioException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Este metodo utiliza el codigo ingresado por el usuario y verifica si el
	 * libro ya existe
	 *
	 * @param codigo
	 * @return
	 */
	private boolean verificarLibro(String codigo) throws LibroException {
		boolean verificado = false;
		boolean flag = false;

		for (TextoLiterario textoLiterario : listaTextosLiterarios) {
			if (textoLiterario instanceof Libro && flag == false && textoLiterario.getCodigo().equals(codigo)) {
				verificado = true;
				flag = true;
				throw new LibroException("Libro ya existe");
			}
		}
		return verificado;
	}

	/**
	 * Metodo que actualiza los atributos de un libro dado
	 *
	 * @param nuevoLibro
	 * @return
	 * @throws LibroException
	 */
	public String actualizarLibro(Libro nuevoLibro) throws LibroException {
		String mensaje = "";
		Libro libroEncontrado = null;
		boolean flag = false;

		for (TextoLiterario textoLiterario : listaTextosLiterarios) {
			if (textoLiterario instanceof Libro && flag == false
					&& textoLiterario.getCodigo().equals(nuevoLibro.getCodigo())) {
				libroEncontrado = (Libro) textoLiterario;
				try {
					libroEncontrado.setIsbn(nuevoLibro.getIsbn());
					libroEncontrado.setAutor(nuevoLibro.getAutor());
					libroEncontrado.setTitulo(nuevoLibro.getTitulo());
					libroEncontrado.setEditorial(nuevoLibro.getEditorial());
					libroEncontrado.setEstado(nuevoLibro.getEstado());
					libroEncontrado.setUnidadesDisponibles(nuevoLibro.getUnidadesDisponibles());
					libroEncontrado.setTipoFormato(nuevoLibro.getTipoFormato());
					libroEncontrado.setPrecio(nuevoLibro.getPrecio());
					libroEncontrado.setIdioma(nuevoLibro.getIdioma());
					libroEncontrado.setNumeroPaginas(nuevoLibro.getNumeroPaginas());
					flag = true;
					mensaje = "Libro actualizado";
				} catch (Exception e) {
					throw new LibroException("No se pudo actualizar");
				}
			}
		}
		if (libroEncontrado == null) {
			throw new LibroException("El libro no existe");
		}
		return mensaje;
	}

	/**
	 * Metodo que obtiene un libro por un codigo dado
	 *
	 * @param isbn
	 * @return
	 */
	public Libro obtenerLibro(String isbn) throws LibroException {
		Libro libroEncontrado = null;
		boolean flag = false;

		for (TextoLiterario textoLiterario : listaTextosLiterarios) {
			if (textoLiterario instanceof Libro && flag == false && textoLiterario != null
					&& ((Libro) textoLiterario).getIsbn().equals(isbn)) {
				libroEncontrado = (Libro) textoLiterario;
				flag = true;
			}
		}
		if (libroEncontrado == null) {
			throw new LibroException("El libro no existe");
		}
		return libroEncontrado;
	}

	/**
	 * Metodo que elimina un libro de acuerdo a su isbn
	 *
	 * @param isbn
	 * @return
	 * @throws LibroException
	 */
	public String eliminarLibro(String isbn) {
		String mensaje = "";
		Libro libro = null;
		boolean flag = false;

		try {
			libro = obtenerLibro(isbn);
			for (TextoLiterario textoLiterario : listaTextosLiterarios) {
				if (textoLiterario instanceof Libro && flag == false && textoLiterario != null
						&& ((Libro) textoLiterario) == libro) {
					textoLiterario = null;
					mensaje = "Libro eliminado correctamente";
					flag = true;
				}
			}
		} catch (Exception e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	// ---------------------------------------------------------------------------------------

	// CRUD Revista

	/**
	 * Metodo que crea una revista
	 *
	 * @param nuevaRevista
	 * @return
	 */
	public String crearRevista(Revista nuevaRevista) {
		String mensaje = "";
		int posicionDisponible = -1;
		boolean revistaVerificada;

		try {
			revistaVerificada = verificarRevista(nuevaRevista.getCodigo());
			posicionDisponible = obtenerPosicionDisponibleTextoLiterario();
			if (revistaVerificada == false && posicionDisponible != -1) {
				listaTextosLiterarios[posicionDisponible] = nuevaRevista;
				mensaje = "Revista Creada";
			}

		} catch (RevistaException | TextoLiterarioException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Este metodo verifica si la revista existe
	 *
	 * @param codigo
	 * @return
	 * @throws RevistaException
	 */
	private boolean verificarRevista(String codigo) throws RevistaException {
		boolean verificada = false;
		boolean flag = false;

		for (TextoLiterario textoLiterario : listaTextosLiterarios) {
			if (textoLiterario instanceof Revista && flag == false && textoLiterario != null
					&& textoLiterario.getCodigo().equals(codigo)) {
				verificada = true;
				flag = true;
				throw new RevistaException("La revista ya existe");
			}
		}
		return verificada;
	}

	/**
	 * Este metodo obtiene una revista a partir de un codigo
	 *
	 * @param codigo
	 * @return
	 * @throws RevistaException
	 */
	public Revista obtenerRevista(String codigo) throws RevistaException {
		Revista revistaEncontrada = null;
		boolean flag = false;

		for (TextoLiterario textoLiterario : listaTextosLiterarios) {
			if (textoLiterario instanceof Revista && flag == false && textoLiterario != null
					&& textoLiterario.getCodigo().equals(codigo)) {
				revistaEncontrada = (Revista) textoLiterario;
				flag = true;
			}
		}
		if (revistaEncontrada == null) {
			throw new RevistaException("La revista no existe");
		}
		return revistaEncontrada;
	}

	/**
	 * metodo para eliminar revista
	 *
	 * @param codigo
	 * @return
	 */
	public String eliminarRevista(String codigo) {
		String mensaje = "";
		Revista revista = null;
		boolean flag = false;

		try {
			revista = obtenerRevista(codigo);
			for (TextoLiterario textoLiterario : listaTextosLiterarios) {
				if (textoLiterario instanceof Revista && flag == false && textoLiterario != null
						&& ((Revista) textoLiterario) == revista) {
					textoLiterario = null;
					mensaje = "Revista eliminada correctamente";
					flag = true;
				}
			}
		} catch (RevistaException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Metodo que actualiza los datos de una revista
	 *
	 * @param nuevaRevista
	 * @return
	 * @throws RevistaException
	 * @throws TextoLiterarioException
	 */
	public String actualizarRevista(Revista nuevaRevista) throws RevistaException, TextoLiterarioException {
		String mensaje = "";
		Revista revistaEncontrada = null;
		boolean flag = false;

		for (TextoLiterario textoLiterario : listaTextosLiterarios) {
			if (textoLiterario instanceof Libro && flag == false && textoLiterario != null
					&& textoLiterario.getCodigo().equals(nuevaRevista.getCodigo())) {
				revistaEncontrada = (Revista) textoLiterario;
				try {
					revistaEncontrada.setIsbn(nuevaRevista.getIsbn());
					revistaEncontrada.setCategoria(nuevaRevista.getCategoria());
					revistaEncontrada.setTitulo(nuevaRevista.getTitulo());
					revistaEncontrada.setEditorial(nuevaRevista.getEditorial());
					revistaEncontrada.setEstado(nuevaRevista.getEstado());
					revistaEncontrada.setUnidadesDisponibles(nuevaRevista.getUnidadesDisponibles());
					revistaEncontrada.setTipoFormato(nuevaRevista.getTipoFormato());
					revistaEncontrada.setPrecio(nuevaRevista.getPrecio());
					revistaEncontrada.setIdioma(nuevaRevista.getIdioma());
					revistaEncontrada.setNumeroPaginas(nuevaRevista.getNumeroPaginas());
					flag = true;
					mensaje = "Revista actualizada";
				} catch (Exception e) {
					throw new RevistaException("Revista no actualizada");
				}
			}
		}
		if (revistaEncontrada == null) {
			throw new RevistaException("La revista no existe");
		}
		return mensaje;
	}

	// -------------------------------------------------------

	// CRUD Periodico

	/**
	 * Metodo para crear un periodico
	 *
	 * @param nuevoPeriodico
	 * @return
	 */
	public String crearPeriodico(Periodico nuevoPeriodico) {
		String mensaje = "";
		int posicionDisponible = -1;
		boolean periodicoVerificado;

		try {
			periodicoVerificado = verificarPeriodico(nuevoPeriodico.getCodigo());
			posicionDisponible = obtenerPosicionDisponibleTextoLiterario();
			if (periodicoVerificado == false && posicionDisponible != -1) {
				listaTextosLiterarios[posicionDisponible] = nuevoPeriodico;
				mensaje = "Periodico Creado";
			}

		} catch (PeriodicoException | TextoLiterarioException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Este metodo verifica si ya existe un periodico
	 *
	 * @param codigo
	 * @return
	 * @throws PeriodicoException
	 */
	private boolean verificarPeriodico(String codigo) throws PeriodicoException {
		boolean verificado = false;
		boolean flag = false;

		for (TextoLiterario textoLiterario : listaTextosLiterarios) {
			if (textoLiterario instanceof Periodico && flag == false && textoLiterario != null
					&& textoLiterario.getCodigo().equals(codigo)) {
				verificado = true;
				flag = true;
				throw new PeriodicoException("El periodico ya existe");
			}
		}
		return verificado;
	}

	/**
	 * este metodo busca un periodico por su codigo
	 *
	 * @param codigo
	 * @return el periodico encontrado
	 * @throws PeriodicoException
	 */
	public Periodico obtenerPeriodico(String codigo) throws PeriodicoException {
		Periodico periodicoEncontrado = null;
		boolean flag = false;

		for (TextoLiterario textoLiterario : listaTextosLiterarios) {
			if (textoLiterario instanceof Periodico && flag == false && textoLiterario != null
					&& textoLiterario.getCodigo().equals(codigo)) {
				periodicoEncontrado = (Periodico) textoLiterario;
				flag = true;
			}
		}
		if (periodicoEncontrado == null) {
			throw new PeriodicoException("El periodico no existe");
		}
		return periodicoEncontrado;
	}

	/**
	 * Este metodo elimina un periodico mediante el codigo
	 *
	 * @param codigo
	 * @return
	 */
	public String eliminarPeriodico(String codigo) {
		String mensaje = "";
		Periodico periodico = null;
		boolean flag = false;

		try {
			periodico = obtenerPeriodico(codigo);
			for (TextoLiterario textoLiterario : listaTextosLiterarios) {
				if (textoLiterario instanceof Periodico && flag == false && textoLiterario != null
						&& ((Periodico) textoLiterario) == periodico) {
					textoLiterario = null;
					mensaje = "Periodico eliminado correctamente";
					flag = true;
				}
			}
		} catch (PeriodicoException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Metodo que actualiza los atributos de un periodico
	 *
	 * @param nuevoPeriodico
	 * @return
	 * @throws PeriodicoException
	 */
	public String actualizarPeriodico(Periodico nuevoPeriodico) throws PeriodicoException {
		String mensaje = "";
		Periodico periodicoEncontrado = null;
		boolean flag = false;

		for (TextoLiterario textoLiterario : listaTextosLiterarios) {
			if (textoLiterario instanceof Libro && textoLiterario != null && flag == false
					&& textoLiterario.getCodigo().equals(nuevoPeriodico.getCodigo())) {
				periodicoEncontrado = (Periodico) textoLiterario;
				try {
					periodicoEncontrado.setTitulo(nuevoPeriodico.getTitulo());
					periodicoEncontrado.setEditorial(nuevoPeriodico.getEditorial());
					periodicoEncontrado.setEstado(nuevoPeriodico.getEstado());
					periodicoEncontrado.setUnidadesDisponibles(nuevoPeriodico.getUnidadesDisponibles());
					periodicoEncontrado.setTipoFormato(nuevoPeriodico.getTipoFormato());
					periodicoEncontrado.setPrecio(nuevoPeriodico.getPrecio());
					periodicoEncontrado.setIdioma(nuevoPeriodico.getIdioma());
					periodicoEncontrado.setNumeroPaginas(nuevoPeriodico.getNumeroPaginas());
					flag = true;
					mensaje = "Revista actualizada";
				} catch (Exception e) {
					throw new PeriodicoException("No se actualizo el periodico");
				}
			}
		}
		if (periodicoEncontrado == null) {
			throw new PeriodicoException("El periodico no existe");
		}
		return mensaje;
	}

	// ----------------------------------------------------------------------

	/**
	 * Este metodo obtiene la posicion disponible y en caso de no haber ninguno
	 * notifica al programa
	 *
	 * @return
	 * @throws TextoLiterarioException
	 */
	private int obtenerPosicionDisponibleTextoLiterario() throws TextoLiterarioException {
		int posicionDisponible = -1;
		for (int i = 0; i < listaTextosLiterarios.length && posicionDisponible == -1; i++) {
			if (listaTextosLiterarios[i] == null) {
				posicionDisponible = i;
			}
		}
		if (posicionDisponible == -1) {
			throw new TextoLiterarioException("No hay cupo");
		}
		return posicionDisponible;
	}

	// ----------------------------------------------------------------------

	// CRUD Cliente

	/**
	 * Metodo que crea un cliente
	 *
	 * @param nombre
	 * @param telefono
	 * @param cedula
	 * @param correo
	 * @return
	 */
	public String crearCliente(Cliente nuevoCliente) {
		String mensaje = "";
		int posicionDisponible = -1;
		boolean clienteVerificado;

		try {
			clienteVerificado = verificarCliente(nuevoCliente.getCedula());
			posicionDisponible = obtenerPosicionDisponibleClientes();
			if (clienteVerificado == false && posicionDisponible != -1) {
				listaClientes[posicionDisponible] = nuevoCliente;
				mensaje = "Cliente Creado";
			}

		} catch (ClienteException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Este metodo obtiene la posicion disponibles y en caso de no haber ninguna
	 * notifica al programa
	 *
	 * @return
	 * @throws ClienteException
	 */

	private int obtenerPosicionDisponibleClientes() throws ClienteException {
		int posicionDisponible = -1;
		for (int i = 0; i < listaClientes.length && posicionDisponible == -1; i++) {
			if (listaClientes[i] == null) {
				posicionDisponible = i;
			}
		}
		if (posicionDisponible == -1) {
			throw new ClienteException("No hay cupo");
		}
		return posicionDisponible;
	}

	/**
	 * Este metodo utiliza la cedula ingresada por el usuario para verificar si
	 * el cliente ya existe
	 *
	 * @param cedula
	 * @return
	 * @throws ClienteException
	 */
	private boolean verificarCliente(String cedula) throws ClienteException {
		boolean verificado = false;
		boolean flag = false;

		if (cedula.length() < 1 || !cedula.equals(String.class)) {
			throw new ClienteException("Se ingreso un parametro no valido");
		}
		for (Cliente cliente : listaClientes) {
			if (cliente != null && flag == false && cliente.getCedula().equals(cedula)) {
				verificado = true;
				flag = true;
				throw new ClienteException("El cliente ya existe");
			}
		}
		return verificado;
	}

	/**
	 * Metodo que actualiza los datos de un cliente
	 *
	 * @return
	 * @throws ClienteException
	 */
	public String actualizarCliente(Cliente nuevoCliente) throws ClienteException {
		String mensaje = "";
		Cliente clienteEncontrado = null;
		boolean flag = false;

		for (Cliente cliente : listaClientes) {
			if (cliente != null && flag == false && cliente.getCedula().equals(nuevoCliente.getCedula())) {
				clienteEncontrado = cliente;
				try {
					clienteEncontrado.setCedula(nuevoCliente.getCedula());
					clienteEncontrado.setCorreo(nuevoCliente.getCorreo());
					clienteEncontrado.setNombre(nuevoCliente.getNombre());
					clienteEncontrado.setTelefono(nuevoCliente.getTelefono());
					flag = true;
					mensaje = "Cliente actualizado";
				} catch (Exception e) {
					throw new ClienteException("Cliente no actualizado");
				}
			}
		}
		if (clienteEncontrado == null) {
			throw new ClienteException("El cliente no existe");
		}
		return mensaje;
	}

	/**
	 * Este metodo obtiene el cliente buscado
	 *
	 * @param cedula
	 * @return
	 * @throws ClienteException
	 */
	public Cliente obtenerCliente(String cedula) throws ClienteException {
		Cliente clienteEncontrado = null;
		boolean flag = false;

		for (Cliente cliente : listaClientes) {
			if (cliente != null && flag == false && cliente.getCedula().equals(cedula)) {
				clienteEncontrado = cliente;
				flag = true;
			}
		}
		if (clienteEncontrado == null) {
			throw new ClienteException("El cliente no existe");
		}
		return clienteEncontrado;

	}

	/**
	 * Metodo que elimina un cliente
	 *
	 * @param cedula
	 * @return
	 */
	public String eliminarCliente(String cedula) {
		String mensaje = "";
		Cliente clienteEncontrado = null;
		boolean flag = false;

		try {
			clienteEncontrado = obtenerCliente(cedula);
			for (Cliente cliente : listaClientes) {
				if (cliente != null && flag == false && clienteEncontrado == cliente) {
					cliente = null;
					mensaje = "Cliente eliminado correctamente";
					flag = true;
				}
			}
		} catch (ClienteException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	// ------------------------------------------------------------------------

	// CRUD vendedor

	/**
	 * Metodo que crea al vendedor
	 *
	 * @param nombre
	 * @param correo
	 * @param cedula
	 * @param direccion
	 * @param salario
	 * @return
	 */
	public String crearVendedor(Empleado nuevoVendedor) {
		String mensaje = "";
		int posicionDisponible = -1;
		boolean vendedorVerificado;

		try {
			vendedorVerificado = verificarVendedor(nuevoVendedor.getCedula());
			posicionDisponible = obtenerPosicionDisponibleEmpleados();
			if (vendedorVerificado == false && posicionDisponible != -1) {
				listaEmpleados[posicionDisponible] = (Vendedor) nuevoVendedor;
				mensaje = "Vendedor Creado";
			}

		} catch (EmpleadoException | VendedorException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Metodo que verifica si el vendedor existe
	 *
	 * @param cedula
	 * @return
	 * @throws VendedorException
	 */
	private boolean verificarVendedor(String cedula) throws VendedorException {
		boolean verificado = false;
		boolean flag = false;

		for (Empleado empleados : listaEmpleados) {
			if (empleados instanceof Vendedor && flag == false && empleados != null
					&& empleados.getCedula().equals(cedula)) {
				verificado = true;
				flag = true;
				throw new VendedorException("El vendedor ya existe");
			}
		}
		return verificado;
	}

	/**
	 * Metodo que actualiza los datos del vendedor
	 *
	 * @param nombre
	 * @param correo
	 * @param cedula
	 * @param direccion
	 * @param salario
	 * @return
	 * @throws VendedorException
	 */
	public String actualizarVendedor(Vendedor nuevoVendedor) throws VendedorException {
		String mensaje = "";
		Vendedor vendedorEncontrado = null;
		boolean flag = false;

		for (Empleado empleados : listaEmpleados) {
			if (empleados instanceof Vendedor && empleados != null && flag == false
					&& empleados.getCedula().equals(nuevoVendedor.getCedula())) {
				vendedorEncontrado = (Vendedor) nuevoVendedor;
				try {
					vendedorEncontrado.setNombre(nuevoVendedor.getNombre());
					vendedorEncontrado.setCedula(nuevoVendedor.getCedula());
					vendedorEncontrado.setCorreo(nuevoVendedor.getCorreo());
					vendedorEncontrado.setDireccion(nuevoVendedor.getDireccion());
					vendedorEncontrado.setSalario(nuevoVendedor.getSalario());
					flag = true;
					mensaje = "Vendedor actualizado";
				} catch (Exception e) {
					throw new VendedorException("Vendedor no actualizado");
				}
			}
		}
		if (vendedorEncontrado == null) {
			throw new VendedorException("El vendedor no existe");
		}
		return mensaje;
	}

	/**
	 * Metodo que obtiene al vendedor segun su cedula
	 *
	 * @param cedula
	 * @return
	 * @throws VendedorException
	 */
	private Vendedor obtenerVendedor(String cedula) throws VendedorException {
		Vendedor vendedorEncontrado = null;
		boolean flag = false;

		for (Empleado empleado : listaEmpleados) {
			if (empleado instanceof Vendedor && flag == false && empleado != null
					&& empleado.getCedula().equals(cedula)) {
				vendedorEncontrado = (Vendedor) empleado;
				flag = true;
			}
		}
		if (vendedorEncontrado == null) {
			throw new VendedorException("El vendedor no existe");
		}
		return vendedorEncontrado;
	}

	public String eliminarVendedor(String cedula) {
		String mensaje = "";
		Vendedor vendedor = null;
		boolean flag = false;

		try {
			vendedor = obtenerVendedor(cedula);
			for (Empleado empleados : listaEmpleados) {
				if (empleados instanceof Vendedor && flag == false && empleados != null
						&& ((Vendedor) empleados) == vendedor) {
					vendedor = null;
					mensaje = "Vendedor eliminado correctamente";
					flag = true;
				}
			}
		} catch (VendedorException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	// --------------------------------------------------------------------------

	// CRUD administrador

	/**
	 * Metodo que crea el administrador
	 *
	 * @param nombre
	 * @param correo
	 * @param cedula
	 * @param direccion
	 * @param salario
	 * @return
	 */
	public String crearAdministrador(Administrador nuevoAdministrador) {
		String mensaje = "";
		int posicionDisponible = -1;
		boolean administradorVerificado;

		try {
			administradorVerificado = verificarAdministrador(nuevoAdministrador.getCedula());
			posicionDisponible = obtenerPosicionDisponibleEmpleados();
			if (administradorVerificado == false && posicionDisponible != -1) {
				listaEmpleados[posicionDisponible] = (Administrador) nuevoAdministrador;
				mensaje = "Administrador Creado";
			}

		} catch (EmpleadoException | AdministradorException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Metodo que verifica si el administrador ya existe
	 *
	 * @param cedula
	 * @return
	 * @throws AdministradorException
	 */
	private boolean verificarAdministrador(String cedula) throws AdministradorException {
		boolean verificado = false;
		boolean flag = false;

		for (Empleado empleados : listaEmpleados) {
			if (empleados instanceof Administrador && flag == false && empleados != null
					&& empleados.getCedula().equals(cedula)) {
				verificado = true;
				flag = true;
				throw new AdministradorException("El vendedor ya existe");
			}
		}
		return verificado;
	}

	/**
	 * Metodo que actualiza los datos del administrador.
	 *
	 * @param nombre
	 * @param cedula
	 * @param direccion
	 * @param salario
	 * @param profesion
	 * @return
	 * @throws AdministradorException
	 */
	public String actualizarDatosAdministrador(Administrador nuevoAdministrador) throws AdministradorException {
		String mensaje = "";
		Administrador administradorEncontrado = null;
		boolean flag = false;

		for (Empleado empleados : listaEmpleados) {
			if (empleados instanceof Administrador && empleados != null && flag == false
					&& empleados.getCedula().equals(nuevoAdministrador.getCedula())) {
				administradorEncontrado = (Administrador) nuevoAdministrador;
				try {
					administradorEncontrado.setNombre(nuevoAdministrador.getNombre());
					administradorEncontrado.setCedula(nuevoAdministrador.getCedula());
					administradorEncontrado.setCorreo(nuevoAdministrador.getCorreo());
					administradorEncontrado.setDireccion(nuevoAdministrador.getDireccion());
					administradorEncontrado.setSalario(nuevoAdministrador.getSalario());
					flag = true;
					mensaje = "Administrador actualizado";
				} catch (Exception e) {
					throw new AdministradorException("Vendedor no actualizado");
				}
			}
		}
		if (administradorEncontrado == null) {
			throw new AdministradorException("El administrador no existe");
		}
		return mensaje;
	}

	/**
	 * Metodo que obtiene al administrador segun su cedula
	 *
	 * @param cedula
	 * @return
	 * @throws AdministradorException
	 */
	private Administrador obtenerAdministrador(String cedula) throws AdministradorException {
		Administrador administradorEncontrado = null;
		boolean flag = false;

		for (Empleado empleado : listaEmpleados) {
			if (empleado instanceof Administrador && flag == false && empleado != null
					&& empleado.getCedula().equals(cedula)) {
				administradorEncontrado = (Administrador) empleado;
				flag = true;
			}
		}
		if (administradorEncontrado == null) {
			throw new AdministradorException("El administrador no existe");
		}
		return administradorEncontrado;
	}

	public String eliminarAdministrador(String cedula) {
		String mensaje = "";
		Administrador administrador = null;
		boolean flag = false;

		try {
			administrador = obtenerAdministrador(cedula);
			for (Empleado empleados : listaEmpleados) {
				if (empleados instanceof Vendedor && flag == false && empleados != null
						&& ((Administrador) empleados) == administrador) {
					administrador = null;
					mensaje = "Vendedor eliminado correctamente";
					flag = true;
				}
			}
		} catch (AdministradorException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * Este metodo obtiene la posicion disponible y en caso de no haber ninguno
	 * notifica al programa
	 *
	 * @return
	 * @throws PeriodicoException
	 */
	private int obtenerPosicionDisponibleEmpleados() throws EmpleadoException {
		int posicionDisponible = -1;
		for (int i = 0; i < listaEmpleados.length && posicionDisponible == -1; i++) {
			if (listaEmpleados[i] == null) {
				posicionDisponible = i;
			}
		}
		if (posicionDisponible == -1) {
			throw new EmpleadoException("No hay cupo");
		}
		return posicionDisponible;
	}
}