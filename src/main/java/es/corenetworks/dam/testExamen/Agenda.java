package es.corenetworks.dam.testExamen;

import es.corenetworks.dam.testExamen.utilidades.Constantes;
import es.corenetworks.dam.testExamen.utilidades.NumeroNotFoundException;
import es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException;
import es.corenetworks.dam.testExamen.utilidades.PosicionNoValidaException;
import es.corenetworks.dam.testExamen.utilidades.PosicionVaciaException;

public class Agenda {
	private static int[] agenda;
	private static int contador = 0;

	public Agenda() {
		agenda = new int[Constantes.TAMAÑO_AGENDA];
	}

	public Agenda(int tamaño) {
		agenda = new int[tamaño];
	}

public int getTamanyoAgenda () {
		
		int elementos = 0;
		
		for (int i = 0 ; i < agenda.length ; i++) {
			
			if (agenda[i] != 0) {
				elementos += 1;
			}
		}
		
		return elementos;
		
	}

	public void añadirNumero(int numero) throws NumeroNoValidoException {
		if (String.valueOf(numero).length() != 8) {
			throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
		}
		boolean agregado = false;
		for (int i = 0; i < agenda.length && !agregado; i++) {
			if (agenda[i] == 0) {
				agenda[i] = numero;
				agregado = true;
				contador++;
			}
		}
		if (!agregado) {
			System.out.println("Agenda llena, no se pudo agregar el número.");
		}
	}

	public int buscarNumero(int numero) throws NumeroNotFoundException {
		for (int i = 0; i < agenda.length; i++) {
			if (agenda[i] == numero) {
				return i;
			}
		}
		throw new NumeroNotFoundException(Constantes.NUMERO_NOT_FOUND_EXCEPTION);
	}

	public boolean eliminarNumero(int numero) throws NumeroNoValidoException {
		if (String.valueOf(numero).length() != 8) {
			throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
		}
		for (int i = 0; i < agenda.length; i++) {
			if (agenda[i] == numero) {
				agenda[i] = 0;
				contador--;
				return true;
			}
		}
		return false;
	}

	public static int getNumeroEnPosicion(int posicion) throws PosicionNoValidaException, PosicionVaciaException {

		if (posicion < 0 || posicion > agenda.length) {

			throw new PosicionNoValidaException(Constantes.POSICION_NO_VALIDA_EXCEPTION);

		} else {

			if (agenda[posicion] == 0) {

				throw new PosicionVaciaException(Constantes.POSICION_VACIA_EXCEPTION);

			} else {

				return agenda[posicion];

			}
		}

	}

	public boolean estaVacia() {

		boolean estado = true;

		for (int i = 0; i < agenda.length; i++) {

			if (agenda[i] != 0) {

				estado = false;
			}

		}

		return estado;
	}
}
