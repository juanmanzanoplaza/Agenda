package org.iesalandalus.programacion.agenda;

public class Agenda {
	private static final int MAX_CONTACTOS = 100;
	private int numContactos;
	private Contacto[] contactos;
	
	public Agenda() {
		numContactos = 0;
		contactos = new Contacto[MAX_CONTACTOS];
	}
	
	public Contacto[] getContactos() {
		Contacto[] devolver = new Contacto[contactos.length];
		for(int i = 0; i < contactos.length; i++) {
			devolver[i] = contactos[i];
		}
		return devolver;
	}
	
	public int getNumContactos() {
		return numContactos;
	}

}
