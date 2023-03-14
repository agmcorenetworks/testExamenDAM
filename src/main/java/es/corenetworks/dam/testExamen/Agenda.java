package es.corenetworks.dam.testExamen;

import es.corenetworks.dam.testExamen.utilidades.Constantes;
import es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException;
import es.corenetworks.dam.testExamen.utilidades.NumeroNotFoundException;
import es.corenetworks.dam.testExamen.utilidades.PosicionNoValidaException;
import es.corenetworks.dam.testExamen.utilidades.PosicionVaciaException;
import es.corenetworks.dam.testExamen.utilidades.Utilidades;

public class Agenda {
	private int[] agenda;
	private static int numElementos;
	
	public Agenda() {
		agenda = new int[Constantes.TAMAÑO_AGENDA];
	}
	public Agenda(int tamaño) {
		agenda = new int[tamaño];
	}
	
	public int getTamanyoAgenda() {
		int salida = 0;
		for (int i=0;i<agenda.length;i++) {
			if (agenda[i]!=0) {
				salida += 1;
			}
		}
		return salida;
	}
	
	public void añadirNumero(int numeroTlf) throws NumeroNoValidoException {
		if (Utilidades.getLongitudNumero(numeroTlf)==8) {
			for (int i=0;i<agenda.length;i++) {
				if (agenda[i] == 0) {
					agenda[i] = numeroTlf;
					break;
				}
			}
		} else {
			throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
		}
	}
	
	
	public int buscarNumero(int numeroTlf) throws NumeroNotFoundException {
		int salida = -1;
		for (int i=0;i<agenda.length;i++) {
			if (agenda[i] == numeroTlf) {
				salida = i;
			}
		}
		if (salida == -1) {
			throw new NumeroNotFoundException(Constantes.NUMERO_NOT_FOUND_EXCEPTION);
		}
		return salida;
	}
	
	
	public boolean eliminarNumero(int numeroTlf) throws NumeroNoValidoException {
		boolean salida = false;
		if (Utilidades.getLongitudNumero(numeroTlf)==8) {
			for (int i=0;i<agenda.length;i++) {
				if (agenda[i] == numeroTlf) {
					agenda[i] = 0;
					salida = true;
				}
			}
		} else {
			throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
		}
		return salida;
	}
	
	
	public int getNumeroEnPosicion(int posicion) throws PosicionNoValidaException, PosicionVaciaException {
		int salida = -1;
		if (posicion < 0 || posicion > agenda.length) {
			throw new PosicionNoValidaException(Constantes.POSICION_NO_VALIDA_EXCEPTION);
		} else if (agenda[posicion]==0){
			throw new PosicionVaciaException(Constantes.POSICION_VACIA_EXCEPTION);
		} else {
			salida = agenda[posicion];
		}
		return salida;
	}
	
	
	public boolean estaVacia() {
		boolean salida = false;
		int contador = 0;
		for (int i = 0;i<agenda.length;i++) {
			if (agenda[i]!=0) {
				contador += 1;
			}
		}
		if (contador == 0) {
			salida = true;
		}
		return salida;
	}
	
}
