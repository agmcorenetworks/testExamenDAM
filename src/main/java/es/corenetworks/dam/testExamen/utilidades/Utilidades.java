package es.corenetworks.dam.testExamen.utilidades;

public class Utilidades {
	
	public static int getLongitudNumero(int numero) {
		String cadenaNumero = Integer.toString(numero);
		int longitud = cadenaNumero.length();
		return longitud;
	}
}
