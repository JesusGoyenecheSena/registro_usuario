package com.registro.usuarios.controlador.dto;

public class UsuarioRegistroDTO {
// atributos de la clase iguales a los de Usuario
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
// generamos get y set para todos los atributos
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//generamos los constructores para todos los atributos
	public UsuarioRegistroDTO(String nombre, String apellido, String email, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}
//generamos un constructor vacio
	public UsuarioRegistroDTO() {

	}

}
