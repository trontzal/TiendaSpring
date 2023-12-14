package com.Tienda.logicanegocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.Tienda.AccesoDatos.DaoProductox;
import com.Tienda.Entidades.Productox;

@Component
@Primary
class UsuarioNegocioImplx implements UsuarioNegociox{

	@Autowired
	protected DaoProductox daoProducto;
	
	@Override
	public Iterable<Productox> listadoProductos() {
		return daoProducto.obtenerTodos();
	}

	@Override
	public Productox detalleProducto(Long id) {
		return daoProducto.obtenerPorId(id);
	}
	
}
