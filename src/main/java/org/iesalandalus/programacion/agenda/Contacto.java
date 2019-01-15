package org.iesalandalus.programacion.agenda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacto {
	private static final String ER_TELEFONO = "^[69][0-9]{8}$";
	private static final String ER_CORREO = "^[a-z0-9]+(\\.[a-z0-9]+)*@[a-z]+(\\.[a-z]+)*(\\.[a-z]{1,4})$";
	private String nombre;
	private String telefono;
	private String correo;

	public Contacto(String nombre, String telefono, String correo) {
		setNombre(nombre);
		setTelefono(telefono);
		setCorreo(correo);
	}

	public String getNombre() {
		return this.nombre;
	}

	private void setNombre(String nombre) throws IllegalArgumentException{
		if(nombre == null || nombre=="")
			throw new IllegalArgumentException("El nombre de un contacto no puede ser nulo o vacío.");
		this.nombre = nombre.trim();
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) throws IllegalArgumentException{
		if(telefono==null || telefono=="")
			throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacío.");
		Pattern p = Pattern.compile(ER_TELEFONO);
		Matcher m = p.matcher(telefono);
		if(m.matches())
			this.telefono = telefono;
		else
			throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) throws IllegalArgumentException{
		if(correo==null || correo=="")
			throw new IllegalArgumentException("El correo de un contacto no puede ser nulo o vacío.");
		Pattern p = Pattern.compile(ER_CORREO);
		Matcher m = p.matcher(correo);
		if(m.matches())
			this.correo = correo;
		else
			throw new IllegalArgumentException("El correo no tiene un formato válido.");
	}

	public String toString() {
		return getIniciales() + " [" + getTelefono() + ", " + getCorreo() + "]";
	}

	private String getIniciales() {
		String[] partes = nombre.split(" ");
		String iniciales = "";
		for (int i = 0; i < partes.length; i++) {
			if(!partes[i].equals(""))
				iniciales += partes[i].toUpperCase().charAt(0);
		}
		return iniciales;
	}

	/*
	public int hashCode() {

	}
	*/

	public boolean equals(Object o) {
		if(!(o instanceof Contacto))
			return false;
		Contacto otro = (Contacto) o;
		if(getNombre().toLowerCase().equals(otro.getNombre().toLowerCase()))
			return true;
		return false;
	}

}
