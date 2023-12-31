package com.Tienda.presentacion.controladores;

import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Tienda.bibliotecas.Alerta;
import com.Tienda.logicanegocio.UsuarioNegociox;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping
public class IndexControllerx implements ErrorController {

	@Autowired
	private UsuarioNegociox negocio;

//	@ResponseBody
	@GetMapping("/")
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

	@GetMapping("/login")
	public String login(String error, String logout, String noautorizado, String interactivo, Model modelo) {
		Alerta alerta = new Alerta(modelo);

		if (error != null) {
			alerta.danger("El usuario o la contraseña no son correctos");
		} else if (logout != null) {
			alerta.success("Se ha desconectado la sesion correctamente");
		} else if (noautorizado != null) {
			alerta.danger("Tu nivel de acceso  no es suficiente");
		} else if (interactivo != null) {
		} else {
			alerta.warning("Tienes que iniciar sesion");
		}

		return "login";
	}

	@GetMapping("/error")
	public String error(Model modelo, HttpServletRequest request, Exception exception) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		log.severe("Status: " + status.toString());
//		log.severe("Mensaje: " + exception.getMessage());
//		log.log(Level.SEVERE, "Detalles de la excepción", exception);

		do {
			log.severe("Tipo: " + exception.getClass().getSimpleName());
			log.severe("Mensaje: " + exception.getMessage());
			log.log(Level.SEVERE, "Detalles de la excepción", exception);

			exception = (Exception) exception.getCause();
		} while (exception != null);

		modelo.addAttribute("status", status);

		return "_error";
	}
}