package com.Tienda.AccesoDatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.Tienda.Entidades.Productox;

@Component
class DaoProductoJdbcx implements DaoProductox{
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Productox> obtenerTodos(){
		return jdbc.query("SELECT * FROM productosx", new BeanPropertyRowMapper<Productox>(Productox.class));
	}
}
