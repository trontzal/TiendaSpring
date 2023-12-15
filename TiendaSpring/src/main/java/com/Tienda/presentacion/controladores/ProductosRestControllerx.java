package com.Tienda.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tienda.Entidades.Productox;
import com.Tienda.logicanegocio.AdminNegociox;

@RestController
@RequestMapping("/admin/productos")
public class ProductosRestControllerx {

	@Autowired
	private AdminNegociox admin;

	@GetMapping
	public Iterable<Productox> getTodos() {
		return admin.listadoProductos();
	}
	
	@GetMapping("/{id}")
	public Productox getId(@PathVariable Long id) {
		return admin.detalleProducto(id);
	}
	
	@PostMapping
	public Productox post(@RequestBody Productox producto) {
		return admin.insertarProducto(producto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		admin.borrarProducto(id);
	}
	
}
