package com.Tienda.logicanegocio;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.Tienda.Entidades.Productox;

@Component
public class AdminNegocioImplx extends UsuarioNegocioImplx implements AdminNegociox {

	@Override
	public Productox insertarProducto(Productox producto) {
		try {
			return daoProducto.insertar(producto);
		} catch (DuplicateKeyException e) {
			throw new ClaveDuplicadaException("el código de barras está duplicado", "producto", "codigoBarras", e);
		}catch (Exception e) {
			throw new LogicaNegocioException("Error no esperado al insertar");
		}
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
