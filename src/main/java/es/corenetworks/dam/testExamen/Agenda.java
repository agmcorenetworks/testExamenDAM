package es.corenetworks.dam.testExamen;
import es.corenetworks.dam.testExamen.utilidades.Constantes;
import es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException;
import es.corenetworks.dam.testExamen.utilidades.NumeroNotFoundException;
import es.corenetworks.dam.testExamen.utilidades.PosicionNoValidaException;
import es.corenetworks.dam.testExamen.utilidades.PosicionVaciaException;

public class Agenda {
	
	private int[] agenda;
	private static int cuentaElementosAgenda = 0;
	public int numero;
	public int posicionNum = 0;
	
	public Agenda() {
		agenda = new int[Constantes.TAMAÑO_AGENDA];
	}
	
	public Agenda(int tamaño) {
		agenda = new int[tamaño];
	}
	
	public int getTamañoAgenda(){
		int tamaño = 0;
		for (int numero : agenda) {
			if (numero != 0) {
				tamaño++;
			}
		}
		return tamaño;
	}
	
	public void añadirNumero(int numero) throws NumeroNoValidoException {
		String numeroAString = Integer.toString(numero);
		if (numeroAString.length() != 8) {
			throw new NumeroNoValidoException("El numero no es valido");
		}else {
			for (int i = 0; i < agenda.length; i++) {
				if(agenda[i] == 0) {
					agenda[i] = numero;
				}else {
					System.out.println("No hay espacios vacios");
				}
			}
		}
	}
	
	public int buscarNumero(int numero) throws NumeroNotFoundException {
		for (int i=0; i<agenda.length; i++) {
			if(agenda[i] == numero) {
				int posicionNum = i;
			}else {
				throw new NumeroNotFoundException("El numero no se ha encontrado");
				
			}
		}
		return posicionNum;
	}
	
	public boolean eliminarNumero(int numero) throws NumeroNoValidoException {
		String numeroAString = Integer.toString(numero);
		if(numeroAString.length() != 8) {
			throw new NumeroNoValidoException("El numero no es valido");
		}else {
			for (int i = 0; i<agenda.length; i++) {
				if(agenda[i] == numero) {
					agenda[i]=0;
				}
			}
		}
		return false;
	}
	
	public int getNumeroEnPosicion(int posicion) throws PosicionNoValidaException, PosicionVaciaException {
		if (posicion < 0 || posicion >= agenda.length) {
			throw new PosicionNoValidaException("La posicion no es valida");
		} else if (agenda[posicion] == 0) {
			throw new PosicionVaciaException("La posicion esta vacia");
		} else {
			return agenda[posicion];
		}
	}

	public boolean estaVacia() {
		for (int numero : agenda) {
			if (numero != 0) {
				return false;
			}
		}
		return true;
	}
}