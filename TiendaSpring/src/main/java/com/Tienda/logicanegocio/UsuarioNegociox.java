package com.Tienda.logicanegocio;

import com.Tienda.Entidades.Productox;

public interface UsuarioNegociox {
	Iterable<Productox> listadoProductos();
	
	Productox detalleProducto(Long id);
	
}
