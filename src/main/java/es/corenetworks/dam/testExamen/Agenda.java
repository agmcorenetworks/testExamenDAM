package es.corenetworks.dam.testExamen;

import es.corenetworks.dam.testExamen.utilidades.Constantes;
import es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException;
import es.corenetworks.dam.testExamen.utilidades.NumeroNotFoundException;
import es.corenetworks.dam.testExamen.utilidades.PosicionNoValidaException;
import es.corenetworks.dam.testExamen.utilidades.PosicionVaciaException;

public class Agenda {
	private static int[] agenda;
	private static int numContactos;
	
	public Agenda() {
		agenda = new int[Constantes.TAMAÑO_AGENDA];
	}
	
	public Agenda(int tamaño) {
		agenda = new int[tamaño];
	}

    public static int getTamanyoAgenda() {
    	int contador =0;
    	for (int i:agenda){
    		if (i !=0) {
    			contador++;
    		}
    	}
    	return contador;
    }
    	
    public void añadirNumero(int numero) throws NumeroNoValidoException {
    	String numeroStr = String.valueOf(numero);
    	if (numeroStr.length() != 8) {
    	throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
    	}
    	boolean numeroAñadido = false;
    	for (int i = 0; i < agenda.length && !numeroAñadido; i++) {
    		if (agenda[i] == 0) {
    	        agenda[i] = numero;
    	        numeroAñadido = true;
    	        numContactos++;
    	    }
    	}
    	    
    }
   
    public static int buscarNumero(int numero) throws NumeroNotFoundException {
        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i] == numero) {
                return i;
            }
        }
        throw new NumeroNotFoundException(Constantes.NUMERO_NOT_FOUND_EXCEPTION);
    }
   
    public boolean eliminarNumero(int numero) throws NumeroNoValidoException {
        String numeroStr = String.valueOf(numero);
        if (numeroStr.length() != 8) {
            throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
        }
        boolean numeroEliminado = false;
        for (int i = 0; i < agenda.length && !numeroEliminado; i++) {
            if (agenda[i] == numero) {
                agenda[i] = 0;
                numeroEliminado = true;
                numContactos--;
            }
        }
        return numeroEliminado;
    }
   
    public int getNumeroEnPosicion(int posicion) throws PosicionNoValidaException, PosicionVaciaException {
        if (posicion < 0 || posicion >= agenda.length) {
            throw new PosicionNoValidaException(Constantes.POSICION_NO_VALIDA_EXCEPTION);
        }
        if (agenda[posicion] == 0) {
            throw new PosicionVaciaException(Constantes.POSICION_VACIA_EXCEPTION);
        }
        return agenda[posicion];
    }

    public boolean estaVacia() {
        return numContactos == 0;
    }
    
    
    
    
    
    
    
    
    public static void main (String []args) {
	Agenda agenda = new Agenda(50);
	try {
		agenda.añadirNumero(21345678);
	} catch (NumeroNoValidoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
		
	}
	try {
		agenda.añadirNumero(12345678);
	} catch (NumeroNoValidoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
		
	}
	/*try {
		agenda.eliminarNumero(21345678);
	} catch (NumeroNoValidoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/
	try {
		agenda.getNumeroEnPosicion(2);
	} catch (PosicionNoValidaException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (PosicionVaciaException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		agenda.buscarNumero(12345678);
	} catch (NumeroNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// System.out.println (buscarNumero());

}
}












