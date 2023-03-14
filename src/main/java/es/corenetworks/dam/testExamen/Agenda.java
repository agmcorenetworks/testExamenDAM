package es.corenetworks.dam.testExamen;

import java.util.Arrays;

import es.corenetworks.dam.testExamen.utilidades.Constantes;
import es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException;
import es.corenetworks.dam.testExamen.utilidades.NumeroNotFoundException;
import es.corenetworks.dam.testExamen.utilidades.PosicionNoValidaException;
import es.corenetworks.dam.testExamen.utilidades.PosicionVaciaException;
import es.corenetworks.dam.testExamen.utilidades.Utilidades;

public class Agenda {
	// ATRIBUTOS
	private int[] mi_array;
	private static int contadorContactos;

	// CONSTRUCTOR SIN PARAMETROS
	public Agenda() {

		contadorContactos = 0;
		this.mi_array = new int[Constantes.TAMAÑO_AGENDA];
	}

	// Constructor con un parametro que será el tamaño de la agenda

	public Agenda(int num_array) {
		contadorContactos = 0; 
		this.mi_array = new int[num_array];
	}

	// Un metodo getTamanyoAgenda que devuelve el tamaño de la agenda como el numero
	// de contactos actuales(numeros de telefono guardados)

	public int getTamanyoAgenda() {
		return contadorContactos;
	}

	// Un metodo añadirNumero que recibe como parametro un numero de telefono y lo
	// guarda en la primera posicion libre de la agenda, una posicion esta libre si
	// contiene un cero, si la longitud del numero es disinto de 8 lanzará la
	// excepcion NUMERO_NO_VALIDO_EXCEPTION, en otro caso guardará el numero

	public void añadirNumero(int telefono) throws NumeroNoValidoException {

		int logitud = Utilidades.getLongitudNumero(telefono);
		if (logitud != 8)
			throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);

		boolean guardado = false;
		int i = 0;
		while (i < mi_array.length && !guardado) {
			if (mi_array[i] == 0) {
				mi_array[i] = telefono;
				System.out.println("numero " + telefono + " anyadido");
				guardado = true;
				contadorContactos++;
			}
			i++;
		}

	}

	// Un metodo buscarNumero que busca un numero en el array de la agenda y
	// devuelve la posicion del array en la que está el numero, si no encuentra el
	// numero lanzará la excepcion NUMERO_NOT_FOUND_EXCEPTION

	public int buscarNumero(int numero) throws NumeroNotFoundException {
		int contador = 0;
		boolean enc = false;
		int posicion = 0;
		while (contador < mi_array.length && !enc) {
			if (mi_array[contador] == numero) {
				enc = true;
				posicion = contador;
			}
			contador++;
		}
		if (!enc) {
			throw new NumeroNotFoundException(Constantes.NUMERO_NOT_FOUND_EXCEPTION);
		}
		System.out.println("Numero encontrado en la posicion " + posicion);
		return posicion;
	}

	public boolean eliminarNumero(int telefono) throws NumeroNoValidoException {

		int logitud = Utilidades.getLongitudNumero(telefono);
		if (logitud != 8)
			throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);

		int posicion;
		try {
			posicion = buscarNumero(telefono);
			mi_array[posicion] = 0;
			System.out.println("numero " + telefono + " eliminado");
			contadorContactos--;
			return true;
		} catch (NumeroNotFoundException e) {
			return false;
		}

	}

	public int getNumeroEnPosicion(int posicion) throws PosicionVaciaException, PosicionNoValidaException {
		if(posicion > mi_array.length-1 || posicion < 0)
			throw new PosicionNoValidaException(Constantes.POSICION_NO_VALIDA_EXCEPTION);
		int numero=0;
		numero=mi_array[posicion];
		if(numero==0) throw new PosicionVaciaException(Constantes.POSICION_VACIA_EXCEPTION);
		System.out.println("numero en la posicion "+posicion+": "+numero);
		return numero;
	} 

	public boolean estaVacia() {
		return contadorContactos==0;
	}


}
