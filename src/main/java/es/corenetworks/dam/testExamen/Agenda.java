package es.corenetworks.dam.testExamen;

import es.corenetworks.dam.testExamen.utilidades.Constantes;
import es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException;
import es.corenetworks.dam.testExamen.utilidades.NumeroNotFoundException;

public class Agenda {
	
	//ATRIBUTOS

	private int [] agenda;
	private int [] nuevoArray;
	public static int numElemento = 0;
	
	//CONSTRUCTORES
	
	public Agenda () {
		agenda = new int[Constantes.TAMAÑO_AGENDA];
	}
	
	public Agenda (int tamaño) {
		
		nuevoArray = new int [tamaño];
	}
	
	//MÉTODOS
	
	public int getTamanyoAgenda() {
		
        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i] != 0) {
                numElemento++;
            }
        }
        return numElemento;
	}
	
	public void añadirNumero(int telefono) throws NumeroNoValidoException {
	
		 // Comprobar que el número de teléfono tenga una longitud de 8 dígitos
		if (String.valueOf(telefono).length() != 8) {
            throw new NumeroNoValidoException("El número de teléfono no es válido.");
		}   
         // Buscar la primera posición libre de la agenda
            int posicion = -1;
            for (int i = 0; i < agenda.length; i++) {
                if (agenda[i] == 0) {
                    posicion = i;
                    break;
                }
            }
            
         // Si se encontró una posición libre, guardar el número de teléfono
            if (posicion != -1) {
                agenda[posicion] = telefono;
            } else {
                System.out.println("La agenda está llena. No se pudo añadir el número de teléfono.");
            }
	}
	
	
     public int buscarNumero(int numero) throws NumeroNotFoundException {
    	// Buscar el número de teléfono en la agenda
         for (int i = 0; i < agenda.length; i++) {
             if (agenda[i] == numero) {
                 return i;
             }
         }
         
         // Si no se encontró el número de teléfono, lanzar una excepción
         throw new NumeroNotFoundException("El número de teléfono no se encontró en la agenda.");
     }
     
     public boolean eliminarNumero(int numero) throws NumeroNoValidoException {
    	 
         // Buscar el número de teléfono en la agenda
         for (int i = 0; i < agenda.length; i++) {
             if (agenda[i] == numero) {
                 // Si se encontró el número de teléfono, eliminarlo de la agenda
                 agenda[i] = 0;
                 return true;
             }
         }
         // Si no se encontró el número de teléfono, devolver false
         return false;
     }
     
}
	

