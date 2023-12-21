package com.Tienda.presentacion.controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Tienda.Entidades.Productox;
import com.Tienda.logicanegocio.AdminNegociox;
import com.Tienda.logicanegocio.ClaveDuplicadaException;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminControlerx {

	@Autowired
	private AdminNegociox admin;

	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("productos", admin.listadoProductos());
		return "admin/index";
	}

	@PostMapping
	public String post(Model modelo, @Valid Productox producto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			modelo.addAttribute("alerta", "Revisa los errores del formulario");
			modelo.addAttribute("nivel", "danger");

			return "admin/detalle";
		}

		try {
			if (producto.getId() == null) {
				admin.insertarProducto(producto);
			} else {
				admin.modificarProducto(producto);
			}
		} catch (ClaveDuplicadaException e) {
			if(e.getCampo() != null) {
				modelo.addAttribute("alerta", "Revisa los errores del formulario");
				modelo.addAttribute("nivel", "danger");
				bindingResult.addError(new FieldError(e.getObjeto(), e.getCampo(), e.getMessage()));

			}else {
				modelo.addAttribute("alerta", e.getMessage());
				modelo.addAttribute("nivel", "danger");
			}
			return "admin/detalle";
		}
		return "redirect:/admin";
	}

	@GetMapping("/borrar")
	public String borrar(Long id) {
		admin.borrarProducto(id);
		return "redirect:/admin";
	}

	@GetMapping("/detalle")
	public String detalle(Model modelo, Long id, Productox producto) {
		if (id != null) {
			modelo.addAttribute("productox", admin.detalleProducto(id));
		}
		return "admin/detalle";
	}
}
