package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;

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

	public void anadir(Contacto anadir) throws OperationNotSupportedException {
		if(numContactos == MAX_CONTACTOS)
			throw new OperationNotSupportedException("La agenda está llena.");
		int indice = buscarPrimerIndiceComprobandoExistencia(anadir);
		if(indiceNoSuperaTamano(indice)) {
			contactos[indice] = anadir;
			numContactos++;
		} else
			throw new OperationNotSupportedException("Ya existe un contacto con ese nombre.");
		
	}

	private int buscarPrimerIndiceComprobandoExistencia(Contacto c) {
		for(int i = 0; i < contactos.length; i++) {
			if(contactos[i]!=null) {
				if(contactos[i].equals(c))
					return i;
			} else
				return i;
		}
		return MAX_CONTACTOS;
	}

	private boolean indiceNoSuperaTamano(int i) {
		if(i<numContactos)
			return false;
		return true;
	}

}
