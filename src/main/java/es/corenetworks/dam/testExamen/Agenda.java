package es.corenetworks.dam.testExamen;

import es.corenetworks.dam.testExamen.utilidades.*;

public class Agenda {
	
	private int[] agenda;
	private static int contarElementos;
	
	public Agenda(){
		agenda = new int[Constantes.TAMAÑO_AGENDA];
	}
	
	public Agenda(int tamanyo) {
        agenda = new int[tamanyo];
        contarElementos = 0;
    }
	
	public int getTamanyoAgenda() {
		return contarElementos;
	}
	 public void añadirNumero(int num_telefono) throws NumeroNoValidoException {
	        if (Utilidades.getLongitudNumero(num_telefono) != 8) {
	            throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
	        }
	        
	        for (int i = 0; i < agenda.length; i++) {
	            if (agenda[i] == 0) {
	                agenda[i] = num_telefono;
	                contarElementos++;
	                return;
	            }
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
	 
	 public boolean eliminarNumero(int num_telefono) throws NumeroNoValidoException {
		 if(Utilidades.getLongitudNumero(num_telefono) != 8) {
			 throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
		 }
		 for(int i = 0; 1 < agenda.length; i++) {
			 if(agenda[i] == num_telefono) {
				 agenda[i] = 0;
				 contarElementos--;
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 public void getNumeroEnPosicion(int num_posicion) throws PosicionNoValidaException, PosicionVaciaException {
		 if (num_posicion < 0 || num_posicion > agenda.length) {
			 throw new PosicionNoValidaException(Constantes.POSICION_NO_VALIDA_EXCEPTION);
		 }
		 if (agenda[num_posicion] == 0) {
			 throw new PosicionVaciaException(Constantes.POSICION_VACIA_EXCEPTION);
		 }
	 }
	 public boolean estaVacia() {
	        if(contarElementos == 0) {
	        	return true;
	        } else {
	        	return false;
	        }
	    }
}


	
