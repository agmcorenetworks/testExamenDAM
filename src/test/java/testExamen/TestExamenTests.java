package testExamen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import junit.framework.Test;



import es.corenetworks.dam.testExamen.Agenda;
import es.corenetworks.dam.testExamen.utilidades.Constantes;
import es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException;
import es.corenetworks.dam.testExamen.utilidades.NumeroNotFoundException;
import es.corenetworks.dam.testExamen.utilidades.PosicionNoValidaException;
import es.corenetworks.dam.testExamen.utilidades.PosicionVaciaException;
import es.corenetworks.dam.testExamen.utilidades.Utilidades;

public class TestExamenTests {
	
	int telefono1 = 62412343;
	int telefono2 = 72342344;

	int telefono3 = 72536844;
	int telefono4 = 43562344;

	// testing de la clas constantes

	// chequea que la clase existe y está en el paquete correcto
	@Test()
	public void checkClassConstantes() throws ClassNotFoundException {
		try {
			Class.forName("es.corenetworks.dam.testExamen.utilidades.Utilidades");
		} catch (ClassNotFoundException e) {
			fail("should have a class called Utilidades");
		}
	}

	// chequea que las constantes estan declaradas y tienen el valor correcto
	@Test()
	public void checkClassConstantes_constantes() throws ClassNotFoundException {
		assertEquals(Constantes.NUMERO_NO_VALIDO_EXCEPTION, "Numero no valido", "NUMERO_NO_VALIDO_EXCEPTION erroneo");
		assertEquals(Constantes.POSICION_VACIA_EXCEPTION, "No hay numero en esa posicion",
				"POSICION_VACIA_EXCEPTION erroneo");
		assertEquals(Constantes.POSICION_NO_VALIDA_EXCEPTION, "La posicion no es valida",
				"POSICION_NO_VALIDA_EXCEPTION erroneo");
		assertEquals(Constantes.TAMAÑO_AGENDA, 100, "TAMAÑO_AGENDA erroneo");
		assertEquals(Constantes.NUMERO_NOT_FOUND_EXCEPTION, "No se ha encontrado el numero",
				"NUMERO_NOT_FOUND_EXCEPTION erroneo");
	}

	@Test()
	public void checkExceptions_exists() {
		try {
			Class.forName("es.corenetworks.dam.testExamen.utilidades.NumeroNotFoundException");
			Class.forName("es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException");
			Class.forName("es.corenetworks.dam.testExamen.utilidades.PosicionNoValidaException");
			Class.forName("es.corenetworks.dam.testExamen.utilidades.PosicionVaciaException");
		} catch (ClassNotFoundException e) {
			fail(e.getMessage());
		}
	}

	@Test()
	public void checkClassUtilidades_getLongitudNumero() {
		assertEquals(Utilidades.getLongitudNumero(0), 1, "Utilidades.getLongitudNumero erroneo");
		assertEquals(Utilidades.getLongitudNumero(5), 1, "Utilidades.getLongitudNumero erroneo");
		assertEquals(Utilidades.getLongitudNumero(10), 2, "Utilidades.getLongitudNumero erroneo");
		assertEquals(Utilidades.getLongitudNumero(12345), 5, "Utilidades.getLongitudNumero erroneo");
		assertEquals(Utilidades.getLongitudNumero(123456), 6, "Utilidades.getLongitudNumero erroneo");
		assertEquals(Utilidades.getLongitudNumero(1234567), 7, "Utilidades.getLongitudNumero erroneo");
		assertEquals(Utilidades.getLongitudNumero(12345678), 8, "Utilidades.getLongitudNumero erroneo");
		assertEquals(Utilidades.getLongitudNumero(123456789), 9, "Utilidades.getLongitudNumero erroneo");
	}

	@Test()
	public void checkClassAgenda_exists() {
		try {
			Class.forName("es.corenetworks.dam.testExamen.Agenda");
		} catch (ClassNotFoundException e) {
			fail("should have a class called Utilidades");
		}
	}

	@Test()
	public void checkClassAgenda_constructorSinParametros() {
		Agenda myAgenda = new Agenda();
		assertNotNull(myAgenda);
	}

	@Test()
	public void checkClassAgenda_constructorConParametros() {
		Agenda myAgenda = new Agenda(10);
		assertNotNull(myAgenda);
	}

	@Test()
	public void checkClassAgenda_añadirNumero_tamañoAgenda() {
		Agenda myAgenda = new Agenda();

		
		try {
			System.out.println("agenda vacia: " + myAgenda.estaVacia());
			myAgenda.añadirNumero(telefono1);

			assertEquals(myAgenda.getTamanyoAgenda(), 1);

			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());

			assertFalse(myAgenda.estaVacia());

			myAgenda.añadirNumero(telefono2);

			assertEquals(myAgenda.getTamanyoAgenda(), 2);

			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());

			myAgenda.añadirNumero(telefono3);

