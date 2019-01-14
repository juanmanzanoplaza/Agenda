package org.iesalandalus.programacion.agenda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacto {
	private static final String ER_TELEFONO = "^[69][0-9]{8}$";
	private static final String ER_CORREO = "^[_-a-z0-9]+(\\.[_-a-z0-9]+)*@[-a-z0-9]+(\\.[-a-z0-9]+)*(\\.[a-z]{2,4})$";
	private String nombre;
	private String telefono;
	private String correo;

	public String getNombre() {
		return this.nombre;
	}

	private void setNombre(String nombre) throws IllegalArgumentException{
		if(nombre == null || nombre=="")
			throw new IllegalArgumentException("HAY QUE MIRAR QUE MENSAJE DEBE DAR");
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) throws IllegalArgumentException{
		Pattern p = Pattern.compile(ER_TELEFONO);
		Matcher m = p.matcher(telefono);
		if(m.matches())
			this.telefono = telefono;
		else
			throw new IllegalArgumentException("HAY QUE MIRAR QUE MENSAJE DEBE DAR");
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) throws IllegalArgumentException{
		Pattern p = Pattern.compile(ER_CORREO);
		Matcher m = p.matcher(correo);
		if(m.matches())
			this.correo = correo;
		else
			throw new IllegalArgumentException("HAY QUE MIRAR QUE MENSAJE DEBE DAR");
	}

}
