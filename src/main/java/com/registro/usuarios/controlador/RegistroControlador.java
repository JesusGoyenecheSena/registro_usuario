package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.registro.usuarios.servicio.UsuarioServicio;

@Controller
public class RegistroControlador {

	@Autowired // inyectar el UsuarioServicio
	private UsuarioServicio servicio;
	
	@GetMapping("/login") // cuando entra a la aplicación retorna archivo html login
	public String iniciarSesion() {
		return "login";
	}
	
	@GetMapping("/") // cuando entre a vacio o a cualquier ruta envia siempre a login
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "index"; // se le pasa la lista de usuarios que obtenemos
	}
}
