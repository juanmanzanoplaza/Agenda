package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
	private static final String ERROR = "La opción seleccionada no se pudo realizar.";
	private static final String EXITO = "La opción seleccionada se realizó con éxito.";
	private static Agenda agenda = new Agenda();

	public static void main(String[] args) {
		int opcion;
		do {
			mostrarMenu();
			opcion = elegirOpcion();
			ejecutarOpcion(opcion);
		} while(opcion!=5);
		System.out.println("Fin de la ejecución.");
	}
	
	private static void mostrarMenu() {
		System.out.println("*************************************************************");
		System.out.println("*       PROGRAMA QUE GESTIONA UNA AGENDA DE CONTACTOS       *");
		System.out.println("*************************************************************");
		System.out.println("* 1 - Añadir un contacto.                                   *");
		System.out.println("* 2 - Buscar un contacto.                                   *");
		System.out.println("* 3 - Borrar un contacto.                                   *");
		System.out.println("* 4 - Listar contactos.                                     *");
		System.out.println("* 5 - Salir.                                                *");
		System.out.println("*************************************************************");
	}
	
	private static int elegirOpcion() {
		int lectura;
		do {
			System.out.println("¿Cuál de las opciones desea ejecutar? (1-5)");
			lectura = Entrada.entero();
		} while(lectura<1 || lectura>5);
		return lectura;
	}
	
	private static void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			anadirContacto();
			break;
		case 2:
			buscarContacto();
			break;
		case 3:
			borrarContacto();
			break;
		case 4:
			listarAgenda();
		}
	}
	
	private static void anadirContacto() {
		System.out.print("Introduzca el nombre del contacto:");
		String nombre = Entrada.cadena();
		System.out.print("Introduzca el teléfono del contacto:");
		String telefono = Entrada.cadena();
		System.out.print("Introduzca el correo del contacto:");
		String correo = Entrada.cadena();
		try {
			agenda.anadir(new Contacto(nombre, telefono, correo));
			System.out.println(EXITO);
		} catch (IllegalArgumentException i) {
			System.out.println(ERROR);
			System.out.println(i.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR);
			System.out.println(e.getMessage());
		}
	}
	
	private static void buscarContacto() {
		System.out.print("Introduzca el nombre del contacto a buscar:");
		String nombre = Entrada.cadena();
		Contacto c = agenda.buscar(nombre);
		if(c == null)
			System.out.println("El contacto no existe en la agenda.");
		else
			System.out.println("El contacto es: " + c);
	}
	
	private static void borrarContacto() {
		System.out.print("Introduzca el nombre del contacto a borrar:");
		String nombre = Entrada.cadena();
		try {
			agenda.borrar(nombre);
			System.out.println(EXITO);
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR);
			System.out.println(e.getMessage());
		}
	}
	
	private static void listarAgenda() {
		if(agenda.getNumContactos()==0) {
			System.out.println(ERROR);
			System.out.println("La agenda está vacía.");
		} else {
			System.out.println("Contactos existentes en la agenda:\n");
			Contacto[] contactos = agenda.getContactos();
			for(int i = 0; i<contactos.length && contactos[i]!=null; i++)
				System.out.println(contactos[i]);
			System.out.println(EXITO);
		}
	}
	
}
