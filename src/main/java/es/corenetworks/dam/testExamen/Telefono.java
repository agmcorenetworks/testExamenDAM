package es.corenetworks.dam.testExamen;

import es.corenetworks.dam.testExamen.utilidades.NumeroNoValidoException;

public class Telefono {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Agenda agenda1 = new Agenda();
			try {
				agenda1.añadirNumero(12345678);
			} catch (NumeroNoValidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				agenda1.añadirNumero(87654321);
			} catch (NumeroNoValidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println(agenda1.eliminarNumero(87654321));
			} catch (NumeroNoValidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(agenda1.getTamanyoAgenda());
			
		}
}


