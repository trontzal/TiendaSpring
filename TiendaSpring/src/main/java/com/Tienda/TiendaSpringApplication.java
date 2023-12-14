package com.Tienda;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Tienda.AccesoDatos.DaoProductox;
import com.Tienda.Entidades.Productox;

@SpringBootApplication
public class TiendaSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TiendaSpringApplication.class, args);
	}

	@Autowired
	private DaoProductox daox;

	@Override
	public void run(String... args) throws Exception {

//		Productox producto = Productox.builder().nombre("Prueba").codigoBarras("1234567890128").precio(new BigDecimal("1234.12")).unidades(1).build();
//		producto = daox.insertar(producto);
		
//		Productox productoAModificar = daox.obtenerPorId(18L);
//		productoAModificar.setNombre("nombre modificado");
//		daox.modificar(productoAModificar);
		
//		daox.borrar(18L);
		
		for (Productox p : daox.obtenerTodos()) {
			System.out.println(p);
		}

//		System.out.println(daox.obtenerPorId(18L));
		
		

	}
}
