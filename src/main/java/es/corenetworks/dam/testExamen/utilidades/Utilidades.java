package es.corenetworks.dam.testExamen.utilidades;

public class Utilidades {

	
	
	
	
	public static int getLongitudNumero(int numero) {
		
		  int digitos = 0;

	        while (numero != 0) {
	            numero /= 10;
	            digitos++;
	        }

	        return digitos;
		
	}
}
