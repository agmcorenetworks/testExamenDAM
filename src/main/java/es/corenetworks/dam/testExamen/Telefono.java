package es.corenetworks.dam.testExamen;

import es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException;
import es.corenetworks.dam.testExamen.utilidades.NumeroNotFoundException;
import es.corenetworks.dam.testExamen.utilidades.PosicionNoValidaException;
import es.corenetworks.dam.testExamen.utilidades.PosicionVaciaException;

public class Telefono {

	public static void main(String[] args) {
		Agenda agenda = new Agenda(20);
		try {
			agenda.añadirNumero(77777777);
			agenda.añadirNumero(12345678);
			agenda.añadirNumero(98765432);
		} catch (NumeroNoValidoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(agenda.getTamanyoAgenda());
		try {
			System.out.println(agenda.buscarNumero(12345678));
		} catch (NumeroNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(agenda.getNumeroEnPosicion(2));
		} catch (PosicionNoValidaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (PosicionVaciaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(agenda.estaVacia());
	}
}
