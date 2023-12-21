package com.Tienda.AccesoDatos;

public interface Daox<T> {
	default Iterable<T> obtenerTodos(){
		throw new UnsupportedOperationException("No implementado");
	}
	
	default T obtenerPorId(Long id) {
		throw new UnsupportedOperationException("No implementado");
	}
	
	default T insertar(T objeto) {
		throw new UnsupportedOperationException("No implementado");
	}
	
	default T modificar(T objeto) {
		throw new UnsupportedOperationException("No implementado");
	}
	
	default void borrar(Long id) {
		throw new UnsupportedOperationException("No implementado");
	}
	
	default long cuantosHay() {
		throw new UnsupportedOperationException("No implementado");
	}
}
