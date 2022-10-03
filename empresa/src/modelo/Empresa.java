package modelo;

import java.util.Arrays;

public class Empresa {

	private String nombre;
	private Producto [] listaProductos;

	public Empresa(String nombre, int tamanioProductos){
		this.nombre = nombre;
		this.listaProductos = new Producto[tamanioProductos];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Producto[] getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(Producto[] listaProductos) {
		this.listaProductos = listaProductos;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", listaProductos=" + Arrays.toString(listaProductos) + "]";
	}

	//CRUD Producto

	public String crearProducto(String nombre,String codigo,double precio,TipoProducto tipoProducto){
		String mensaje = "";

		Producto productoEncontrado = null;

		productoEncontrado = buscarProducto2(codigo);
		if(productoEncontrado == null){
			int posicionDisponible = obtenerPosicionDisponibleProducto();

			if(posicionDisponible == -1){
				mensaje = "No hay disponibilidad para más productos ";
			}else{
				productoEncontrado = new Producto(nombre, codigo, precio, tipoProducto);
				listaProductos [posicionDisponible]  = productoEncontrado;
				mensaje = "Producto creado exitosamente";
			}

		}else{
			mensaje = "El producto ya existe en la empresa";
		}
		return mensaje;
	}

	private int obtenerPosicionDisponibleProducto() {
		int pos = -1;
		for (int i = 0; i < listaProductos.length && pos == -1; i++) {
			if(listaProductos [i] == null){
				pos = i;
			}
		}
		return pos;
	}

	private Producto buscarProducto1(String codigo) {
		Producto productoEncontrado = null;

		for (int i = 0; i < listaProductos.length; i++) {
			Producto productoAux = listaProductos[i];
			if(productoAux != null && productoAux.getCodigo().equals(codigo)){
				productoEncontrado = productoAux;
				break;
			}
		}
		return productoEncontrado;
	}

	private Producto buscarProducto2(String codigo) {
		Producto productoEncontrado = null;

		for (int i = 0; i < listaProductos.length && productoEncontrado == null; i++) {
			Producto productoAux = listaProductos[i];
			if(productoAux != null && productoAux.getCodigo().equals(codigo)){
				productoEncontrado = productoAux;
			}
		}
		return productoEncontrado;
	}


	private Producto buscarProducto3(String codigo) {
		Producto productoEncontrado = null;

		for (int i = 0; i < listaProductos.length; i++) {
			Producto productoAux = listaProductos[i];
			if(productoAux != null && productoAux.getCodigo().equals(codigo)){
				return productoAux;
			}
		}
		return productoEncontrado;
	}


	public String eliminarProducto(String codigo){
		String mensaje = "";
		int posProducto = obtenerPosicionProducto(codigo);
		if(posProducto == -1){
			mensaje = "Producto no existe";
		}else{
			listaProductos [posProducto] = null;
			mensaje = "Producto eliminado";
		}

		return mensaje;

	}

	private int obtenerPosicionProducto(String codigo) {
		int pos = -1;

		for (int i = 0; i < listaProductos.length; i++) {
			if(listaProductos[i] != null && listaProductos[i].getCodigo().equals(codigo)){
				return i;
			}
		}
		return pos;
	}

	// tiene que: actuliazar producto,hacer el CRUD empleado y buscar JUNIT
}
