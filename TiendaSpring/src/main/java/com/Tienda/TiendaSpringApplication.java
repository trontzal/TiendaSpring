package com.Tienda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Tienda.AccesoDatos.DaoProductox;
import com.Tienda.Entidades.Productox;

@SpringBootApplication
public class TiendaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaSpringApplication.class, args);
	}
	
	
	@Autowired
	private DaoProductox daox;
	
	public void run(String... args) throws Exception{
		for(Productox p: daox.obtenerTodos()) {}{
			System.out.println(p);
		}
	}
}
