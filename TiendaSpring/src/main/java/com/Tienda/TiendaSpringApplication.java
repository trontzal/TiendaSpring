package com.Tienda;

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
	private DaoProductox daoProductox;
	
	@Override
    public void run(String... args) throws Exception {
        for (Productox p : daoProductox.obtenerTodos()) {
            System.out.println(p);
        }
    }
}
