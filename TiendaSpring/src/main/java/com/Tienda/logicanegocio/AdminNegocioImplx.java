package com.Tienda.logicanegocio;

import org.springframework.stereotype.Component;

import com.Tienda.Entidades.Productox;

@Component
public class AdminNegocioImplx extends UsuarioNegocioImplx implements AdminNegociox {

	@Override
	public Productox insertarProducto(Productox producto) {
		// Aqui me falta meter codigo de validaciones
		return daoProducto.insertar(producto);
	}

	@Override
	public Productox modificarProducto(Productox producto) {
		return daoProducto.modificar(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		daoProducto.borrar(id);
	}

}
