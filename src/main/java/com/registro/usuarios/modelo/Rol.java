package com.registro.usuarios.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

// indicamos el nombre de la tabla 'rol' e indicamos que tiene una columna email y es unica
@Table(name = "rol")
public class Rol {
	// indicamos los atributos de nuestra clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;

	// generamos get y set
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

	// añadimos los contructores de todos
	public Rol(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// añadimos un contructor vacio
	public Rol() {

	}

	// añadimos contructor solo para Nombre
	public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}

}
