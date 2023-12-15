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
		return jdbc.query("SELECT * FROM productos", new BeanPropertyRowMapper<Productox>(Productox.class));
	}
	
	@Override
	public Productox obtenerPorId(Long id) {
		return jdbc.queryForObject("SELECT * FROM productos WHERE id=?", new BeanPropertyRowMapper<Productox>(Productox.class), id);
	}
	
	@Override
	public Productox insertar(Productox producto) {
	    jdbc.update("INSERT INTO productos (codigo_barras, nombre, precio, fecha_caducidad, unidades) VALUES (?, ?, ?, ?, ?)",
	            producto.getCodigoBarras(), producto.getNombre(), producto.getPrecio(), producto.getFechaCaducidad(), producto.getUnidades());
	    return producto;
	}
	
	@Override
	public Productox modificar(Productox producto) {
		jdbc.update("UPDATE productos SET codigo_barras=?, nombre=?, precio=?, fecha_caducidad=?, unidades=? WHERE id=?", producto.getCodigoBarras(), producto.getNombre(), producto.getPrecio(), producto.getFechaCaducidad(), producto.getUnidades(), producto.getId());
		return producto;
	}
	
	@Override
	public void borrar(Long id) {
		jdbc.update("DELETE FROM productos WHERE id=?", id);
	}

}
