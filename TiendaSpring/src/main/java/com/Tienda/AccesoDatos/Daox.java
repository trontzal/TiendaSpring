package com.Tienda.AccesoDatos;

public interface Daox<T> {
	default Iterable<T> obtenerTodos(){
		throw new AccesoDatosException("No implementado");
	}
	
	default T obtenerPorId(Long id) {
		throw new AccesoDatosException("No implementado");
	}
	
	default T insertar(T objeto) {
		throw new AccesoDatosException("No implementado");
	}
	
	default T modificar(T objeto) {
		throw new AccesoDatosException("No implementado");
	}
	
	default void borrar(Long id) {
		throw new AccesoDatosException("No implementado");
	}
	
	default long cuantosHay() {
		throw new AccesoDatosException("No implementado");
	}
}
