package com.Tienda.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Tienda.logicanegocio.UsuarioNegociox;

@Controller
@RequestMapping
public class IndexControllerx {
	@Autowired
	private UsuarioNegociox negocio;

//	@ResponseBody
	@GetMapping("/index")
	public String index(Model modelo) {
//		return negocio.listadoProductos().toString();
		modelo.addAttribute("productos", negocio.listadoProductos());
		return "index";
	}

//	@ResponseBody
	@GetMapping("/detalle")
	public String detalle(Model modelo, Long id) {
		modelo.addAttribute("producto", negocio.detalleProducto(id));
		return "detalle";
	}
}