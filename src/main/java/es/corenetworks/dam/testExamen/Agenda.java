package es.corenetworks.dam.testExamen;

import es.corenetworks.dam.testExamen.utilidades.Constantes;
import es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException;
import es.corenetworks.dam.testExamen.utilidades.NumeroNotFoundException;
import es.corenetworks.dam.testExamen.utilidades.PosicionNoValidaException;
import es.corenetworks.dam.testExamen.utilidades.PosicionVaciaException;
import es.corenetworks.dam.testExamen.utilidades.Utilidades;

public class Agenda {
	
	
	private static int numeroContactos=0;
	private int[] agenda=new int [100];
	
	public Agenda() {
		this.agenda=new int [Constantes.TAMAÑO_AGENDA];
	}
	
	public Agenda(int tamanyo) {
		this.agenda=new int [tamanyo];
	}
	
	public int getTamanyoAgenda() {
		return numeroContactos;
	}
	
	public void añadirNumero(int telefono) throws NumeroNoValidoException {
		int logitud=Utilidades.getLongitudNumero(telefono);
		if(logitud!=8)
			throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
		boolean guardado = false;
		int i=0;
		while(i<agenda.length && !guardado) {
			if(agenda[i]==0) {
				agenda[i]=telefono;
				System.out.println("numero "+telefono + " anyadido");
				guardado=true;
				numeroContactos++;
			}
			i++;
		}
		
	}
	
	public  boolean eliminarNumero(int telefono) throws NumeroNoValidoException {
		
		int logitud=Utilidades.getLongitudNumero(telefono);
		if(logitud!=8)
			throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
		
		int posicion;
		try {
			posicion = buscarNumero(telefono);
			agenda[posicion]=0;
			System.out.println("numero "+telefono + " eliminado");
			numeroContactos--;
			return true;
		} catch (NumeroNotFoundException e) {
			return false;
		}
		
		
	}
	
	public  int buscarNumero(int numero) throws NumeroNotFoundException {
		int contador=0;
		boolean enc=false;
		int posicion=0;
		while(contador<agenda.length && !enc) {
			if(agenda[contador]==numero) {
				enc=true;
				posicion=contador;
			}
			contador++;
		}
		if(!enc) {
			throw new NumeroNotFoundException(Constantes.NUMERO_NOT_FOUND_EXCEPTION);
		}
		System.out.println("Numero encontrado en la posicion "+posicion);
		return posicion;
	}
	
	public int getNumeroEnPosicion(int posicion) throws PosicionVaciaException, PosicionNoValidaException {
		if(posicion > agenda.length-1 || posicion < 0)
			throw new PosicionNoValidaException(Constantes.POSICION_NO_VALIDA_EXCEPTION);
		int numero=0;
		numero=agenda[posicion];
		if(numero==0) throw new PosicionVaciaException(Constantes.POSICION_VACIA_EXCEPTION);
		System.out.println("numero en la posicion "+posicion+": "+numero);
		return numero;
	}
	
	public boolean estaVacia() {
		return numeroContactos==0;
	}

}
