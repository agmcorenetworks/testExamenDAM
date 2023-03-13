package es.corenetworks.dam.testExamen;

import java.util.Arrays;

import es.corenetworks.dam.testExamen.utilidades.Constantes;
import es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException;
import es.corenetworks.dam.testExamen.utilidades.NumeroNotFoundException;
import es.corenetworks.dam.testExamen.utilidades.PosicionNoValidaException;
import es.corenetworks.dam.testExamen.utilidades.Utilidades;

public class Agenda {
	// ATRIBUTOS
	private int[] mi_array;
	private static int contador;

	// CONSTRUCTOR SIN PARAMETROS
	public Agenda() {
		this.mi_array = new int[Constantes.TAMAÑO_AGENDA];
	}

	// Constructor con un parametro que será el tamaño de la agenda

	public Agenda(int num_array) {

		this.mi_array = new int[num_array];
	}

	// Un metodo getTamanyoAgenda que devuelve el tamaño de la agenda como el numero
	// de contactos actuales(numeros de telefono guardados)

	public int getTamanyoAgenda() {

		int contador_contactos = 0;

		for (int i = 0; i < mi_array.length; i++) {
			if (mi_array.length != 0) {
				contador_contactos++;
			}
		}
		return contador_contactos;
	}

	// Un metodo añadirNumero que recibe como parametro un numero de telefono y lo
	// guarda en la primera posicion libre de la agenda, una posicion esta libre si
	// contiene un cero, si la longitud del numero es disinto de 8 lanzará la
	// excepcion NUMERO_NO_VALIDO_EXCEPTION, en otro caso guardará el numero

	public void añadirNumero(int numeroTelefono) throws NumeroNoValidoException {

		if (Utilidades.getLongitudNumero(numeroTelefono) != 8) {
			throw new NumeroNoValidoException("NumeroNoValidoException");
		}

		else {

			for (int i = 0; i < mi_array.length; i++) {

				if (mi_array[i] == 0) {
					mi_array[i] = numeroTelefono;
				}

			}

		}

	}

	// Un metodo buscarNumero que busca un numero en el array de la agenda y
	// devuelve la posicion del array en la que está el numero, si no encuentra el
	// numero lanzará la excepcion NUMERO_NOT_FOUND_EXCEPTION

	public int buscarNumero(int busqueda) throws NumeroNotFoundException {

		int posicionTelefono = 0;
		int verificador = 0;

		for (int i = 0; i < mi_array.length; i++) {

			if (mi_array[i] == busqueda) {
				posicionTelefono = mi_array[i];
				verificador += 1;
			}
		}

		if (verificador == 0) {
			throw new NumeroNotFoundException("NumeroNotFoundException");
		} else {
			return posicionTelefono;
		}

	}

	public boolean eliminaNumero(int numeroTelef) throws NumeroNoValidoException, NumeroNotFoundException {

		boolean comprobador = false;
		int posicionTelefono = 0;
		int verificador = 0;

		if (Utilidades.getLongitudNumero(numeroTelef) != 8) {
			throw new NumeroNoValidoException("NumeroNoValidoException");
		} else {

			for (int i = 0; i < mi_array.length; i++) {

				if (mi_array[i] == numeroTelef) {
					mi_array[i] = 0;
					verificador += 1;
					comprobador = true;
				}
			}
		}

		if (verificador == 0) {
			throw new NumeroNotFoundException("NumeroNotFoundException");
		}

		return comprobador = true;
	}

	public int getNumeroEnPosicion(int posicion) throws PosicionNoValidaException {
		if (posicion < 0 || posicion >= mi_array.length) {

			throw new PosicionNoValidaException("La posición " + posicion + " no es una posición válida en el array.");

		} else if (mi_array[posicion] == 0) {

			throw new PosicionNoValidaException("La posición " + posicion + " está vacía en el array.");

		} else {

			return mi_array[posicion];
		}
	}

	public boolean estaVacia() {

		boolean todosCeros = true;

		for (int i = 0; i < mi_array.length; i++) {
			if (mi_array[i] != 0) {
				todosCeros = false;
				break;
			}
		}

		return todosCeros;
	}

}