			assertEquals(myAgenda.getTamanyoAgenda(), 3);

			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());

			myAgenda.añadirNumero(telefono4);

			assertEquals(myAgenda.getTamanyoAgenda(), 4);

			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());

		} catch (NumeroNoValidoException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test()
	public void checkClassAgenda_buscarNumero() {
		Agenda myAgenda = new Agenda();
		

		try {
			System.out.println("agenda vacia: " + myAgenda.estaVacia());

			myAgenda.añadirNumero(telefono1);
			assertEquals(myAgenda.getTamanyoAgenda(), 1);
			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());

			assertFalse(myAgenda.estaVacia());

			myAgenda.añadirNumero(telefono2);
			assertEquals(myAgenda.getTamanyoAgenda(), 2);

			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());
			myAgenda.getTamanyoAgenda();

			myAgenda.añadirNumero(telefono3);
			assertEquals(myAgenda.getTamanyoAgenda(), 3);
			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());

			myAgenda.añadirNumero(telefono4);
			assertEquals(myAgenda.getTamanyoAgenda(), 4);
			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());

			int posicion = myAgenda.buscarNumero(telefono1);
			assertEquals(posicion, 0);

			int posicion2 = myAgenda.buscarNumero(telefono2);
			assertEquals(posicion2, 1);

			int posicion3 = myAgenda.buscarNumero(telefono3);
			assertEquals(posicion3, 2);

			int posicion4 = myAgenda.buscarNumero(telefono4);
			assertEquals(posicion4, 3);

		} catch (NumeroNoValidoException e) {
			System.out.println(e.getMessage());
		} catch (NumeroNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test()
	public void checkClassAgenda_getNumeroEnPosicion() {
		Agenda myAgenda = new Agenda();

		try {
			System.out.println("agenda vacia: " + myAgenda.estaVacia());

			myAgenda.añadirNumero(telefono1);
			assertEquals(myAgenda.getTamanyoAgenda(), 1);
			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());

			assertFalse(myAgenda.estaVacia());

			myAgenda.añadirNumero(telefono2);
			assertEquals(myAgenda.getTamanyoAgenda(), 2);

			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());
			myAgenda.getTamanyoAgenda();

			myAgenda.añadirNumero(telefono3);
			assertEquals(myAgenda.getTamanyoAgenda(), 3);
			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());

			myAgenda.añadirNumero(telefono4);
			assertEquals(myAgenda.getTamanyoAgenda(), 4);
			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());

			int posicion = myAgenda.buscarNumero(telefono1);
			assertEquals(posicion, 0);
			int tfn = myAgenda.getNumeroEnPosicion(posicion);
			assertEquals(telefono1, tfn);

			int posicion2 = myAgenda.buscarNumero(telefono2);
			assertEquals(posicion2, 1);
			int tfn2 = myAgenda.getNumeroEnPosicion(posicion2);
			assertEquals(telefono2, tfn2);

			int posicion3 = myAgenda.buscarNumero(telefono3);
			assertEquals(posicion3, 2);
			int tfn3 = myAgenda.getNumeroEnPosicion(posicion3);
			assertEquals(telefono3, tfn3);

			int posicion4 = myAgenda.buscarNumero(telefono4);
			assertEquals(posicion4, 3);
			int tfn4 = myAgenda.getNumeroEnPosicion(posicion4);
			assertEquals(telefono4, tfn4);

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

	@Test()
	public void checkClassAgenda_eliminarNumero() {
		Agenda myAgenda = new Agenda();

	
		try {
			System.out.println("agenda vacia: " + myAgenda.estaVacia());

			myAgenda.añadirNumero(telefono1);
			assertEquals(myAgenda.getTamanyoAgenda(), 1);
			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());

			assertFalse(myAgenda.estaVacia());

			myAgenda.añadirNumero(telefono2);
			assertEquals(myAgenda.getTamanyoAgenda(), 2);

			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());
			myAgenda.getTamanyoAgenda();

			myAgenda.añadirNumero(telefono3);
			assertEquals(myAgenda.getTamanyoAgenda(), 3);
			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());

			myAgenda.añadirNumero(telefono4);
			assertEquals(myAgenda.getTamanyoAgenda(), 4);
			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());

			int posicion = myAgenda.buscarNumero(telefono1);
			assertEquals(posicion, 0);
			int tfn = myAgenda.getNumeroEnPosicion(posicion);
			assertEquals(telefono1, tfn);

			int posicion2 = myAgenda.buscarNumero(telefono2);
			assertEquals(posicion2, 1);
			int tfn2 = myAgenda.getNumeroEnPosicion(posicion2);
			assertEquals(telefono2, tfn2);

			int posicion3 = myAgenda.buscarNumero(telefono3);
			assertEquals(posicion3, 2);
			int tfn3 = myAgenda.getNumeroEnPosicion(posicion3);
			assertEquals(telefono3, tfn3);

			int posicion4 = myAgenda.buscarNumero(telefono4);
			assertEquals(posicion4, 3);
			int tfn4 = myAgenda.getNumeroEnPosicion(posicion4);
			assertEquals(telefono4, tfn4);
			

			myAgenda.eliminarNumero(telefono1);
			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());
			assertEquals(myAgenda.getTamanyoAgenda(), 3);

			System.out.println("agenda vacia: " + myAgenda.estaVacia());

			myAgenda.eliminarNumero(telefono2);
			System.out.println("tamanyo de la agenda: " + myAgenda.getTamanyoAgenda());
			System.out.println("agenda vacia: " + myAgenda.estaVacia());

		} catch (NumeroNoValidoException e) {
			System.out.println(e.getMessage());
		} catch (NumeroNotFoundException e) {
			System.out.println(e.getMessage());
		}  catch (PosicionVaciaException e) {
			System.out.println(e.getMessage());
		} catch (PosicionNoValidaException e) {
			System.out.println(e.getMessage());
		}
	}

}
