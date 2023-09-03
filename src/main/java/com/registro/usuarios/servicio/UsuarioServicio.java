package com.registro.usuarios.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Usuario;

// interface que tiene los metodos del servicio
public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios(); // metodo para listar los usuarios registrados en la BD
	
}
