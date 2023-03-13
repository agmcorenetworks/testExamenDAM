package es.corenetworks.dam.testExamen;
import es.corenetworks.dam.testExamen.utilidades.*;
public class Agenda {
	private int[] agenda;
	static int contador;
	
	public Agenda(){	
		agenda = new int [Constantes.TAMAÑO_AGENDA];
	}
	
	int getTamanyoAgenda() { //ESTA BIEN
		for (int i=0;i<agenda.length;i++) {
			if (agenda[i]!=0) {
				contador+=1;
			}
		}
		return contador;
	}
	
	void añadirNumero(int telefono) throws NumeroNoValidoException { //ESTA BIEN
	Utilidades uti = new Utilidades();
		if (uti.getLongitudNumero(telefono)==8) {
			for (int i=0;i<agenda.length;i++){
					if (agenda[i]==0) {
						agenda[i]=telefono;
						break;
					}
				}
			}
		
		else {
			throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
			}
		}
	
	int buscarNumero(int telefono) throws NumeroNotFoundException {
		int salida = -1;
		for (int i=0;i<agenda.length;i++) {
			if(agenda[i]==telefono) {
				return i;
			}
		}
		if (salida==-1) {
			throw new NumeroNotFoundException(Constantes.NUMERO_NOT_FOUND_EXCEPTION);
		}
		return salida;	
	}
	boolean eliminarNumero(int telefono) throws NumeroNoValidoException { //ESTA BIEN
	boolean salida = false;
	Utilidades uti = new Utilidades();
		if (uti.getLongitudNumero(telefono)==8) {
			for (int i=0;i<agenda.length;i++){
					if (agenda[i]==telefono) {
						agenda[i]=0;
						salida=true;
					}
				}
			}
		
		else {
			throw new NumeroNoValidoException(Constantes.NUMERO_NO_VALIDO_EXCEPTION);
			}
		return salida;
		}
	
	 int getNumeroEnPosicion(int pos) throws PosicionNoValidaException, PosicionVaciaException{
		int salida = -1;
		
		for (int i=0;i<agenda.length;i++) {
			if(agenda[i]==agenda[pos]) {
				salida = agenda[i];
					if(salida==0) {
						throw new PosicionVaciaException(Constantes.POSICION_VACIA_EXCEPTION);
					}
			}	
			else {
				throw new PosicionNoValidaException(Constantes.POSICION_NO_VALIDA_EXCEPTION);
			}
		}
		return salida;
	}
	 boolean estaVacia() {
		 boolean salida = true;
		 for (int i=0;i<agenda.length;i++) {
			 if (agenda[i]!=0) {
				 salida=false;
			 }
		 }
		 return salida;
	 }



}