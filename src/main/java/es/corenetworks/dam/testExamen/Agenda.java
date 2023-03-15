package es.corenetworks.dam.testExamen;

import es.corenetworks.dam.testExamen.utilidades.Constantes;

import es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException;
import es.corenetworks.dam.testExamen.utilidades.NumeroNotFoundException;
import es.corenetworks.dam.testExamen.utilidades.PosicionNoValidaException;
import es.corenetworks.dam.testExamen.utilidades.PosicionVaciaException;
import es.corenetworks.dam.testExamen.utilidades.Utilidades;

public class Agenda {
	
	//Atributos de la clase.

		private int[] agenda;
		public int elementos = 0;

		// Constructor vacío
		public Agenda() {
			agenda = new int[Constantes.TAMAÑO_AGENDA];

		}

		// Constructor con parámetro tamaño agenda
		public Agenda(int tamano) {
			agenda = new int[tamano];
		}
		
		//Método para obtener el tamaño de la agenda
		public int getTamanyoAgenda() {
			return elementos;
		}
		
		//Método para comprobar el número de teléfono. Si no es válido, lanza una excepcón. 
		
		private void compruebaTelf(int numTelf) throws NumeroNoValidoException {
			if (Utilidades.getLongitudNumero(numTelf) != 8)
				throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
		}
		
		//Método para añadir número de teléfono. Si no es válido, lanza una excepción.
		public void añadirNumero(int numTelf) throws NumeroNoValidoException {
			compruebaTelf(numTelf);
			boolean agregado = false;
			for (int i = 0; i < agenda.length; i++) {
				if (agenda[i] == 0) {
					agenda[i] = numTelf;
					agregado = true;
					elementos++;
					break;
				}
			}
			if (agregado == false) {
				System.out.println("La agenda está llena.");
			}
		}
		
		//Método para buscar un número de teléfono. Si no encuentra el número, lanza una excepción.
		public int buscarNumero(int numTelf) throws NumeroNotFoundException {
			for (int i = 0; i < agenda.length; i++) {
				if (agenda[i] == numTelf) {
					return i;
				}
			}
			throw new NumeroNotFoundException(Constantes.NUMERO_NOT_FOUND_EXCEPTION);
		}
		
		
		//Método para eliminar un número de teléfono. Si el teléfono no es válido, lanza una excepción.
		public void eliminarNumero(int numTelf) throws NumeroNoValidoException {
			compruebaTelf(numTelf);
			boolean borrado = false;
			for (int i = 0; i < agenda.length; i++) {
				if (agenda[i] == numTelf) {
					agenda[i] = 0;
					elementos--;
					borrado = true;
					break;
				}
			}
			if (borrado == false) {
				System.out.println("El número de teléfono no existe.");
			}
		}
		
		//Método que recibe un entero que representa la posición en el array. Si la posición no es válida o está vacía, lanza la excepción correspondiente.
		public int getNumeroEnPosicion(int posicion) throws PosicionNoValidaException, PosicionVaciaException{
			if (posicion > agenda.length - 1)
				throw new PosicionNoValidaException(Constantes.POSICION_NO_VALIDA_EXCEPTION);
			if (agenda[posicion] == 0) {
				throw new PosicionVaciaException(Constantes.POSICION_VACIA_EXCEPTION);
			}

			return agenda[posicion];
		}

		// Asignando el valor a cero devolverá true si es cero y false en caso
		// contrario.
		//Este método devuelve true si la agenda está vacía y false si tiene números.
		public boolean estaVacia() {
			
			for(int i =0; i<agenda.length; i++) {
				if (agenda[i]!=0) {
					return false;
				}
			} return true;
		}

 }
     

	

