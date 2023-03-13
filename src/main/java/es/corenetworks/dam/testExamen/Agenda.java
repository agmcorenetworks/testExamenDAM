package es.corenetworks.dam.testExamen;

import es.corenetworks.dam.testExamen.utilidades.Constantes;
import es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException;
import es.corenetworks.dam.testExamen.utilidades.NumeroNotFoundException;
import es.corenetworks.dam.testExamen.utilidades.PosicionNoValidaException;
import es.corenetworks.dam.testExamen.utilidades.PosicionVaciaException;

public class Agenda {
	
	private static int agenda [];
	
	private static int elementos;
	
	Agenda () {
		agenda = new int[Constantes.TAMAÑO_AGENDA];
	}
	
	Agenda (int tamaño) {
		agenda = new int [tamaño];
	}
	
	public int getTamanyoAgenda () {
		
		for (int i = 0 ; i < agenda.length ; i++) {
			
			if (agenda[i] != 0) {
				elementos += 1;
			}
		}
		
		return Agenda.elementos;
		
	}
	
	public void añadirNumero (int numero) throws NumeroNoValidoException {
		
		String numeroStr = Integer.toString(numero);
		
	    if (numeroStr.length() != 8) {
	        throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
	    }

	    int posicionLibre = -1;
	    
	    for (int i = 0; i < agenda.length; i++) {
	        if (agenda[i] == 0) {
	            posicionLibre = i;
	            break;
	        }
	    }

	    agenda[posicionLibre] = numero;
		
	}
	
	public int buscarNumero(int numero) throws NumeroNotFoundException {
		
	    for (int i = 0; i < agenda.length; i++) {
	        if (agenda[i] == numero) {
	            return i;
	        }
	    }

	    throw new NumeroNotFoundException(Constantes.NUMERO_NOT_FOUND_EXCEPTION);
	}

	public void eliminarNumero (int numero) throws NumeroNoValidoException {
		
        String numeroStr = Integer.toString(numero);
		
	    if (numeroStr.length() != 8) {
	        throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
	    }
		
		for (int i = 0 ; i < agenda.length ; i++) {
			if (agenda[i] == numero) {
				agenda[i] = 0;
			}
		}
		
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
	
	public boolean estaVacia () {
		
		boolean estado = true;
		
		for (int i = 0 ; i < agenda.length ; i++) {
			
			if (agenda[i] != 0) {
				
				estado = false;
			} 
			
		}
		
		return estado;
	}
	
}
