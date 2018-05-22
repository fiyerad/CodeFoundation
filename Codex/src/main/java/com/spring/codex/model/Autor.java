package com.spring.codex.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long iD;
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	@OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "autor")
	//Importante: Cuidado con el mappedBy, es el nombre de la variable, no de la clase.
	private List<Libro> libros;
	
	public Autor() {

	}
	
	public Autor(String nombre, String apellido1, String apellido2) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

	public long getID() {
		return iD;
	}

	public void setID(long ID) {
		this.iD = ID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	@Override
	public int hashCode() {
		try {
			return (int) iD;
		} catch (Exception er) {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = obj instanceof Autor;
		Autor aut = res? (Autor)obj : null;
		return res && iD == aut.iD;
	}

	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + "]";
	}

	

}
