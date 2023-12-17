package com.Tienda.presentacion.controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Tienda.Entidades.Productox;
import com.Tienda.logicanegocio.AdminNegociox;

@Controller
@RequestMapping("/admin")
public class AdminControlerx {

	@Autowired
	private AdminNegociox admin;

	@GetMapping
	private String index(Model modelo) {
		modelo.addAttribute("productos", admin.listadoProductos());
		return "admin/index";
	}

	@PostMapping
	private String post(Productox producto) {
		if (producto.getId() == null) {
			admin.insertarProducto(producto);
		} else {
			admin.modificarProducto(producto);
		}
		return "redirect:/admin";
	}

	@GetMapping("/borrar")
	private String borrar(Long id) {
		admin.borrarProducto(id);
		return "redirect:/admin";
	}

	@GetMapping("/detalle")
	public String detalle(Model modelo, Long id, Productox producto) {
		if (id != null) {
			modelo.addAttribute("producto", admin.detalleProducto(id));
		}
		return "admin/detalle";
	}
}
