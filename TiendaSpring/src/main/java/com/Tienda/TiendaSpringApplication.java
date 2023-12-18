package com.Tienda;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Tienda.AccesoDatos.DaoProductox;
import com.Tienda.Entidades.Productox;
import com.Tienda.logicanegocio.AdminNegociox;
import com.Tienda.logicanegocio.UsuarioNegociox;

@SpringBootApplication
public class TiendaSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TiendaSpringApplication.class, args);
	}

//	@Autowired
//	private DaoProductox daox;

//	@Autowired
//	private UsuarioNegociox usuario;
	
//	@Autowired
//	private UsuarioNegociox user;

	@Override
	public void run(String... args) throws Exception {
//		Productox productoAInsertar = Productox.builder().nombre("Prueba con logica").codigoBarras("1234567890123").precio(new BigDecimal("123")).unidades(34).build();
//		admin.insertarProducto(productoAInsertar);
		
//		for(Productox p: admin.listadoProductos()) {
//			System.out.println(p);
//		}
		
//		System.out.println(user.listadoProductos());
		
//		System.out.println(usuario.detalleProducto(1L));

		
		
		
		// Esta parte es la que se usaba llamando directemente al dao sin tener una logica de negocio
		
		
//		Productox producto = Productox.builder().nombre("Prueba").codigoBarras("1234567890128").precio(new BigDecimal("1234.12")).unidades(1).build();
//		producto = daox.insertar(producto);
		
//		Productox productoAModificar = daox.obtenerPorId(18L);
//		productoAModificar.setNombre("nombre modificado");
//		daox.modificar(productoAModificar);
		
//		daox.borrar(18L);
		
//		for (Productox p : daox.obtenerTodos()) {
//			System.out.println(p);
//		}

//		System.out.println(daox.obtenerPorId(18L));
		
		

	}
}
