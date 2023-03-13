package es.corenetworks.dam.testExamen;

import es.corenetworks.dam.testExamen.utilidades.Constantes;
import es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException;
import es.corenetworks.dam.testExamen.utilidades.NumeroNotFoundException;
import es.corenetworks.dam.testExamen.utilidades.PosicionNoValidaException;
import es.corenetworks.dam.testExamen.utilidades.PosicionVaciaException;
import es.corenetworks.dam.testExamen.utilidades.Utilidades;

public class Agenda {

	private int[] miArray;
	private static int contador;

	// Constructor vacio
	public Agenda() {

		miArray = new int[Constantes.TAMAÑO_AGENDA];
	}

	// Constructor con numero
	public Agenda(int num) {

		miArray = new int[num];
	}

	public int getTamanyoAgenda() {

		int cantNum = 0;

		for (int i = 0; i < miArray.length; i++) {

			if (i != 0) {
				cantNum += 1;
			}
		}

		return cantNum;
	}

	public void añadirNumero(int numTelefono) throws NumeroNoValidoException {

		if (Utilidades.getLongitudNumero(numTelefono) != 8) {

			throw new NumeroNoValidoException("Ese numero de telefono no es valido");

		} else {

			for (int i = 0; i < miArray.length; i++) {

				if (miArray[i] == 0) {

					miArray[i] = numTelefono;
				}
			}
		}
	}

	public int buscarNumero(int numTelefono) throws NumeroNotFoundException {

		int posicionTelefono = 0;
		int verificador = 0;

		for (int i = 0; i < miArray.length; i++) {

			if (miArray[i] == numTelefono) {

				posicionTelefono = miArray[i];
				verificador += 1;
			}

		}

		if (verificador == 0) {

			throw new NumeroNotFoundException("No esta el numero");

		} else {

			return posicionTelefono;

		}
	}

	public boolean eliminarNumero(int numTelefono) throws NumeroNotFoundException {
		int posicionTelefono = 0;
		int verificador = 0;
		boolean confirmador = false;

		if (Utilidades.getLongitudNumero(numTelefono) != 8) {

			throw new NumeroNotFoundException("Ese numero de telefono no es valido");

		} else {

			for (int i = 0; i < miArray.length; i++) {

				if (miArray[i] == numTelefono) {

					miArray[i] = 0;
					verificador += 1;
					confirmador = true;

				}

			}

			if (verificador == 0) {

				throw new NumeroNotFoundException("No esta el numero");
			}
		}
		return confirmador;
	}

	public int getNumeroEnPosicion(int posicion) throws PosicionVaciaException, PosicionNoValidaException {
		if (posicion < 0 || posicion >= miArray.length) {
			
			throw new PosicionNoValidaException("La posición no es una posición válida en el array.");
			
		} else if (miArray[posicion] == 0) {
			
			throw new PosicionVaciaException("La posición está vacía en el array.");
			
		} else {
			
			return miArray[posicion];
		}
	}
	
	
	
	public boolean estaVacia() {
		
		boolean todosCeros = true;

		for (int i = 0; i < miArray.length; i++) {
		    if (miArray[i] != 0) {
		        todosCeros = false;
		        break;
		    }
		}

      return todosCeros;
    }
	
	
	
	
	
	
	

}