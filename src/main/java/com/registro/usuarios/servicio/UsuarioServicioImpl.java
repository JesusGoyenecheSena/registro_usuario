package com.registro.usuarios.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Rol;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.UsuarioRepositorio;

// implementacion del servicio
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}
// se implementa ale metodo de guardar, estamos sobre-escribiendo
	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombre(), 
				registroDTO.getApellido(),registroDTO.getEmail(),
				passwordEncoder.encode(registroDTO.getPassword()),Arrays.asList(new Rol("ROLE_USER")));
		return usuarioRepositorio.save(usuario); // guardamos el usuario con los datos y el Id es autoincrementable y la contraseña ya codificada
	}

	@Override // Cargar un usuario con sus datos
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByEmail(username);
		// si me devuelve un usuario vacio o null
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
	}
// mapear los roles a SimpleGrantedAuthority
	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}
	
	@Override //  para buscar todos los usuarios de la BD
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}
}
