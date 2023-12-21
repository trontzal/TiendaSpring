package com.Tienda.logicanegocio;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.Tienda.Entidades.Productox;

@Component
public class AdminNegocioImplx extends UsuarioNegocioImplx implements AdminNegociox {

	@Override
	public Productox insertarProducto(Productox producto) {
		try {
//			if (producto.getCodigoBarras().equals(producto.getNombre())) {
//				throw new LogicaNegocioException("No se admiten nombres iguales que un código de barras");
//			}
			return daoProducto.insertar(producto);
		} catch (DuplicateKeyException e) {
			System.out.println("aqui debajo rtieene que salir *****************************************************************************************************");
			System.out.println(e);
			String dato = e.getMessage().split("'")[1];
			System.out.println(dato);
			if (dato.equals(producto.getCodigoBarras())) {
				throw new ClaveDuplicadaException("el código de barras está duplicado", "producto", "codigoBarras", e);
			} else if (dato.equals(producto.getNombre())) {
				throw new ClaveDuplicadaException("ese nombre ya existe en la base de datos", "producto", "nombre", e);
			} else {
				throw new ClaveDuplicadaException("hay un campo duplicado", "producto", null, e);
			}
		} catch (LogicaNegocioException e) {
			throw e;
		} catch (Exception e) {
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
