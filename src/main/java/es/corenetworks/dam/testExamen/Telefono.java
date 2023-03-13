package es.corenetworks.dam.testExamen;

import es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException;
import es.corenetworks.dam.testExamen.utilidades.NumeroNotFoundException;
import es.corenetworks.dam.testExamen.utilidades.PosicionNoValidaException;
import es.corenetworks.dam.testExamen.utilidades.PosicionVaciaException;

public class Telefono {

	public static void main(String[] args) {
		Agenda myAgenda = new Agenda();

		int telefono1 = 62412343;
		int telefono2 = 72342344;

		try {
			System.out.println("agenda vacia: "+ myAgenda.estaVacia());
			myAgenda.añadirNumero(telefono1);
			System.out.println("tamanyo de la agenda: "+ myAgenda.getTamanyoAgenda());
			System.out.println("agenda vacia: "+ myAgenda.estaVacia());
			myAgenda.añadirNumero(telefono2);
			System.out.println("tamanyo de la agenda: "+ myAgenda.getTamanyoAgenda());
			myAgenda.getTamanyoAgenda();

			int posicion = myAgenda.buscarNumero(telefono1);
			int posicion2 = myAgenda.buscarNumero(telefono2);
			int tfn = myAgenda.getNumeroEnPosicion(posicion);
			
			
			
			myAgenda.eliminarNumero(telefono1);
			System.out.println("tamanyo de la agenda: "+ myAgenda.getTamanyoAgenda());
			System.out.println("agenda vacia: "+ myAgenda.estaVacia());
			
			myAgenda.eliminarNumero(telefono2);
			System.out.println("tamanyo de la agenda: "+ myAgenda.getTamanyoAgenda());
			System.out.println("agenda vacia: "+ myAgenda.estaVacia());				
			

		} catch (NumeroNoValidoException e) {
			System.out.println(e.getMessage());
		} catch (NumeroNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (PosicionVaciaException e) {
			System.out.println(e.getMessage());
		} catch (PosicionNoValidaException e) {
			System.out.println(e.getMessage());
		}
	}

}
