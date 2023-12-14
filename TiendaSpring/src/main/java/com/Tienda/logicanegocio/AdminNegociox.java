package com.Tienda.logicanegocio;

import com.Tienda.Entidades.Productox;

public interface AdminNegociox extends UsuarioNegociox{
	
	Productox insertarProducto(Productox producto);
	
	Productox modificarProducto(Productox producto);
	
	void borrarProducto(Long id);

}
